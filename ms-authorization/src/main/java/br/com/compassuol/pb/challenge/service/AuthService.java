package br.com.compassuol.pb.challenge.service;


import br.com.compassuol.pb.challenge.payload.LoginDto;
import br.com.compassuol.pb.challenge.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
