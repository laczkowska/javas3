package com.example.updaters;

import com.example.contract.PersonDto;
import com.example.model.Person;
import com.example.updaters.clients.RandomDataClientDto;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PersonUpdater {

    public void updatePeople(int size) {
        Object dataClient;
        List<RandomDataClientDto> randomData = dataClient.getRandomData(size);
        List<PersonDto> personDtos = mapRandomDataToPersonDto(randomData);

        for (PersonDto personDto : personDtos) {
            SimpleJpaRepository personRepository = null;
            Person existingPerson = personRepository.findById(personDto.getId()).orElse(null);
            if (existingPerson != null) {
                existingPerson.setFirstName(personDto.getFirstName());
                existingPerson.setLastName(personDto.getLastName());
                personRepository.save(existingPerson);
            } else {
                Person newPerson = mapToEntity(personDto);
                personRepository.save(newPerson);
            }
        }
    }

    private Person mapToEntity(PersonDto personDto) {
        Person person = new Person();
        person.setId(personDto.getId());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        return person;
    }

    private List<PersonDto> mapRandomDataToPersonDto(List<RandomDataClientDto> randomData) {
        return randomData.stream()
                .map(data -> {
                    PersonDto personDto = new PersonDto();
                    personDto.setId(data.getId());
                    personDto.setFirstName(data.getFirstName());
                    personDto.setLastName(data.getLastName());
                    return personDto;
                })
                .collect(Collectors.toList());
    }
}
