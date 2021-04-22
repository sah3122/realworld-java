package me.study.realworld.user.application;

import lombok.RequiredArgsConstructor;
import me.study.realworld.user.domain.User;
import me.study.realworld.user.domain.UserRepository;
import me.study.realworld.user.dto.SignInRequest.UserRequest;
import me.study.realworld.user.dto.UserResponse;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserResponse signIn(UserRequest userRequest) {
        User user = userRequest.toEntity()
                               .encryptPassword();

        //userRepository.existsByEmail(user.getEmail());

        User savedUser = userRepository.save(user);
        return new UserResponse(savedUser);
    }
}
