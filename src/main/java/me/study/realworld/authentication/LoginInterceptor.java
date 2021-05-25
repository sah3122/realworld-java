package me.study.realworld.authentication;

import me.study.realworld.common.exception.UnauthorizedException;
import me.study.realworld.util.jwt.JwtUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        if (!StringUtils.hasText(authorization)) {
            throw new UnauthorizedException();
        }
        Map<String, Object> authentication = JwtUtils.verify(authorization);
        AuthenticationThreadLocal.set(authentication);
        return true;
    }
}
