package br.com.compassuol.pb.challenge.repository;


import br.com.compassuol.pb.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);


}
