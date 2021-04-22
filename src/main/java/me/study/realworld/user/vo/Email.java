package me.study.realworld.user.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.UniqueConstraint;
import java.util.regex.Pattern;

@ToString
@Getter
@Embeddable
public class Email {
    private static final Pattern EMAIL = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

    @Column(unique = true)
    private final String email;

    protected Email() {
        this.email = "";
    }

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
