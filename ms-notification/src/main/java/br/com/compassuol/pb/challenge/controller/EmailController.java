package br.com.compassuol.pb.challenge.controller;

import br.com.compassuol.pb.challenge.payload.EmailDto;
import br.com.compassuol.pb.challenge.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @PostMapping("/send")
    public ResponseEntity sendEmail(@RequestBody EmailDto emailDto){

        return new ResponseEntity(emailService.sendEmail(emailDto), HttpStatus.OK);
    }

}
