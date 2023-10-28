package com.example.springblog.server.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<User> createUser(UserDto userDto) {
        if (userDto.getUsername() == null || userDto.getPassword() == null) {
            return Optional.empty();
        }
        var user = userMapper.fromDto(userDto);
        user.setId(null);
        user.setCreated(LocalDateTime.now());
        user.setPasswordHash(passwordEncoder.encode(userDto.getPassword()));
        return Optional.of(userRepository.save(user));
    }

    public boolean verifyUser(String username, String password) {
        return userRepository.findUserByUsername(username)
                .map(user -> passwordEncoder.matches(password, user.getPasswordHash()))
                .orElse(false);
    }
}
