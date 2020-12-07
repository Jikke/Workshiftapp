/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author jeoleivo
 */
public class Day {

    private final String weekday;
    private final ArrayList<String> morning;
    private final int morningMin;
    private final ArrayList<String> evening;
    private final int eveningMin;
    private final ArrayList<String> night;
    private final int nightMin;
    private final ArrayList<String> dayoff;

    //konstruktori
    public Day(String dayname, int morningMin, int eveningMin, int nightMin) {
        this.weekday = dayname;
        this.morning = new ArrayList<>();
        this.morningMin = morningMin;
        this.evening = new ArrayList<>();
        this.eveningMin = eveningMin;
        this.night = new ArrayList<>();
        this.nightMin = nightMin;
        this.dayoff = new ArrayList<>();
    }

    public String getWeekday() {
        return this.weekday;
    }
    
    public int getMorningMin() {
        return this.morningMin;
    }
    
    public int getEveningMin() {
        return this.eveningMin;
    }
    
    public int getNightMin() {
        return this.nightMin;
    }

    public void setShift(String name, String shift) {
        if (shift.equals("aamu")) {
            this.morning.add(name);
            return;
        }
        if (shift.equals("ilta")) {
            this.evening.add(name);
            return;
        }
        if (shift.equals("yö")) {
            this.night.add(name);
            return;
        }
        if (shift.equals("vapaa")) {
            this.dayoff.add(name);
            return;
        } else {
            System.out.println("Virheellinen syöte");
            return;
        }

    }
    //poistaa nykyisen vuoron
    public boolean removeShift(String employeeName){
       String currenShift = this.findEmployeeShift(employeeName);
       if(currenShift!=null){
        if (currenShift.equals("aamu")) {
           for (int i = 0; i < this.morning.size(); i++) {
            if(employeeName.equals(this.morning.get(i))){
               this.morning.remove(i);
               return true;
            }
        }
           
        }
        if (currenShift.equals("ilta")) {
            for (int i = 0; i < this.evening.size(); i++) {
            if(employeeName.equals(this.evening.get(i))){
               this.evening.remove(i);
               return true;
            }
        }
        }    
        if (currenShift.equals("yö")) {
            for (int i = 0; i < this.night.size(); i++) {
            if(employeeName.equals(this.night.get(i))){
               this.night.remove(i);
               return true;
            }
        }
        }    
        if (currenShift.equals("vapaa")) {
            for (int i = 0; i < this.dayoff.size(); i++) {
            if(employeeName.equals(this.dayoff.get(i))){
               this.dayoff.remove(i);
               return true;
            }
        }
        }
        }
            return false;
        } 
    //palauttaa työntekijän tämänhetkisen vuoron
    public String findEmployeeShift(String employeeName){
        for (int i = 0; i < this.morning.size(); i++) {
            if(employeeName.equals(this.morning.get(i))){
//   ei pitäisi poistaa mitään..            this.morning.remove(i);
               return "aamu";
            }
        }    
        for (int i = 0; i < this.evening.size(); i++) {
            if(employeeName.equals(this.evening.get(i))){
//               this.evening.remove(i);
               return "ilta";
            }
        }    
        for (int i = 0; i < this.night.size(); i++) {
            if(employeeName.equals(this.night.get(i))){
//               this.night.remove(i);
               return "yö";
            }
        }    
        for (int i = 0; i < this.dayoff.size(); i++) {
            if(employeeName.equals(this.dayoff.get(i))){
//               this.dayoff.remove(i);
               return "vapaa";
            }
        } 
        return null;    
    }    

    //palauttaa listan aamuvuoron työntekijöistä
    public ArrayList<String> getMorning() {
        return this.morning;
    }

    //palauttaa listan iltavuoron työntekijöistä
    public ArrayList<String> getEvening() {
        return this.evening;
    }

    //palauttaa listan yövuoron työntekijöistä
    public ArrayList<String> getNight() {
        return this.night;
    }

    //palauttaa listan vapaapäivän työntekijöistä
    public ArrayList<String> getDayoff() {
        return this.dayoff;
    }

    public int howManyMoreToShift(String shift){
        switch(shift){
            case "aamu":
            if(this.getMorning().size()<this.morningMin){
               int thisManyMore =  this.morningMin - this.getMorning().size();
               return thisManyMore;
            } else {
               return -2; 
            }
            case "ilta":
            if(this.getEvening().size()<this.eveningMin){
               int thisManyMore =  this.eveningMin - this.getEvening().size();
               return thisManyMore;
            } else {
               return -2; 
            }
            case "yö":
            if(this.getNight().size()<this.nightMin){
               int thisManyMore =  this.nightMin - this.getNight().size();
               return thisManyMore;
            } else {
               return -2; 
            }
            default:
            System.out.println("Virheellinen syöte.");
            return -2;
        }
    }
    
    public String toString() {
        return this.getWeekday();
    }

}
