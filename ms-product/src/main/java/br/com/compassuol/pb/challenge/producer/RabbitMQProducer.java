package br.com.compassuol.pb.challenge.producer;

import br.com.compassuol.pb.challenge.payload.UserDto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(UserDto user) {
        rabbitTemplate.convertAndSend(this.queue.getName(), user);
    }
}
