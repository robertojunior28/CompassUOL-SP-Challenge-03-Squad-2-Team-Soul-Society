package br.com.compassuol.pb.challenge.repository;

import br.com.compassuol.pb.challenge.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
