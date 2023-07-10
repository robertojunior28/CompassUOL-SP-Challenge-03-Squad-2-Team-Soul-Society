package br.com.compassuol.pb.challenge.consumer;

import br.com.compassuol.pb.challenge.payload.LoginDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitReceiver {

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receiveFromRabbit(LoginDto loginDto) {
        log.info("queues <{}>", loginDto);
    }
}