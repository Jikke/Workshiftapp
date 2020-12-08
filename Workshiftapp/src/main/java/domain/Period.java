/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
    Scanner scan = new Scanner(System.in);

    /**
     * Kostruktori luo 21 päivää pitkän työjakson ja tyhjän työntekijälistan
     *
     * @param morningMin Aamuvuoron minimivahvuus
     * @param eveningMin Iltavuoron minimivahvuus
     * @param nightMin Yövuoron minimivahvuus
     */
    public Period(int morningMin, int eveningMin, int nightMin) {
        Day day1 = new Day("Maanantai1", morningMin, eveningMin, nightMin);
        Day day2 = new Day("Tiistai1", morningMin, eveningMin, nightMin);
        Day day3 = new Day("Keskiviikko1", morningMin, eveningMin, nightMin);
        Day day4 = new Day("Torstai1", morningMin, eveningMin, nightMin);
        Day day5 = new Day("Perjantai1", morningMin, eveningMin, nightMin);
        Day day6 = new Day("Lauantai1", morningMin, eveningMin, nightMin);
        Day day7 = new Day("Sunnuntai1", morningMin, eveningMin, nightMin);
        Day day8 = new Day("Maanantai2", morningMin, eveningMin, nightMin);
        Day day9 = new Day("Tiistai2", morningMin, eveningMin, nightMin);
        Day day10 = new Day("Keskiviikko2", morningMin, eveningMin, nightMin);
        Day day11 = new Day("Torstai2", morningMin, eveningMin, nightMin);
        Day day12 = new Day("Perjantai2", morningMin, eveningMin, nightMin);
        Day day13 = new Day("Lauantai2", morningMin, eveningMin, nightMin);
        Day day14 = new Day("Sunnuntai2", morningMin, eveningMin, nightMin);
        Day day15 = new Day("Maanantai3", morningMin, eveningMin, nightMin);
        Day day16 = new Day("Tiistai3", morningMin, eveningMin, nightMin);
        Day day17 = new Day("Keskiviikko3", morningMin, eveningMin, nightMin);
        Day day18 = new Day("Torstai3", morningMin, eveningMin, nightMin);
        Day day19 = new Day("Perjantai3", morningMin, eveningMin, nightMin);
        Day day20 = new Day("Lauantai3", morningMin, eveningMin, nightMin);
        Day day21 = new Day("Sunnuntai3", morningMin, eveningMin, nightMin);

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

    /**
     * @return Period-olion Day-oliot listana
     */
    public ArrayList<Day> getDays() {
        ArrayList<Day> dayList = new ArrayList<>();
        for (int i = 0; i < this.days.size(); i++) {
            dayList.add(this.days.get(i));
        }
        return dayList;
    }

    /**
     * @param dayName Haettavan päivän nimi
     * @return Löytynyt päivä tai null
     */
    public Day findDay(String dayName) {
        for (int i = 0; i < this.days.size(); i++) {
            if (this.days.get(i).getWeekday().equals(dayName)) {
                return this.days.get(i);
            }
        }
        return null;
    }

    public void addEmployee(Person employee) {
        this.employees.add(employee);
    }

    /**
     * @param currentDay Päivä, jonka vuoroon työntekijä lisätään
     * @param employeeName Lisättävän työntekijän nimi
     * @return true tai false onnistumisen mukaan
     */
    public boolean setEmployeeMorning(Day currentDay, String employeeName) {
        //tarkistaa, löytyykö kyseinen nimi työntekijöiden listalta
        if (findEmployee(employeeName) != null) {
            this.findEmployee(employeeName).addShift(currentDay, "aamu");
            return true;
        }
        return false;
    }

    /**
     * @see setEmployeeMorning(Day currentDay, String employeeName)
     */
    public boolean setEmployeeEvening(Day currentDay, String employeeName) {

        if (findEmployee(employeeName) != null) {
            this.findEmployee(employeeName).addShift(currentDay, "ilta");
            return true;
        }
        return false;
    }
/**
     * @see setEmployeeMorning(Day currentDay, String employeeName)
     */
    public boolean setEmployeeNight(Day currentDay, String employeeName) {

        if (findEmployee(employeeName) != null) {
            this.findEmployee(employeeName).addShift(currentDay, "yö");
            return true;
        }
        return false;
    }
/**
     * @see setEmployeeMorning(Day currentDay, String employeeName)
     */
    public boolean setEmployeeDayoff(Day currentDay, String employeeName) {

        if (findEmployee(employeeName) != null) {
            this.findEmployee(employeeName).addShift(currentDay, "vapaa");
            //vapaa on työntekijän vakiovuoro, kun vuoroa ei olla muokattu
            return true;
        }
        return false;
    }
    /**
     * @return Palauttaa listan Period-olioon lisätyistä työntekijöistä
     */
    public ArrayList<Person> getEmployees() {
        ArrayList<Person> employeeList = new ArrayList<Person>();
        for (int i = 0; i < this.employees.size(); i++) {
            employeeList.add(this.employees.get(i));
        }
        return employeeList;
    }

     /**
     * @return Palauttaa String-oliona Period-olioon lisätyt työntekijät
     */
    public String printEmployees() {
        ArrayList<Person> employeeObjects = this.getEmployees();
        String employeeString = "\n";
        for (Person employee : employeeObjects) {
            employeeString += (employee.getName() + "\n");
        }
        return employeeString;
    }

    /**
     * @param name Haettavan työntekijän nimi
     * @return Löytynyt työntekijä tai null
     */
    public Person findEmployee(String name) {
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getName().equals(name)) {
                return this.employees.get(i);
            }
        }
        return null;
    }

    
    public boolean isEmployeeAvailable(Person employee, Day today, String neededShift) {
        int indexOfToday = employee.getDayIndex(today.getWeekday());
        String todaysShift = employee.getShiftwIndex(indexOfToday);
        String yesterdaysShift = null;
        String tomorrowsShift = null;
        //mikäli ensimmäinen päivä
        if (indexOfToday != 0) {
            yesterdaysShift = employee.getShiftwIndex(indexOfToday - 1);
        } else {
            yesterdaysShift = employee.getShiftwIndex(indexOfToday);
        }
        //mikäli viimeinen päivä
        if (indexOfToday != 20) {
            tomorrowsShift = employee.getShiftwIndex(indexOfToday + 1);
        } else {
            tomorrowsShift = employee.getShiftwIndex(indexOfToday);
        }
        //tarve aamuvuoroon, pitää olla tänään vapaalla ja eilen ei saa olla ollut ilta- tai yövuorossa
        if (neededShift.equals("aamu") && todaysShift.equals("vapaa") && !yesterdaysShift.equals("yö") && !yesterdaysShift.equals("ilta")) {
            return true;
        }

        //tarve iltavuoroon, pitää olla tänään vapaalla ja eilen ei saa olla ollut yövuorossa tai huomenna aamuvuorossa
        if (neededShift.equals("ilta") && todaysShift.equals("vapaa") && !yesterdaysShift.equals("yö") && !tomorrowsShift.equals("aamu")) {
            return true;
        }

        //tarve yövuoroon, pitää olla tänään vapaalla ja huomenna ei saa olla aamuvuorossa tai iltavuorossa
        if (neededShift.equals("yö") && todaysShift.equals("vapaa") && !tomorrowsShift.equals("aamu") && !tomorrowsShift.equals("ilta")) {
            return true;
        }

        return false;
    }

    public String checkEmployee(String employeeName, String dayName) {
        return this.findEmployee(employeeName).getShift(dayName);
    }

}
