/*
 * Desafio de Projeto - Desenvolvendo um sistema de gerenciamento de pessoas
 * em API REST com Spring Boot.
 *
 * Bootcamp Java Cognizant da DIO
 * Especialista: Rodrigo Peleias (Desenvolvedor de Software Senior)
 * #teamJavaCog
 */
package br.com.dio.personapi.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Projeto: dio-desafio-projeto-person-api
 * <p>
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 04/01/2022
 * Hora: 23:03
 */
@Data
@Builder
public class MessageResponseDTO {

    private String message;
}
