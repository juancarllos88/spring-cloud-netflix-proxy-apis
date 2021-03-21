package br.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{
	
	Optional<Card> findByCpf(String cpf);

}
