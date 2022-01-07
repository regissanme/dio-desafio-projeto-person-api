package br.com.dio.personapi.utils;

import br.com.dio.personapi.dto.request.PhoneDTO;
import br.com.dio.personapi.entity.Phone;
import br.com.dio.personapi.enums.PhoneType;

/**
 * Projeto: dio-desafio-projeto-person-api
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 06/01/2022
 * Hora: 17:54
 */
public class PhoneUtils {

    private static final String PHONE_NUMER = "62 9.9999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final Long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .number(PHONE_NUMER)
                .type(PHONE_TYPE)
                .id(PHONE_ID)
                .build();
    }

}
