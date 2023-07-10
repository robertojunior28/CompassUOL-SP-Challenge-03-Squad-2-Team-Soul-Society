package br.com.compassuol.pb.challenge.producer;

import br.com.compassuol.pb.challenge.config.RabbitMqConstants;
import br.com.compassuol.pb.challenge.entity.User;
import br.com.compassuol.pb.challenge.payload.CategoryDto;
import br.com.compassuol.pb.challenge.payload.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class RabbitMQProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitMqConstants rabbitMqConstants;

    public void sendMessage(User user) {
        rabbitTemplate.convertAndSend(rabbitMqConstants.exchange,rabbitMqConstants.routingkey,user);
    }

    public void sendMessage(ProductDto productDto) {
        rabbitTemplate.convertAndSend(rabbitMqConstants.exchange,rabbitMqConstants.routingkey,productDto);
    }

    public void sendMessage(CategoryDto categoryDto) {
        rabbitTemplate.convertAndSend(rabbitMqConstants.exchange,rabbitMqConstants.routingkey,categoryDto);
    }
}
