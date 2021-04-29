package me.study.realworld.user.dto;

import lombok.Getter;
import me.study.realworld.user.domain.User;

@Getter
public class UserDto {
    private String email;

    private String token;

    private String username;

    private String bio;

    private String image;

    public UserDto(User user) {
        this.email = user.getEmail();
        this.username = user.getUsername();
    }
}
