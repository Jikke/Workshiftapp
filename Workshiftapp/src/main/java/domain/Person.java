/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 *
 * @author jeoleivo
 */
public class Person {

    private final String name;
    private LinkedHashMap<String, String> shifts;

    /**
     * Kostruktori luo 21 päivää pitkän työvuorolistan ja asetta päiville vakiovuoroksi "vapaa"
     * @param name Työntekijän nimi
     */
    public Person(String name) {
        this.name = name;
        this.shifts = new LinkedHashMap<>();
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

    /**
     * Korvaa nykysen työvuoron annetulla työvuorolla sekä Person, että Day olioista
     * @param day Käsiteltävä päivä
     * @param shift Vuoro, johon työntekijä lisätään
     */
    public void addShift(Day day, String shift) {
        this.shifts.replace(day.toString(), shift);
        day.removeShift(this.getName());
        day.setShift(this.getName(), shift);
    }

    public String getShift(String dayName) {
        return this.shifts.get(dayName);
    }

    /**
     * Hakee työvuoron indeksin perusteella
     * @param index Haettavan työvuoron työpäivän indeksi
     * @return Kyseistä indeksiä vastaava työvuoro
     */
    public String getShiftwIndex(int index) {

        String shift = (new ArrayList<>(this.shifts.values())).get(index);
        return shift;

    }

    /**
     * Hakee työpäivän indeksin sen nimen perusteella
     * @param dayName Haettavan työpäivän nimi
     * @return Kyseistä työpäivää vastaava indeksi tai -1, jos sitä ei löytynyt
     */
    public int getDayIndex(String dayName) {
        Set keySet = this.shifts.keySet();
        ArrayList<String> keyArray = new ArrayList<>(keySet);
        for (String keys : keyArray) {
            if (keys.equals(dayName)) {
                return keyArray.indexOf(keys);
            }
        }
        return -1;
    }
}
