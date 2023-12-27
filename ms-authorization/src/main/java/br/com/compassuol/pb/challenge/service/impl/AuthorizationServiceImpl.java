package br.com.compassuol.pb.challenge.service.impl;

import br.com.compassuol.pb.challenge.entity.User;
import br.com.compassuol.pb.challenge.enums.UserRole;
import br.com.compassuol.pb.challenge.payload.LoginResponseDto;
import br.com.compassuol.pb.challenge.payload.RegisterDto;
import br.com.compassuol.pb.challenge.payload.UserDto;
import br.com.compassuol.pb.challenge.repository.UserRepository;
import br.com.compassuol.pb.challenge.security.TokenService;
import br.com.compassuol.pb.challenge.service.AuthorizationService;
import jakarta.persistence.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthorizationServiceImpl implements UserDetailsService, AuthorizationService {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByEmail(email);
    }
    public LoginResponseDto login(String username, String password){

        authenticationManager = context.getBean(AuthenticationManager.class);

        var usernamePassword = new UsernamePasswordAuthenticationToken(username, password);
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());


        return new LoginResponseDto(token);
    }


}
