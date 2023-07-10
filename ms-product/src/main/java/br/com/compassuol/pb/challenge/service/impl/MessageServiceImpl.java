package br.com.compassuol.pb.challenge.service.impl;

import br.com.compassuol.pb.challenge.service.MessageService;
import org.aspectj.bridge.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMessage(@RequestBody Message message) {
        rabbitTemplate.convertAndSend("queueName", message);
    }
}
