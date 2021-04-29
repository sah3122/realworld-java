package me.study.realworld.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @JsonProperty("user")
    private LoginDto loginDto;

    @Getter
    @NoArgsConstructor
    public class LoginDto {
        private String username;

        private String password;
    }
}
