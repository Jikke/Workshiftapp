/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Period;
import domain.Person;
import ui.Menu;
import java.util.*;

/**
 *
 * @author jeoleivo
 */
public class Main {

    public static void main(String[] args) {
        
        Person test = new Person("test");
        System.out.println(test.getDayIndex("Maanantai3"));
        Period testPeriod = new Period();
        
//        Menu menu = new Menu();
//        menu.display();
        //Period uusi = new Period();
        //uusi.addEmployees();
        //System.out.println(uusi.printEmployees());
        //System.out.println(uusi);
    }
}
