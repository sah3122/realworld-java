package me.study.realworld.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import me.study.realworld.user.domain.User;
import me.study.realworld.user.vo.Email;

@Setter
@Getter
@ToString
public class SignInRequest {
    @JsonProperty("user")
    private UserRequest userRequest;

    @Getter
    @ToString
    @NoArgsConstructor
    public class UserRequest {
        private Email email;

        private String username;

        private String password;

        public User toEntity() {
            return User.of(email, username, password);
        }
    }
}
