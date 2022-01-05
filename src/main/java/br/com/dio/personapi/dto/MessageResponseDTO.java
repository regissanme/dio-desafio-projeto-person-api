package br.com.dio.personapi.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Projeto: dio-desafio-projeto-person-api
 * <p>
 * <p>
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
