package me.study.realworld.user.vo;

import lombok.Getter;
import lombok.ToString;

import java.util.regex.Pattern;

@ToString
@Getter
public class Email {
    private static final Pattern EMAIL = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

    private final String email;

    public Email(String email) {
        valid(email);
        this.email = email;
    }

    private void valid(String email) {
        if (!EMAIL.matcher(email).matches()) {
            throw new IllegalArgumentException("Not Supported Email");
        }
    }
}
