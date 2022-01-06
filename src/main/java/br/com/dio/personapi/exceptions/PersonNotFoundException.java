package br.com.dio.personapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Projeto: dio-desafio-projeto-person-api
 * <p>
 * <p>
 * <p>
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 05/01/2022
 * Hora: 19:42
 */
 @ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {


    public PersonNotFoundException(Long id) {
        super("A pessoa com ID " + id + " não foi encontrada!");
    }
}
