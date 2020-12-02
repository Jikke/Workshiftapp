/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Day;
import java.util.*;
import domain.Period;
import domain.Person;

/**
 *
 * @author jeoleivo
 */
public class Menu {
    
    private final Scanner input;
    private Period currentPeriod;

    public Menu() {
        
        this.input = new Scanner(System.in);
    }
    
    public void display() {
    System.out.println("-- Valikko --");
    System.out.println(
        "Valitse numerolla vaihtoehto: \n" +
        "  1) Luo uusi jakso\n" +
        "  2) Lisää työntekijöitä\n" +        
        "  3) Työntekijöiden lisääminen vuorohoin\n" +
        "  4) Työjakson tarkastelu\n" +
        "  5) Työntekijän vuoron tarkastus\n" +
        "  6) Poistu"
    );
     
    int selection = input.nextInt();
    input.nextLine();
    
    switch (selection) {
case 1:
  this.createPeriod();
  break;
case 2:
  this.createEmployees();
  break;  
case 3:
  this.setPeriodEmployees();
  break;
case 4:
  this.checkPeriod();
  break;
case 5:
  this.checkEmployee();
  break;  
case 6:
  this.exit();
  break;
default:
  System.out.println("Virheellinen syöte.");
  break;
}
    
}
    public void createPeriod(){
        
        System.out.println("Anna aamu-, ilta- ja yövuorojen minimivahvuudet pilkulla erotettuna:");
        String line = input.nextLine();
        String[] numbers = line.split(",");
        if(numbers.length==3){
        int m = Integer.parseInt(numbers[0]);
        int e = Integer.parseInt(numbers[0]);
        int n = Integer.parseInt(numbers[0]);
        this.currentPeriod = new Period(m, e, n);
        } else {
            System.out.println("Virheellinen syöte.");
        }
        
        this.display();  
    }
    
    public void createEmployees(){
        if(currentPeriod!=null){
        System.out.println("Luo työntekijä antamalla nimi. Tyhjä syöte lopettaa.");
        while (true) {

            String employeeName = input.nextLine();
            if (employeeName.equals("")) {
                System.out.println("Jaksossa on seuraavat työntekijät: \n" + currentPeriod.printEmployees());
                break;
            } else if (currentPeriod.findEmployee(employeeName) != null) {
                System.out.println("Kyseinen työntekijä on jo olemassa");
            } else {
                Person newEmployee = new Person(employeeName);
                currentPeriod.addEmployee(newEmployee);
                for (Day day : currentPeriod.getDays()) {
                    currentPeriod.setEmployeeDayoff(day, employeeName);
                }
            }
        }
        } else {
            System.out.println("Jaksoa ei ole vielä luotu.");
        }
        this.display(); 
    }
    
