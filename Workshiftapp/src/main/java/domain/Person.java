/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.HashMap;

/**
 *
 * @author jeoleivo
 */
public class Person {

    private final String name;
    private HashMap<String, String> shifts;

    //konstruktori
    public Person(String name) {
        this.name = name;
        this.shifts = new HashMap<>();
        shifts.put("Maanantai1", "vapaa");
        shifts.put("Tiistai1", "vapaa");
        shifts.put("Keskiviikko1", "vapaa");
        shifts.put("Torstai1", "vapaa");
        shifts.put("Perjantai1", "vapaa");
        shifts.put("Lauantai1", "vapaa");
        shifts.put("Sunnuntai1", "vapaa");
        shifts.put("Maanantai2", "vapaa");
        shifts.put("Tiistai2", "vapaa");
        shifts.put("Keskiviikko2", "vapaa");
        shifts.put("Torstai2", "vapaa");
        shifts.put("Perjantai2", "vapaa");
        shifts.put("Lauantai2", "vapaa");
        shifts.put("Sunnuntai2", "vapaa");
        shifts.put("Maanantai3", "vapaa");
        shifts.put("Tiistai3", "vapaa");
        shifts.put("Keskiviikko3", "vapaa");
        shifts.put("Torstai3", "vapaa");
        shifts.put("Perjantai3", "vapaa");
        shifts.put("Lauantai3", "vapaa");
        shifts.put("Sunnuntai3", "vapaa");
    }

    public String getName() {
        return this.name;
    }

    public void addShift(String day, String shift) {
        shifts.replace(day, shift);
    }

    public String getShift(String day) {
        return shifts.get(day);
    }

}
