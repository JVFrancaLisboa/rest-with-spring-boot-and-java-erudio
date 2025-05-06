package br.com.jvfrancalisboa;

import br.com.jvfrancalisboa.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        var persons = new ArrayList<Person>();
        for (int i = 1; i <= 8; i++) {
            Person person = MockPerson(i);
            persons.add(person);
        }
        return persons;
    }


    public Person findById(String id){
        logger.info("Finding one person");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setAddress("Uberlândia");
        person.setGender("Male");
        return person;
    }

    private Person MockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstName "+i);
        person.setLastName("LastName "+i);
        person.setAddress("Some Address in Brazil");
        boolean g = false;
        if (i % 2 == 0) g = true;
        person.setGender(g ? "Female" : "Male");
        return person;
    }
}
