package br.com.compassuol.pb.challenge.producer;

import br.com.compassuol.pb.challenge.entity.User;
import br.com.compassuol.pb.challenge.payload.EmailDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private RabbitTemplate rabbitTemplate;
    @Autowired
    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${spring.rabbitmq.queue}")
    private String routingKey;

    public void publishMessageEmailRegister(User userModel) {
        EmailDto emailDto = new EmailDto();
        emailDto.setFromEmail("semiti.aws@gmail.com");
        emailDto.setFromName("MS Products");
        emailDto.setTo(userModel.getEmail());
        emailDto.setReplyTo("semiti.aws@gmail.com");
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setBody(userModel.getFirstName() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

    public void publishMessageEmailUpdating(User userModel) {
        EmailDto emailDto = new EmailDto();
        emailDto.setFromEmail("semiti.aws@gmail.com");
        emailDto.setFromName("MS Products");
        emailDto.setTo(userModel.getEmail());
        emailDto.setReplyTo("semiti.aws@gmail.com");
        emailDto.setSubject("Atualização realizado com sucesso!");
        emailDto.setBody(userModel.getFirstName() + ", seu cadastro foi alterado! \nSe não foi você proteja sua conta redefinindo sua senha, \nCaso contrário desconsidere");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}
