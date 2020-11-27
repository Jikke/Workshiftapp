/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Person;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jeoleivo
 */
public class FilePersonDao implements PersonDao {

    private List<Person> persons;
    private String file;

    public FilePersonDao(String file) throws Exception {
        persons = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String name = reader.nextLine();
                Person p = new Person(name);
                persons.add(p);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }

    }

    private void save() throws Exception {
        try ( FileWriter writer = new FileWriter(new File(file))) {
            for (Person person : persons) {
                writer.write(person.getName() + "\n");
            }
        }
    }

    @Override
    public Person create(Person person) throws Exception {
        persons.add(person);
        save();
        return person;
    }

    @Override
    public Person findByName(String name) {
        return persons.stream()
            .filter(u->u.getName()
            .equals(name))
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<Person> getAll() {
        return persons;
    }

}
