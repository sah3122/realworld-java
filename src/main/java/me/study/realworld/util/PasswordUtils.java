package me.study.realworld.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordUtils {

    public static String encrypt(String password) {
        return new String(Base64.getEncoder().encode(password.getBytes()));
    }

    public static String decrypt(String password) {
        return new String(Base64.getDecoder().decode(password.getBytes()));
    }
}
