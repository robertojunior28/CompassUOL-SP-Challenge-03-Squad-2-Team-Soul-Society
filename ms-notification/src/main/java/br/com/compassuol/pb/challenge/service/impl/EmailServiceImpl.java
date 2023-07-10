package br.com.compassuol.pb.challenge.service.impl;


import br.com.compassuol.pb.challenge.entity.Email;
import br.com.compassuol.pb.challenge.payload.EmailDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements br.com.compassuol.pb.challenge.service.EmailService {


    @Override
    public ResponseEntity<EmailDto> save(Email email) {
        return null;
    }
}
