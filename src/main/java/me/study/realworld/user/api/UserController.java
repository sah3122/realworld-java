package me.study.realworld.user.api;

import lombok.RequiredArgsConstructor;
import me.study.realworld.user.application.UserService;
import me.study.realworld.user.dto.LoginRequest;
import me.study.realworld.user.dto.LoginResponse;
import me.study.realworld.user.dto.SignInRequest;
import me.study.realworld.user.dto.SignInResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest signInRequest) {
        SignInResponse signInResponse = userService.signIn(signInRequest.getSignInDto());
        return ResponseEntity.ok(signInResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }
}
