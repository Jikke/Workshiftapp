/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshiftapp.workshiftapp;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<String> getDays(){
        ArrayList<String> dayList = new ArrayList<String>();
        for(int i=0; i<this.days.size(); i++){
          dayList.add(this.days.get(i).toString());  
        }
        return(dayList);
    }

    public void addEmployee(String name){
        Person newEmployee = new Person(name);
        this.employees.add(newEmployee);
    }

    public ArrayList<Person> getEmployees(){
        for(int i=0; i<this.employees.size(); i++){
            
        }
        return(this.employees);
    }

    public Boolean findEmployee(String name){
        for(int i=0; i<this.employees.size(); i++){
            if(this.employees.get(i).getName().equals(name)){
                return true;
            }
        }
            return false;
    }        
            
}
