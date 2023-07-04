package br.com.compassuol.pb.challenge.service;

import br.com.compassuol.pb.challenge.payload.UserDto;

import java.util.UUID;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUser(Long id);

    UserDto updateUser(UserDto userDto, Long id);
}
