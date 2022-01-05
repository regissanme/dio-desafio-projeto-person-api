package br.com.dio.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Projeto: dio-desafio-projeto-person-api
 * <p>
 * <p>
 * <p>
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 04/01/2022
 * Hora: 22:30
 */
@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    private final String description;
}
