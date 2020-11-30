/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Person;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public FilePersonDao(String filePath) throws Exception {
        persons = new ArrayList<>();
        this.file = filePath;
        File personFile = new File(filePath);
        System.out.println("6");
        if(!personFile.exists()){
            createFile(filePath);
            System.out.println("7");
        } else {
        try {
            System.out.println("8");
            Scanner reader = new Scanner(personFile);
            if(reader.hasNext()){
            String[] wholeRow = reader.nextLine().split(";");
            System.out.println("9");
            for(String current : wholeRow){
                Person p = new Person(current);
                persons.add(p);
            } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }

    private boolean createFile(String filePath) throws IOException{
        File file = new File(filePath);
        Boolean result = false;
        try{
        result = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    private void save() throws Exception {
        try ( FileWriter writer = new FileWriter(new File(file))) {
            for (Person person : persons) {
                writer.write(person.getName() + "; ");
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
