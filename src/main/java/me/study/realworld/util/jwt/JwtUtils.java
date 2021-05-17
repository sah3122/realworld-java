package me.study.realworld.util.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private static final Map<String, Object> HEADERS;

    private static final Long EXPIRED_TIME = 1000 * 60L * 60L * 2L;

    private static final String key = "dean";

    static {
        HEADERS = new HashMap<>();
        HEADERS.put("typ", "JWT");
        HEADERS.put("alg", "HS256");
    }

    public static String createToken(String payload) {
        // TODO payload Map 을 전달 받기
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

    public static Map<String, Object> verify(String jwt) {
        try {
            return Jwts.parser()
                        .setSigningKey(key.getBytes("UTF-8")) // Set Key
                        .parseClaimsJws(jwt) // 파싱 및 검증, 실패 시 에러
                        .getBody();
        } catch (ExpiredJwtException e) { // 토큰이 만료되었을 경우
            throw new TokenExpiredException();
        } catch (Exception e) { // 그외 에러났을 경우
            throw new RuntimeException();
        }
    }
}
