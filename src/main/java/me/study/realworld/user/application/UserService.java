package me.study.realworld.user.application;

import lombok.RequiredArgsConstructor;
import me.study.realworld.user.domain.NotFoundException;
import me.study.realworld.user.domain.User;
import me.study.realworld.user.domain.UserQueryRepository;
import me.study.realworld.user.domain.UserRepository;
import me.study.realworld.user.dto.LoginRequest;
import me.study.realworld.user.dto.LoginRequest.LoginDto;
import me.study.realworld.user.dto.SignInRequest.SignInDto;
import me.study.realworld.user.dto.SignInResponse;
import me.study.realworld.util.PasswordUtils;
import org.springframework.stereotype.Service;

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

    public void login(LoginRequest loginRequest) {
        LoginDto loginDto = loginRequest.getLoginDto();

        String purePassword = PasswordUtils.decrypt(loginDto.getPassword());
        User user = userQueryRepository.findByUsernameAndPassword(loginDto.getUsername(), purePassword)
                                       .orElseThrow(() -> new NotFoundException());
    }
}
