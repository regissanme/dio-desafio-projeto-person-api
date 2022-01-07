/*
 * Desafio de Projeto - Desenvolvendo um sistema de gerenciamento de pessoas
 * em API REST com Spring Boot.
 *
 * Bootcamp Java Cognizant da DIO
 * Especialista: Rodrigo Peleias (Desenvolvedor de Software Senior)
 * #teamJavaCog
 */
package br.com.dio.personapi.mapper;

import br.com.dio.personapi.dto.request.PersonDTO;
import br.com.dio.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Projeto: dio-desafio-projeto-person-api
 * <p>
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 05/01/2022
 * Hora: 18:39
 */
@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
