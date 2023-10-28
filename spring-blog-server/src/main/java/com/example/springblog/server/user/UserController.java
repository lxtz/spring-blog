package com.example.springblog.server.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping(value = {"", "/"})
    public List<UserDto> getUsers() {
        return userService.getUsers().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping(value = {"/{id}", "/{id}/"})
    public UserDto getUser(@PathVariable Integer id) {
        var user = userService.getUser(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ""));
        return userMapper.toDto(user);
    }

    @PostMapping(value = {"", "/"})
    public void verifyUser(@RequestBody UserDto userDto) {
        if (!userService.verifyUser(userDto.getUsername(), userDto.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "");
        }
    }
}
