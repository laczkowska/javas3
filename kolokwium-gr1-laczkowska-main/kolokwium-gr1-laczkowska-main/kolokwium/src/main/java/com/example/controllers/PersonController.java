package com.example.controllers;

import com.example.contract.PersonDto;
import com.example.updaters.clients.RandomDataClientDto;
import com.example.services.PersonService;
import com.example.updaters.clients.contract.RandomPersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllPeople() {
        List<PersonDto> people = personService.getAllPeople();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable Integer id) {
        PersonDto person = personService.getPersonById(id);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PersonDto> addPerson(@RequestBody PersonDto personDto) {
        PersonDto createdPerson = personService.addPerson(personDto);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable Integer id, @RequestBody PersonDto personDto) {
        PersonDto updatedPerson = personService.updatePerson(id, personDto);
        if (updatedPerson != null) {
            return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
        boolean deleted = personService.deletePerson(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/random")
    public List<RandomPersonDto> getRandomPeople(@RequestParam("size") int size) {
        PersonController randomDataClient;
        List<RandomDataClientDto> randomData = randomDataClient.getRandomPeople(size);
        List<RandomPersonDto> result = mapRandomDataToRandomPersonDto(randomData);
        return result;
    }

    private List<RandomPersonDto> mapRandomDataToRandomPersonDto(List<RandomDataClientDto> randomData) {
        return randomData.stream()
                .map(data -> {
                    RandomPersonDto randomPersonDto = new RandomPersonDto();
                    randomPersonDto.setId(data.getId());
                    randomPersonDto.setFirstName(data.getFirstName()); // Corrected set method
                    randomPersonDto.setLastName(data.getLastName());
                    return randomPersonDto;
                })
                .collect(Collectors.toList());
    }
}