    public void setPeriodEmployees(){
        
        for (Day currentDay : currentPeriod.getDays()) {
            String employeeName = "placeholder";

            //aamuvuoron loop
            System.out.println("Lisää päivän " + currentDay + " aamuvuorooon haluamasi henkilöt. Tyhjä syöte lopettaa. Syöte x lopettaa vuorojen muokkauksen.");
            while (true) {

                employeeName = input.nextLine();
                if (employeeName.equals("") || employeeName.equals("x")) {
                    break;
                }
                if (currentPeriod.isEmployeeAvailable(currentPeriod.findEmployee(employeeName), currentDay, "aamu") == true) {
                    currentPeriod.setEmployeeMorning(currentDay, employeeName);
                } else {
                    System.out.println("Kyseistä työntekijää ei voitu lisätä tähän vuoroon, koska lepoajat eivät täyttyisi.");
                }
            }
            if (employeeName.equals("x")) {
                break;
            }
            //iltavuoron loop
            System.out.println("Lisää päivän " + currentDay + " iltavuorooon haluamasi henkilöt. Tyhjä syöte lopettaa. Syöte x lopettaa vuorojen muokkauksen.");
            while (true) {

                employeeName = input.nextLine();
                if (employeeName.equals("") || employeeName.equals("x")) {
                    break;
                }
                if (currentPeriod.isEmployeeAvailable(currentPeriod.findEmployee(employeeName), currentDay, "ilta") == true) {
                    currentPeriod.setEmployeeEvening(currentDay, employeeName);
                } else {
                    System.out.println("Kyseistä työntekijää ei voitu lisätä tähän vuoroon, koska lepoajat eivät täyttyisi.");
                }
            }
            if (employeeName.equals("x")) {
                break;
            }
            //yövuoron loop
            System.out.println("Lisää päivän " + currentDay + " yövuoroon haluamasi henkilöt. Tyhjä syöte lopettaa. Syöte x lopettaa vuorojen muokkauksen.");
            while (true) {

                employeeName = input.nextLine();
                if (employeeName.equals("") || employeeName.equals("x")) {
                    break;
                }
                if (currentPeriod.isEmployeeAvailable(currentPeriod.findEmployee(employeeName), currentDay, "yö") == true) {
                    currentPeriod.setEmployeeNight(currentDay, employeeName);
                } else {
                    System.out.println("Kyseistä työntekijää ei voitu lisätä tähän vuoroon, koska lepoajat eivät täyttyisi.");
                }
            }
            if (employeeName.equals("x")) {
                break;
            }
            //vapaapäivän loop
            System.out.println("Lisää päivän " + currentDay + " vapaapäivälle haluamasi henkilöt. Tyhjä syöte lopettaa. Syöte x lopettaa vuorojen muokkauksen.");
            while (true) {

                employeeName = input.nextLine();
                if (employeeName.equals("") || employeeName.equals("x")) {
                    break;
                }
                currentPeriod.setEmployeeDayoff(currentDay, employeeName);

            }
            //vapaapäivän loop päättyy
            //poistu kokonaan setEmploees loopista syotteella x   
            if (employeeName.equals("x")) {
                break;
            }

        }
        
        this.display();
    }
    
    public void checkPeriod(){
        ArrayList<Day> days = currentPeriod.getDays();
        String wholePeriod = "";
        //looppaa läpi kaikkien päivien
        for (Day currentDay : days) {
            //luo vuoroista omat String-listat jokaisen uuden päivän tarkastelun alussa
            ArrayList<String> morningList = currentDay.getMorning();
            ArrayList<String> eveningList = currentDay.getEvening();
            ArrayList<String> nightList = currentDay.getNight();
            ArrayList<String> dayoffList = currentDay.getDayoff();
            //Luo lopulliseen String-olioon lisättävät String-oliot vuorojen työtenkijöistä
            String morning = "   Aamuvuorossa: ";
            String evening = "   Iltavuorossa: ";
            String night = "   Yövuorossa: ";
            String dayoff = "   Vapaalla:";
            //silmukoi tämän päivän kunkin vuoron listojen läpi ja lisää työntekijöiden nimet vuorojen String-olioihin
            for (int i = 0; i < currentDay.getMorning().size(); i++) {
                morning += (" " + morningList.get(i));
            }
            morning += "\n";
            for (int i = 0; i < currentDay.getEvening().size(); i++) {
                evening += (" " + eveningList.get(i));
            }
            evening += "\n";
            for (int i = 0; i < currentDay.getNight().size(); i++) {
                night += (" " + nightList.get(i));
            }
            night += "\n";
            for (int i = 0; i < currentDay.getDayoff().size(); i++) {
                dayoff += (" " + dayoffList.get(i));
            }
            dayoff += "\n";
            //kokoa lopulliseen String-olioon tämän päivän osalta kerätyt työntekijät        
            wholePeriod += ("\n" + currentDay.getWeekday() + ": \n" + morning + " \n" + evening + " \n" + night + " \n" + dayoff);
        }
        System.out.println(wholePeriod);
        this.display();
    }
    
    public void checkEmployee(){
        System.out.println("Anna tarkasteltavan työntekijän nimi:");
        String employeeName = input.nextLine();
        if (currentPeriod.findEmployee(employeeName) != null) {
            System.out.println("Anna tarkasteltavan päivän nimi:");
            String dayName = input.nextLine();
            if (currentPeriod.findDay(dayName) != null) {
                System.out.println(currentPeriod.checkEmployee(employeeName,dayName));
            } else {
                System.out.println("Kyseistä päivää ei löydy.");
            }
        } else {
            System.out.println("Kyseistä työntekijää ei löydy.");
        }
        this.display();
    }
        
       
    
    public void exit(){
        System.exit(0);
    }
}
