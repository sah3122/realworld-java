package me.study.realworld.user.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.study.realworld.user.domain.exception.UserNotFoundException;
import me.study.realworld.user.domain.User;
import me.study.realworld.user.domain.UserQueryRepository;
import me.study.realworld.user.domain.UserRepository;
import me.study.realworld.user.dto.LoginRequest;
import me.study.realworld.user.dto.LoginRequest.LoginDto;
import me.study.realworld.user.dto.LoginResponse;
import me.study.realworld.user.dto.SignInRequest.SignInDto;
import me.study.realworld.user.dto.SignInResponse;
import me.study.realworld.util.PasswordUtils;
import me.study.realworld.util.jwt.JsonWebToken;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserQueryRepository userQueryRepository;

    public SignInResponse signIn(SignInDto signInDto) {
        User user = signInDto.toEntity()
                             .encryptPassword();

        if (userQueryRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("이메일을 사용중입니다.");
        }

        User savedUser = userRepository.save(user);
        return new SignInResponse(savedUser);
    }

    public LoginResponse login(LoginRequest loginRequest) {
        LoginDto loginDto = loginRequest.getLoginDto();
        String purePassword = PasswordUtils.encrypt(loginDto.getPassword());
        return userQueryRepository.findByUsernameAndPassword(loginDto.getUsername(), purePassword)
                                  .map((user) -> new LoginResponse(user, JsonWebToken.createToken("")))
                                  .orElseThrow(() -> new UserNotFoundException("로그인 정보가 정확하지 않습니다."));
    }
}
