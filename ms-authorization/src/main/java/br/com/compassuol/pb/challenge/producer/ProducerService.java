package br.com.compassuol.pb.challenge.producer;

import br.com.compassuol.pb.challenge.config.RabbitMqConstants;
import br.com.compassuol.pb.challenge.payload.LoginDto;
import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@Slf4j
public class ProducerService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitMqConstants rabbitMqConstants;

    public void sendMessage(@RequestBody LoginDto login) {
        log.info("message <{}>", login);
        rabbitTemplate.convertAndSend(rabbitMqConstants.exchange,rabbitMqConstants.routingkey,login);

    }
}
