package br.com.compassuol.pb.challenge.consumer;

import br.com.compassuol.pb.challenge.entity.Login;
import br.com.compassuol.pb.challenge.payload.LoginDto;
import br.com.compassuol.pb.challenge.payload.UserDto;
import br.com.compassuol.pb.challenge.repository.LoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitReceiver {

    private ModelMapper mapper;
    private LoginRepository loginRepository;
    @Autowired
    public RabbitReceiver(ModelMapper mapper, LoginRepository loginRepository) {
        this.mapper = mapper;
        this.loginRepository = loginRepository;
    }

//    @RabbitListener(queues = "${rabbitmq.queue}")
//    public void receiveFromRabbit(Object object) {
//        UserDto user = (UserDto)object;
//        Login login = new Login();
//        login.setEmail(user.getEmail());
//        login.setPassword(user.getPassword());
//        login.setRoles(user.getRoles());
//        loginRepository.save(login);
//
//    }
}
