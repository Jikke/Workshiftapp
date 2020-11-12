/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshiftapp.workshiftapp;

import java.util.ArrayList;


/**
 *
 * @author jeoleivo
 */
public class Day {
    
    private final String weekday;
    private ArrayList<String> morning;
    private ArrayList<String> evening;
    private ArrayList<String> dayoff;

    //konstruktori
    public Day(String dayname){
        this.weekday = dayname;
        this.morning = new ArrayList<>();
        this.evening = new ArrayList<>();
        this.dayoff = new ArrayList<>();
    }
    
    public String getWeekday(){
        return this.weekday;
    }
    
    public void setShift(String name, String shift) {
        if(shift.equals("aamu")){
            this.morning.add(name);
            System.out.println("Henkilön "+name+" lisääminen aamuvuoroon onnistui.");
            return;
        }
        if(shift.equals("ilta")){
            this.evening.add(name);
            System.out.println("Henkilön "+name+" lisääminen iltavuoroon onnistui.");
            return;
        }
        if(shift.equals("vapaa")){
            this.dayoff.add(name);
            System.out.println("Henkilön "+name+" lisääminen vapaapäivälle onnistui.");
            return;
        } else {
            System.out.println("Virheellinen syöte");
            return;
        }

    }

    
    public ArrayList<String> getMorning() {
        ArrayList<String> morningList = new ArrayList<>();
        for (int i=0;i<this.morning.size();i++){
            morningList.add(this.morning.get(i));
        }
        return morningList;
    }
    
    public ArrayList<String> getEvening() {
        ArrayList<String> eveningList = new ArrayList<>();
        for (int i=0;i<this.evening.size();i++){
            eveningList.add(this.evening.get(i));
        }
        return eveningList;
    }
    
    public ArrayList<String> getDayoff() {
        ArrayList<String> dayoffList = new ArrayList<>();
        for (int i=0;i<this.dayoff.size();i++){
            dayoffList.add(this.dayoff.get(i));
        }
        return dayoffList;
    }
    
    @Override 
    public String toString(){
        return this.getWeekday();
    }
    

}
