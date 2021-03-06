/*
 * Desafio de Projeto - Desenvolvendo um sistema de gerenciamento de pessoas
 * em API REST com Spring Boot.
 *
 * Bootcamp Java Cognizant da DIO
 * Especialista: Rodrigo Peleias (Desenvolvedor de Software Senior)
 * #teamJavaCog
 */
package br.com.dio.personapi.dto.request;

import br.com.dio.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 * Projeto: dio-desafio-projeto-person-api
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 05/01/2022
 * Hora: 17:56
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;

}
