package br.com.compassuol.pb.challenge.repository;

import br.com.compassuol.pb.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
}
