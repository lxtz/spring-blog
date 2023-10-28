package com.example.springblog.server.user;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class UserDto {

    private Integer id;

    private String username;

    private String password;

    private LocalDateTime created;

    private boolean admin;

}
