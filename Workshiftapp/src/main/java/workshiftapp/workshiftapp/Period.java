/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshiftapp.workshiftapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jeoleivo
 */
public class Period {
    
    private ArrayList<Day> days;
    private ArrayList<Person> employees;

    //kostruktori luo 21 päivää pitkän työjakson ja tyhjän työntekijälistan
    public Period(){
        Day day1 = new Day("Maanantai1");
        Day day2 = new Day("Tiistai1");
        Day day3 = new Day("Keskiviikko1");
        Day day4 = new Day("Torstai1");
        Day day5 = new Day("Perjantai1");
        Day day6 = new Day("Lauantai1");
        Day day7 = new Day("Sunnuntai1");
        Day day8 = new Day("Maanantai2");
        Day day9 = new Day("Tiistai2");
        Day day10 = new Day("Keskiviikko2");
        Day day11 = new Day("Torstai2");
        Day day12 = new Day("Perjantai2");
        Day day13 = new Day("Lauantai2");
        Day day14 = new Day("Sunnuntai2");
        Day day15 = new Day("Maanantai3");
        Day day16 = new Day("Tiistai3");
        Day day17 = new Day("Keskiviikko3");
        Day day18 = new Day("Torstai3");
        Day day19 = new Day("Perjantai3");
        Day day20 = new Day("Lauantai3");
        Day day21 = new Day("Sunnuntai3");
        
        this.days = new ArrayList<>();
        this.days.add(day1);
        this.days.add(day2);
        this.days.add(day3);
        this.days.add(day4);
        this.days.add(day5);
        this.days.add(day6);
        this.days.add(day7);
        this.days.add(day8);
        this.days.add(day9);
        this.days.add(day10);
        this.days.add(day11);
        this.days.add(day12);
        this.days.add(day13);
        this.days.add(day14);
        this.days.add(day15);
        this.days.add(day16);
        this.days.add(day17);
        this.days.add(day18);
        this.days.add(day19);
        this.days.add(day20);
        this.days.add(day21);
        
    
        this.employees = new ArrayList<>();
    }
    
    public ArrayList<Day> getDays(){
        ArrayList<Day> dayList = new ArrayList<Day>();
        for(int i=0; i<this.days.size(); i++){
          dayList.add(this.days.get(i));  
        }
        return dayList;
    }

    public void addEmployees(){
        Scanner scan = new Scanner(System.in);
        while(true){
        System.out.println("Luo työntekijä antamalla nimi. Tyhjä syöte lopettaa.");
        String employeeName = scan.nextLine();
        if(employeeName.equals("")){
            System.out.println("Lisätty seuraavat työntekijät jaksolle: \n"+this.printEmployees());
            break;
        }
        Person newEmployee = new Person(employeeName);
        this.employees.add(newEmployee);
        }
    }
    
    public void setEmployees(){
        Scanner scan = new Scanner(System.in);
        for(Day currentDay : this.getDays()){
           String employeeName = ""; 
           //aamuvuoron loop 
           while(true){ 
           System.out.println("Lisää päivän "+currentDay+" aamuvuorooon haluamasi henkilöt. Tyhjä syöte lopettaa. Syöte x lopettaa vuorojen muokkauksen.");
           employeeName = scan.nextLine();
           if(employeeName.equals("") || employeeName.equals("x")){
            break;
           }
        currentDay.setShift(employeeName,"aamu");
           }
           //iltavuoron loop
           while(true){ 
           System.out.println("Lisää päivän "+currentDay+" iltavuorooon haluamasi henkilöt. Tyhjä syöte lopettaa. Syöte x lopettaa vuorojen muokkauksen.");
           employeeName = scan.nextLine();
           if(employeeName.equals("") || employeeName.equals("x")){
            break;
           }
        currentDay.setShift(employeeName,"ilta");
           }
           //vapaapäivän loop
           while(true){ 
           System.out.println("Lisää päivän "+currentDay+" vapaapäivälle haluamasi henkilöt. Tyhjä syöte lopettaa. Syöte x lopettaa vuorojen muokkauksen.");
           employeeName = scan.nextLine();
           if(employeeName.equals("") || employeeName.equals("x")){
            break;
           }
        currentDay.setShift(employeeName,"vapaa");
           }//vapaapäivän loop päättyy
        //poistu kokonaan setEmploees loopista syotteella x   
           if (employeeName.equals("x")){
            break;
        }   
        }
    }    
    

    public ArrayList<Person> getEmployees(){
        ArrayList<Person> employeeList = new ArrayList<Person>();
        for(int i=0; i<this.employees.size(); i++){
            employeeList.add(this.employees.get(i));
        }
        return employeeList;
    }
    
    public String printEmployees(){
        ArrayList<Person> employeeObjects = this.getEmployees();
        String employeeString = "";
        for(Person employee : employeeObjects){
            employeeString += ("\n"+employee.getName());
        }
        return employeeString;
    }

    public Boolean findEmployee(String name){
        for(int i=0; i<this.employees.size(); i++){
            if(this.employees.get(i).getName().equals(name)){
                return true;
            }
        }
            return false;
    }        
    
    public String toString(){
        ArrayList<Day> days = this.getDays();
        String wholePeriod = "";
        //looppaa läpi kaikkien päivien
        for (Day currentDay : days){
            //luo vuoroista omat String-listat jokaisen uuden päivän tarkastelun alussa
            ArrayList<String> morningList = currentDay.getMorning();
            ArrayList<String> eveningList = currentDay.getEvening();
            ArrayList<String> dayoffList = currentDay.getDayoff();
            //Luo lopulliseen String-olioon lisättävät String-oliot vuorojen työtenkijöistä
            String morning = "Aamuvuorossa:";
            String evening = "Iltavuorossa:";
            String dayoff = "Vapaalla:";
            //silmukoi tämän päivän kunkin vuoron listojen läpi ja lisää työntekijöiden nimet vuorojen String-olioihin
            for(int i=0; i<currentDay.getMorning().size(); i++){
            morning += (" "+morningList.get(i));
            }
            for(int i=0; i<currentDay.getEvening().size(); i++){
            evening += (" "+eveningList.get(i));
            } 
            for(int i=0; i<currentDay.getDayoff().size(); i++){
            dayoff += (" "+dayoffList.get(i));
            } 
            //kokoa lopulliseen String-olioon tämän päivän osalta kerätyt työntekijät        
            wholePeriod += ("\n"+currentDay.getWeekday()+": "+morning+", "+evening+","+dayoff);
        }
        return wholePeriod;
    }
    
    
}
