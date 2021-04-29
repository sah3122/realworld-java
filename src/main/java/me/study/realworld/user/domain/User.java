package me.study.realworld.user.domain;

import lombok.*;
import me.study.realworld.user.vo.Email;
import me.study.realworld.util.PasswordUtils;

import javax.persistence.*;
import java.util.Base64;

@EqualsAndHashCode
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Email email;

    private String token;

    private String username;

    private String password;

    private String bio;

    private String image;

    public static User of(Email email, String username, String password) {
        return builder()
                .email(email)
                .username(username)
                .password(password)
                .build();
    }

    public User encryptPassword() {
        this.password = PasswordUtils.encrypt(password);
        return this;
    }

    // TODO Email 객체가 필요한 경우의 네이밍은 어떤게 좋을까 ?
    public String getEmail() {
        return email.getEmail();
    }
}
