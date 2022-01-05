package br.com.dio.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Projeto: dio-desafio-projeto-person-api
 * <p>
 * <p>
 * <p>
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 04/01/2022
 * Hora: 21:09
 */
@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @GetMapping
    public String getBook(){
        return "API Test";
    }
}
