package br.com.compassuol.pb.challenge.consumer;

import br.com.compassuol.pb.challenge.entity.Email;
import br.com.compassuol.pb.challenge.payload.EmailDto;
import br.com.compassuol.pb.challenge.service.impl.EmailServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailServiceImpl emailService;
    @Autowired
    ModelMapper mapper;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public ResponseEntity<EmailDto> listen(@Payload EmailDto emailDto) {
        Email email = new Email();
        email = mapper.map(emailDto, Email.class);
        emailService.save(email);
        return ResponseEntity.ok(mapper.map(email, EmailDto.class));

    }
}
