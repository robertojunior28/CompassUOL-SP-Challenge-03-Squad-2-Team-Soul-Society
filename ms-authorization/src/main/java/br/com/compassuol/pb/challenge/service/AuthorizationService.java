package br.com.compassuol.pb.challenge.service;

import br.com.compassuol.pb.challenge.payload.LoginResponseDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthorizationService {
    UserDetails loadUserByUsername(String email);
    LoginResponseDto login(String username, String password);
}
