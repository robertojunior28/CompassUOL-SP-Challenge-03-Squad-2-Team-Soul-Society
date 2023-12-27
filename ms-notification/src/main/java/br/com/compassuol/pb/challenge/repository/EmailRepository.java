package br.com.compassuol.pb.challenge.repository;

import br.com.compassuol.pb.challenge.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmailRepository extends JpaRepository<Email, Long> {
}
