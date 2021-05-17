package me.study.realworld.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import me.study.realworld.user.domain.User;

@Getter
@AllArgsConstructor
public class LoginResponse {
    @JsonProperty("user")
    private UserDto userDto;

    public LoginResponse(User user, String token) {
        userDto = new UserDto(user, token);
    }

}
