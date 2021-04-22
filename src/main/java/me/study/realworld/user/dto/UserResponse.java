package me.study.realworld.user.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import me.study.realworld.user.domain.User;
import org.apache.logging.log4j.util.Strings;

@Getter
@AllArgsConstructor
public class UserResponse {

    private String email;

    private String token;

    private String username;

    private String bio;

    private String image;

    public UserResponse(User user) {
        this.email = user.getEmail();
        this.token = Strings.EMPTY;
        this.username = user.getUsername();
        this.bio = Strings.EMPTY;
        this.image = Strings.EMPTY;
    }
}
