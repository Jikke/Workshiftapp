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

    //kostruktori luo 21 päivää pitkän työjakson ja tyhjän työntekijälistan
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

    public ArrayList<Day> getDays() {
        ArrayList<Day> dayList = new ArrayList<Day>();
        for (int i = 0; i < this.days.size(); i++) {
            dayList.add(this.days.get(i));
        }
        return dayList;
    }

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

//    public void addEmployees() {
//        System.out.println("Luo työntekijä antamalla nimi. Tyhjä syöte lopettaa.");
//        while (true) {
//
//            String employeeName = scan.nextLine();
//            if (employeeName.equals("")) {
//                System.out.println("Lisätty seuraavat työntekijät jaksolle: \n" + this.printEmployees());
//                break;
//            } else if (this.findEmployee(employeeName) != null) {
//                System.out.println("Kyseinen työntekijä on jo olemassa");
//            } else {
//                Person newEmployee = new Person(employeeName);
//                this.addEmployee(newEmployee);
//                for (Day day : days) {
//                    setEmployeeDayoff(day, employeeName);
//                }
//            }
//        }
//    }
    public void setEmployeeMorning(Day currentDay, String employeeName) {
        //tarkistaa, löytyykö kyseinen nimi työntekijöiden listalta
        if (findEmployee(employeeName) != null) {
            this.findEmployee(employeeName).addShift(currentDay, "aamu");
        } else {
            System.out.println("Antamaasi nimeä ei löydy työntekijälistalta.");
        }
        int thisManyMore = currentDay.howManyMoreToShift("aamu");
        if (thisManyMore != -1) {
            System.out.println("Aamuvuoroon tarvitaan vielä " + thisManyMore + " työntekijää!");
        }
    }

    public void setEmployeeEvening(Day currentDay, String employeeName) {

        if (findEmployee(employeeName) != null) {
            this.findEmployee(employeeName).addShift(currentDay, "ilta");
        } else {
            System.out.println("Antamaasi nimeä ei löydy työntekijälistalta.");
        }
        int thisManyMore = currentDay.howManyMoreToShift("ilta");
        if (thisManyMore != -1) {
            System.out.println("Iltavuoroon tarvitaan vielä " + thisManyMore + " työntekijää!");
        }
    }

    public void setEmployeeNight(Day currentDay, String employeeName) {

        if (findEmployee(employeeName) != null) {
            this.findEmployee(employeeName).addShift(currentDay, "yö");
        } else {
            System.out.println("Antamaasi nimeä ei löydy työntekijälistalta.");
        }
        int thisManyMore = currentDay.howManyMoreToShift("yö");
        if (thisManyMore != -1) {
            System.out.println("Yövuoroon tarvitaan vielä " + thisManyMore + " työntekijää!");
        }
    }

    public void setEmployeeDayoff(Day currentDay, String employeeName) {

        if (findEmployee(employeeName) != null) {
            this.findEmployee(employeeName).addShift(currentDay, "vapaa");
            //vapaa on työntekijän vakiovuoro, kun vuoroa ei olla muokattu
        } else {
            System.out.println("Antamaasi nimeä ei löydy työntekijälistalta.");
        }
    }

    public ArrayList<Person> getEmployees() {
        ArrayList<Person> employeeList = new ArrayList<Person>();
        for (int i = 0; i < this.employees.size(); i++) {
            employeeList.add(this.employees.get(i));
        }
        return employeeList;
    }

    public String printEmployees() {
        ArrayList<Person> employeeObjects = this.getEmployees();
        String employeeString = "\n";
        for (Person employee : employeeObjects) {
            employeeString += (employee.getName() + "\n");
        }
        return employeeString;
    }

    public Person findEmployee(String name) {
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getName().equals(name)) {
                return this.employees.get(i);
            }
        }
        return null;
    }

    //miten tarkistaa ettei käsittelyssä ole eka tai vika päivä, koska indexOfToday rikkoo muuten metodin
    public boolean isEmployeeAvailable(Person employee, Day today, String neededShift) {
        if (neededShift.equals("aamu") || neededShift.equals("ilta") || neededShift.equals("yö")) {
            if (this.findEmployee(employee.getName()) != null) {
                if (this.findDay(today.getWeekday()) != null) {
                    int indexOfToday = employee.getDayIndex(today.toString());
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
                }
            }
        }
        return false;
    }

    public String checkEmployee(String employeeName, String dayName) {
        return this.findEmployee(employeeName).getShift(dayName);
    }

//    public Boolean checkAvailability(String name){
//        if(this.findEmployee(name)!=null){
//            
//        } else {
//            return false;
//        }
//    }
}
