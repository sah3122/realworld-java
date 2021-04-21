package me.study.realworld.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import me.study.realworld.user.vo.Email;

@Setter
@ToString
public class SignInRequest {
    private UserRequest user;

    @Getter
    @ToString
    @NoArgsConstructor
    private class UserRequest {
        private Email email;

        private String username;

        private String password;
    }
}
