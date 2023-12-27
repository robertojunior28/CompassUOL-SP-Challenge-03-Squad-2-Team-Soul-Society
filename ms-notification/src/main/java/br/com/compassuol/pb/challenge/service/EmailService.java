package br.com.compassuol.pb.challenge.service;

import br.com.compassuol.pb.challenge.entity.Email;
import br.com.compassuol.pb.challenge.payload.EmailDto;

public interface EmailService {
    Email save(EmailDto emailDto);

    Email sendEmail(EmailDto emailDto);
}
