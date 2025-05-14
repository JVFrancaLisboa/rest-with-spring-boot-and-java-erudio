package br.com.jvfrancalisboa.repository;

import br.com.jvfrancalisboa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
