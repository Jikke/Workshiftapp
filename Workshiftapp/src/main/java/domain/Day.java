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
    private ArrayList<String> morning;
    private ArrayList<String> evening;
    private ArrayList<String> night;
    private ArrayList<String> dayoff;

    //konstruktori
    public Day(String dayname) {
        this.weekday = dayname;
        this.morning = new ArrayList<>();
        this.evening = new ArrayList<>();
        this.night = new ArrayList<>();
        this.dayoff = new ArrayList<>();
    }

    public String getWeekday() {
        return this.weekday;
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

    //palauttaa listan aamuvuoron työntekijöistä
    public ArrayList<String> getMorning() {
        ArrayList<String> morningList = new ArrayList<>();
        for (int i = 0; i < this.morning.size(); i++) {
            morningList.add(this.morning.get(i));
        }
        return morningList;
    }

    //palauttaa listan iltavuoron työntekijöistä
    public ArrayList<String> getEvening() {
        ArrayList<String> eveningList = new ArrayList<>();
        for (int i = 0; i < this.evening.size(); i++) {
            eveningList.add(this.evening.get(i));
        }
        return eveningList;
    }

    //palauttaa listan yövuoron työntekijöistä
    public ArrayList<String> getNight() {
        ArrayList<String> nightList = new ArrayList<>();
        for (int i = 0; i < this.night.size(); i++) {
            nightList.add(this.night.get(i));
        }
        return nightList;
    }

    //palauttaa listan vapaapäivän työntekijöistä
    public ArrayList<String> getDayoff() {
        ArrayList<String> dayoffList = new ArrayList<>();
        for (int i = 0; i < this.dayoff.size(); i++) {
            dayoffList.add(this.dayoff.get(i));
        }
        return dayoffList;
    }

    public String toString() {
        return this.getWeekday();
    }

}
