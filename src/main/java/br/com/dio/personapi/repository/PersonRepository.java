package br.com.dio.personapi.repository;

import br.com.dio.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Projeto: dio-desafio-projeto-person-api
 * <p>
 * <p>
 * <p>
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 04/01/2022
 * Hora: 22:54
 */
public interface PersonRepository extends JpaRepository<Person, Long> {


}
