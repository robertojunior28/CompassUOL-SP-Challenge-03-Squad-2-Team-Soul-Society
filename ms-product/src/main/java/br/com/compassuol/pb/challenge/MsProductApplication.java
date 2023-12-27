package br.com.compassuol.pb.challenge;

import br.com.compassuol.pb.challenge.entity.User;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MsProductApplication implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(MsProductApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(passwordEncoder.encode("123"));
	}
}
