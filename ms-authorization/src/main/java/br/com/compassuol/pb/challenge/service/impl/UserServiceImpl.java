package br.com.compassuol.pb.challenge.service.impl;

import br.com.compassuol.pb.challenge.entity.User;
import br.com.compassuol.pb.challenge.enums.UserRole;
import br.com.compassuol.pb.challenge.exception.ResourceNotFoundException;
import br.com.compassuol.pb.challenge.payload.UserDto;
import br.com.compassuol.pb.challenge.payload.UserResponse;
import br.com.compassuol.pb.challenge.producer.UserProducer;
import br.com.compassuol.pb.challenge.repository.UserRepository;
import br.com.compassuol.pb.challenge.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper mapper;
    private PasswordEncoder passwordEncoder;
    private UserProducer userProducer;
    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper mapper,
                           PasswordEncoder passwordEncoder,
                           UserProducer userProducer) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.userProducer = userProducer;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapper.map(userDto,User.class);
        user.setUserRole(Collections.singletonList(UserRole.OPERATOR));
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User savedUser = userRepository.save(user);
        userProducer.publishMessageEmailRegister(savedUser);
        return mapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUser(Long id) {
        Optional user = userRepository.findById(id);
        return mapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setUserRole(userDto.getRoles());

        User updatedUser = userRepository.save(user);

        userProducer.publishMessageEmailUpdating(updatedUser);

        return mapper.map(updatedUser, UserDto.class);
    }

    @Override
    public String deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id));
        userRepository.deleteById(id);
        return "User deleted successful";
    }

    @Override
    public UserResponse getAllUser(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<User> users = userRepository.findAll(pageable);

        List<User> listOfUsers = users.getContent();

        List<UserDto> content = listOfUsers.stream().map(
                user -> mapper.map(user, UserDto.class)).collect(Collectors.toList());

        UserResponse userResponse = new UserResponse();
        userResponse.setContent(content);
        userResponse.setPageNo(users.getNumber());
        userResponse.setPageSize(users.getSize());
        userResponse.setTotalElements(users.getTotalElements());
        userResponse.setTotalPages(users.getTotalPages());
        userResponse.setLast(users.isLast());

        return userResponse;
    }


}

