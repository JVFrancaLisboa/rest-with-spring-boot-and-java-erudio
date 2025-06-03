package br.com.jvfrancalisboa.services;

import br.com.jvfrancalisboa.exception.ResourceNotFoundException;
import br.com.jvfrancalisboa.model.Person;
import br.com.jvfrancalisboa.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepository;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(PersonServices.class);
    private AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    // find all people
    public List<Person> findAll(){
        logger.info("Finding all people");

        return personRepository.findAll();
    }

    // finding people by id
    public Person findById(Long id){
        logger.info("Finding one person");

        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    // Creating person
    public Person createPerson(Person person){
        logger.info("Creating one person");
        return personRepository.save(person);
    }

    // Updating person
    public Person updatePerson(Person person){
        logger.info("Updating one person");
        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    // Deleting person
    public void delete(Long id){
        logger.info("Deleting one person");

        Person entity = personRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        personRepository.delete(entity);
    }
}
