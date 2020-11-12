/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshiftapp.workshiftapp;
import java.util.*;

/**
 *
 * @author jeoleivo
 */
public class Main {
    
    public static void main(String[] args){
    
    //Period jakso = new Period();
    //jakso.addEmployee("Aatami");
    //jakso.addEmployee("Bertta");
    //jakso.addEmployee("Cecilia");
    //jakso.addEmployee("David");
    //jakso.addEmployee("Eemeli");
    //jakso.addEmployee("Farao");
    //System.out.println(jakso.getDays());

    Day paiva = new Day("Maanantai");
    System.out.println(paiva);
    Day testDay = new Day("Test");
     testDay.setShift("Aatami", "aamu");
     testDay.setShift("Bertta", "aamu");
     testDay.setShift("Cecilia", "aamu");
     System.out.println(testDay.getMorning());
    }
}
