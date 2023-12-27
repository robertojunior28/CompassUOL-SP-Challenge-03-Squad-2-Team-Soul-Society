package br.com.compassuol.pb.challenge.controller;

import br.com.compassuol.pb.challenge.payload.LoginDto;
import br.com.compassuol.pb.challenge.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauth")
public class AuthController {

    @Autowired
    private AuthorizationService authorizationService;

    public AuthController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping("/token")
    public ResponseEntity login(@RequestBody LoginDto loginDto){
        try {
            return new ResponseEntity(authorizationService.login(loginDto.email(), loginDto.password()), HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}