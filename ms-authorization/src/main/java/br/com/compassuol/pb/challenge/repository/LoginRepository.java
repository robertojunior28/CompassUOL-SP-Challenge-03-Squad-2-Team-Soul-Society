package br.com.compassuol.pb.challenge.repository;

import br.com.compassuol.pb.challenge.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findByEmail(String username);

    boolean existsByEmail(String email);
}
