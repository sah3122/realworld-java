package me.study.realworld.util.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JsonWebToken {
    private static final Map<String, Object> HEADERS;

    private static final Long EXPIRED_TIME = 1000 * 60L * 60L * 2L;

    private static final String key = "dean";

    static {
        HEADERS = new HashMap<>();
        HEADERS.put("typ", "JWT");
        HEADERS.put("alg", "HS256");
    }

    public static String createToken(String payload) {
        Date expireTime = new Date();
        expireTime.setTime(expireTime.getTime() + EXPIRED_TIME);

        Map<String, Object> payloads = new HashMap<>();
        payloads.put("data", payload);

        return Jwts.builder()
                   .setHeader(HEADERS)
                   .setClaims(payloads)
                   .setSubject("user")
                   .setExpiration(expireTime)
                   .signWith(SignatureAlgorithm.HS256, key.getBytes())
                   .compact();
    }
}
