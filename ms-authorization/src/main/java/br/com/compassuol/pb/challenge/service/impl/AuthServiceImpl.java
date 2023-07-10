package br.com.compassuol.pb.challenge.service.impl;

import br.com.compassuol.pb.challenge.entity.Role;
import br.com.compassuol.pb.challenge.exception.AuthMsException;
import br.com.compassuol.pb.challenge.repository.LoginRepository;
import br.com.compassuol.pb.challenge.entity.Login;
import br.com.compassuol.pb.challenge.payload.LoginDto;
import br.com.compassuol.pb.challenge.payload.RegisterDto;
import br.com.compassuol.pb.challenge.repository.RoleRepository;
import br.com.compassuol.pb.challenge.security.JwtTokenProvider;
import br.com.compassuol.pb.challenge.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private LoginRepository loginRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;


    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           LoginRepository loginRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.loginRepository = loginRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {

        if(loginRepository.existsByEmail(registerDto.getEmail())){
            throw new AuthMsException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        Login login = new Login();
        login.setEmail(registerDto.getEmail());
        login.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = new Role();
        userRole.setName("OPERATOR");
        roles.add(userRole);
        login.setRoles(roles);

        loginRepository.save(login);

        return "User registered successfully!.";
    }
}
