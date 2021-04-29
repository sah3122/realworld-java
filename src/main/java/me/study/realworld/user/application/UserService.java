package me.study.realworld.user.application;

import lombok.RequiredArgsConstructor;
import me.study.realworld.user.domain.User;
import me.study.realworld.user.domain.UserQueryRepository;
import me.study.realworld.user.domain.UserRepository;
import me.study.realworld.user.dto.SignInRequest.SignInDto;
import me.study.realworld.user.dto.UserResponse;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserQueryRepository userQueryRepository;

    public UserResponse signIn(SignInDto signInDto) {
        User user = signInDto.toEntity()
                             .encryptPassword();

        if (userQueryRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("이메일을 사용중입니다.");
        }

        User savedUser = userRepository.save(user);
        return new UserResponse(savedUser);
    }
}
