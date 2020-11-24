/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.*;
import domain.Period;

/**
 *
 * @author jeoleivo
 */
public class Menu {
    
    private Scanner input = new Scanner(System.in);
    private Period currentPeriod;
    
    public void display() {
    System.out.println("-- Valikko --");
    System.out.println(
        "Valitse numerolla vaihtoehto: \n" +
        "  1) Uuden työjakson luonti\n" +
        "  2) Työntekijöiden lisääminen vuorohoin\n" +
        "  3) Työjakson tarkastelu\n" +
        "  4) Työntekijän vuoron tarkastus\n" +
        "  5) Poistu"
    );
     
    int selection = input.nextInt();
    input.nextLine();
    
    switch (selection) {
case 1:
  this.newPeriod();
  break;
case 2:
  this.setPeriodEmployees();
  break;
case 3:
  this.checkPeriod();
  break;
case 4:
  this.checkEmployee();
  break;  
case 5:
  this.exit();
  break;
default:
  System.out.println("Virheellinen syöte.");
  break;
}
    
}
    public void newPeriod(){
        currentPeriod = new Period();
        System.out.println("Luotu uusi jakso.");
        currentPeriod.addEmployees();
        this.display();  
    }
    
    public void setPeriodEmployees(){
        currentPeriod.setEmployees();
        this.display();
    }
    
    public void checkPeriod(){
        System.out.println(currentPeriod);
        this.display();
    }
    
    public void checkEmployee(){
        currentPeriod.checkEmployee();
        this.display();
        
    }
    
    public void exit(){
        System.exit(0);
    }
}
