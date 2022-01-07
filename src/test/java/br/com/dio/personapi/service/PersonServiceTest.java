package br.com.dio.personapi.service;

import br.com.dio.personapi.dto.MessageResponseDTO;
import br.com.dio.personapi.dto.request.PersonDTO;
import br.com.dio.personapi.entity.Person;
import br.com.dio.personapi.exceptions.PersonNotFoundException;
import br.com.dio.personapi.mapper.PersonMapper;
import br.com.dio.personapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static br.com.dio.personapi.utils.PersonUtils.createFakeDTO;
import static br.com.dio.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Projeto: dio-desafio-projeto-person-api
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 06/01/2022
 * Hora: 17:51
 */
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDtoThenReturnMessege() {

        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    @Test
    void testGivenValidPersonIdTheReturnThisPerson() throws PersonNotFoundException {
        PersonDTO expectedPersonDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        expectedPersonDTO.setId(expectedSavedPerson.getId());

        expectedPersonDTO.getPhones().get(0)
                .setId(expectedSavedPerson.getPhones().get(0).getId());

        when(personRepository.findById(expectedSavedPerson.getId()))
                .thenReturn(Optional.of(expectedSavedPerson));


        PersonDTO personDTO = personService.findById(expectedSavedPerson.getId());

        assertEquals(expectedSavedPerson.getId(), personDTO.getId());

        assertEquals(expectedSavedPerson.getFirstName(), personDTO.getFirstName());

    }

    @Test
    void testGivenInvalidPersonIdThenThrowException() {
        var invalidPersonId = 1L;
        when(personRepository.findById(invalidPersonId))
                .thenReturn(Optional.ofNullable(any(Person.class)));

        assertThrows(PersonNotFoundException.class,
                () -> personService.findById(invalidPersonId));
    }

    @Test
    void testGivenNoDataThenReturnAllPeopleRegistered() {
        List<Person> expectedRegisteredPeoples =
                Collections.singletonList(createFakeEntity());

        PersonDTO personDTO = createFakeDTO();

        when(personRepository.findAll())
                .thenReturn(expectedRegisteredPeoples);

        List<PersonDTO> expectedPeoplesDTO = personService.listAll();

        assertFalse(expectedPeoplesDTO.isEmpty());
    }

    @Test
    void testGivenValidPersonIdAndUpdateInfoThenReturnSucessOnUpdate() throws PersonNotFoundException {
        var updatedPersonId = 2L;

        PersonDTO updatedPersonDTORequest = createFakeDTO();
        updatedPersonDTORequest.setId(updatedPersonId);
        updatedPersonDTORequest.setLastName("Sanme 41");

        Person expectedPersonToUpdate = createFakeEntity();
        expectedPersonToUpdate.setId(updatedPersonId);

        Person expectedPersonUpdated = createFakeEntity();
        expectedPersonUpdated.setId(updatedPersonId);
        expectedPersonToUpdate.setLastName(updatedPersonDTORequest.getLastName());

        when(personRepository.findById(updatedPersonId))
                .thenReturn(Optional.of(expectedPersonUpdated));


        when(personRepository.save(any(Person.class)))
                .thenReturn(expectedPersonUpdated);

        MessageResponseDTO expectedSuccessMessage =
                createExpectedMessageResponse(expectedPersonUpdated.getId());

        MessageResponseDTO successMessage =
                personService.update(updatedPersonId, updatedPersonDTORequest);

        assertEquals(expectedSuccessMessage, successMessage);

    }

    @Test
    void testGivenInvalidPersonIdAndUpdateInfoThenThrowExceptionOnUpdate() throws PersonNotFoundException {
        var invalidPersonId = 1L;

        PersonDTO updatePersonDTORequest = createFakeDTO();
        updatePersonDTORequest.setId(invalidPersonId);
        updatePersonDTORequest.setLastName("Sanme 41");

        when(personRepository.findById(invalidPersonId))
                .thenReturn(Optional.ofNullable(any(Person.class)));

        assertThrows(PersonNotFoundException.class,
                () -> personService.update(invalidPersonId, updatePersonDTORequest));
    }

    @Test
    void testGivenValidPersonIdThenReturnSuccesOnDelete() throws PersonNotFoundException {
        var deletedPersonId = 1L;

        Person expectedPersonToDelete = createFakeEntity();

        when(personRepository.findById(deletedPersonId))
                .thenReturn(Optional.of(expectedPersonToDelete));

        personService.delete(deletedPersonId);

        verify(personRepository, times(1))
                .deleteById(deletedPersonId);

    }

    @Test
    void testGivenInvalidPersonIdThenReturnSuccesOnDelete() throws PersonNotFoundException {
        var invalidPersonId = 1L;

        when(personRepository.findById(invalidPersonId))
                .thenReturn(Optional.ofNullable(any(Person.class)));

        assertThrows(PersonNotFoundException.class,
                () -> personService.delete(invalidPersonId));
    }


    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO.builder()
                .message("Pessoa salva com sucesso com ID: " + id)
                .build();
    }


}