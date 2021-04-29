package me.study.realworld.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import me.study.realworld.user.domain.User;

@Getter
@AllArgsConstructor
public class SignInResponse {

    @JsonProperty("user")
    private UserDto userDto;

    public SignInResponse(User user) {
        userDto = new UserDto(user);
    }
}
