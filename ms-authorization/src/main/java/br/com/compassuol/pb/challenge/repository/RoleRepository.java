package br.com.compassuol.pb.challenge.repository;

import br.com.compassuol.pb.challenge.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
}
