/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Person;
import java.util.List;

/**
 *
 * @author jeoleivo
 */
public interface PersonDao {
    
    Person create(Person person) throws Exception;

    Person findByName(String username);

    List<Person> getAll();
    
}
