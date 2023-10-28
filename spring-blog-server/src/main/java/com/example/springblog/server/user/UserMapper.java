package com.example.springblog.server.user;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User fromDto(UserDto userDto);

    UserDto toDto(User user);
}
