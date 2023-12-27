package br.com.compassuol.pb.challenge.service;

import br.com.compassuol.pb.challenge.payload.UserDto;
import br.com.compassuol.pb.challenge.payload.UserResponse;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUser(Long id);

    UserDto updateUser(UserDto userDto, Long id);

    String deleteUser(Long id);

    UserResponse getAllUser(int pageNo, int pageSize, String sortBy, String sortDir);
}