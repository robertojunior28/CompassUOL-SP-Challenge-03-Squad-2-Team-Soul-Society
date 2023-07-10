package br.com.compassuol.pb.challenge.repository;

import br.com.compassuol.pb.challenge.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}
