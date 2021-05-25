package me.study.realworld.authentication;

import java.util.Map;

public class AuthenticationThreadLocal {
    private static final ThreadLocal<Map<String, Object>> AUTHENTICATION = new ThreadLocal<>();

    public static void set(Map<String, Object> authentication) {
        AUTHENTICATION.remove();
        AUTHENTICATION.set(authentication);
    }

    public static Map<String, Object> get() {
        return AUTHENTICATION.get();
    }


}
