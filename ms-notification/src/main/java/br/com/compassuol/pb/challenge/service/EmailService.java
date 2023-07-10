package br.com.compassuol.pb.challenge.service;

import br.com.compassuol.pb.challenge.entity.Email;
import br.com.compassuol.pb.challenge.payload.EmailDto;
import org.springframework.http.ResponseEntity;

public interface EmailService {
    ResponseEntity<EmailDto> save(Email email);
}
