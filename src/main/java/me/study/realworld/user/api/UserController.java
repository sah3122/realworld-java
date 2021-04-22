package me.study.realworld.user.api;

import lombok.RequiredArgsConstructor;
import me.study.realworld.user.application.UserService;
import me.study.realworld.user.dto.SignInRequest;
import me.study.realworld.user.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<UserResponse> signIn(@RequestBody SignInRequest signInRequest) {
        UserResponse userResponse = userService.signIn(signInRequest.getUserRequest());
        return ResponseEntity.ok(userResponse);
    }
}
