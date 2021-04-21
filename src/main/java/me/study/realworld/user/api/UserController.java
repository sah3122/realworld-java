package me.study.realworld.user.api;

import me.study.realworld.user.dto.SignInRequest;
import me.study.realworld.user.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/api/users")
    public ResponseEntity<UserResponse> signIn(@RequestBody SignInRequest signInRequest) {
        System.out.println(signInRequest);
        return null;
    }
}
