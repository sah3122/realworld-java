package me.study.realworld.config;

import me.study.realworld.common.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHadler {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> unauthorizedException(UnauthorizedException unauthorizedException) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                                           .message(unauthorizedException.getMessage())
                                           .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                             .body(errorResponse);
    }
}
