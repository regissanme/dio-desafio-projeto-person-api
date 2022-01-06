package br.com.dio.personapi.utils;

import br.com.dio.personapi.dto.request.PersonDTO;
import br.com.dio.personapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

/**
 * Projeto: dio-desafio-projeto-person-api
 * <p>
 * <p>
 * <p>
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 06/01/2022
 * Hora: 17:53
 */
public class PersonUtils {

    private static final String FIRST_NAME = "Regis";
    private static final String LAST_NAME = "Sanme";
    private static final String CPF_NUMBER = "86039598115";
    private static final Long PERSON_ID = 1l;
    private static final LocalDate BIRTH_DATE = LocalDate.of(2000,1,1);

    public static PersonDTO createFakeDTO(){
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("01-01-2000")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity(){
        return Person.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .id(PERSON_ID)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
