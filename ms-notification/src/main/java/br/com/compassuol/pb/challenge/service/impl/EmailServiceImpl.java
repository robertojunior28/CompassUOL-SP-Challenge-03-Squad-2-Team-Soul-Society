package br.com.compassuol.pb.challenge.service.impl;


import br.com.compassuol.pb.challenge.entity.Email;
import br.com.compassuol.pb.challenge.payload.EmailDto;
import br.com.compassuol.pb.challenge.repository.EmailRepository;
import br.com.compassuol.pb.challenge.service.EmailService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Email save(EmailDto emailDto) {
        Email email = mapper.map(emailDto, Email.class);
        return emailRepository.save(email);
    }

    @Transactional
    public Email sendEmail(EmailDto emailDto) throws MailException {
        Email email = new Email();
        email.setFromEmail(emailDto.getFromEmail());
        email.setFromName(emailDto.getFromName());
        email.setReplyTo(emailDto.getReplyTo());
        email.setToR(emailDto.getTo());
        email.setSubject(emailDto.getSubject());
        email.setBody(emailDto.getBody());
        email.setContentType("text/plain");
        Email emailSaved = emailRepository.save(email);
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailSaved.getFromEmail());
            System.out.println(emailSaved.getToR());
            message.setTo(emailSaved.getToR());
            message.setSubject(emailSaved.getSubject());
            message.setText(emailSaved.getBody());


            emailSender.send(message);

            return emailSaved;
        } catch (MailException m) {
            throw m;
        }
    }
}