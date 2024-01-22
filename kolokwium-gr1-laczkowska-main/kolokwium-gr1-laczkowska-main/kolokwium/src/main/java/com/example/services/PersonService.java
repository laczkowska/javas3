package com.example.services;

import com.example.contract.EmploymentDto;
import com.example.contract.PersonDto;
import com.example.updaters.clients.RandomDataClientDto;
import com.example.model.Employment;
import com.example.model.Person;
import com.example.repositories.EmploymentRepository;
import com.example.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final EmploymentRepository empRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, EmploymentRepository empRepository) {
        this.personRepository = personRepository;
        this.empRepository = empRepository;
    }

    public List<PersonDto> getRandomPeople(int size) {
        PersonService randomDataClient;
        List<RandomDataClientDto> randomData = randomDataClient.getRandomPeople(size);
        List<PersonDto> result = mapRandomDataToPersonDto(randomData);
        return result;
    }

    private List<PersonDto> mapRandomDataToPersonDto(List<RandomDataClientDto> randomData) {
        return randomData.stream()
                .map(data -> {
                    PersonDto personDto = new PersonDto();
                    personDto.setId(data.getId());
                    personDto.setFirstName(data.getFirstName());
                    personDto.setLastName(data.getLastName());
                    // Additional mapping for other fields
                    return personDto;
                })
                .collect(Collectors.toList());
    }

    public PersonDto getById(int id) {
        Person person = personRepository.findById(id).orElse(null);
        return mapToDto(person);
    }

    public PersonDto save(PersonDto personDto) {
        Person person = mapToEntity(personDto);
        person = personRepository.save(person);
        return mapToDto(person);
    }

    public PersonDto update(int personId, PersonDto personDto) {
        Person existingPerson = personRepository.findById(personId).orElse(null);
        if (existingPerson != null) {
            existingPerson.setFirstName(personDto.getFirstName());
            existingPerson.setLastName(personDto.getLastName());
            // ... other fields update
            existingPerson = personRepository.save(existingPerson);
            return mapToDto(existingPerson);
        }
        return null;
    }

    public void delete(int personId) {
        personRepository.deleteById(personId);
    }

    public void addEmployment(int personId, EmploymentDto employmentDto) {
        Person person = personRepository.findById(personId).orElse(null);
        if (person != null) {
            Employment employment = new Employment();
            employment.setPerson(person);
            empRepository.save(employment);
        }
    }

    public List<EmploymentDto> getEmployments(int personId) {
        Person person = personRepository.findById(personId).orElse(null);
        if (person != null) {
            List<Employment> employments = person.getEmployments();
            return employments.stream().map(this::mapToDto).collect(Collectors.toList());
        }
        return null;
    }

    private PersonDto mapToDto(Person person) {
        // map fields from person to PersonDto
        return new PersonDto();
    }

    private Person mapToEntity(PersonDto personDto) {
        return new Person();
    }

    private EmploymentDto mapToDto(Employment employment) {
        return new EmploymentDto();
    }


    public PersonDto addPerson(PersonDto personDto) {
    }

    public PersonDto updatePerson(Integer id, PersonDto personDto) {
    }

    public boolean deletePerson(Integer id) {
    }
}