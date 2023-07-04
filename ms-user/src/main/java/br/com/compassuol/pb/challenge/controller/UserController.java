package br.com.compassuol.pb.challenge.controller;

import br.com.compassuol.pb.challenge.payload.UserDto;
import br.com.compassuol.pb.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        UserDto userDto = userService.getUser(id);
        return ResponseEntity.ok(userDto);

    }
    @PutMapping("/{id}")
    public  ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,
                                               @PathVariable Long id){
        return ResponseEntity.ok(userService.updateUser(userDto, id));
    }

}
