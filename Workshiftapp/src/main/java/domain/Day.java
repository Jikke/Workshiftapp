/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;
import org.javatuples.Tuple;

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

    /**
     * Kostruktori määrittää päivän nimen, sekä työvuorojen minimivahvuudet.
     * @param dayname Päivän nimi
     * @param morningMin Aamuvuoron minimivahvuus
     * @param eveningMin Iltavuoron minimivahvuus
     * @param nightMin Yövuoron minimivahvuus
     */
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

    public ArrayList<String> getMorning() {
        return this.morning;
    }

    public ArrayList<String> getEvening() {
        return this.evening;
    }

    public ArrayList<String> getNight() {
        return this.night;
    }

    public ArrayList<String> getDayoff() {
        return this.dayoff;
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
    
    /**
     * Asettaa työntekijän työvuoroon.
     * @param employeeName Vuoroon lisättävän työntekijän nimi
     * @param shift Vuoro, johon työntekijä lisätään
     */
    public void setShift(String employeeName, String shift) {
        ArrayList<String> shiftList = getShiftList(shift).getValue0();
        shiftList.add(employeeName);
    }
    
    /**
     * Poistaa työntekijän työvuorosta.
     * @param employeeName Vuorosta poistettavan työntekijän nimi
     */
    public boolean removeShift(String employeeName) { 
        String currentShift = this.findEmployeeShift(employeeName);
        Pair<ArrayList<String>, Integer> pair = getShiftList(currentShift);
        ArrayList<String> shiftEmployees = pair.getValue0();
        shiftEmployees.remove(getShift(employeeName, shiftEmployees));
        return true;
    } 
    
    /**
     * Palauttaa työntekijän työvuoron järjestysluvun(index).
     * @param employeeName Työntekijän nimi, jonka vuoro haetaan
     * @param shiftList Tarkasteltavan työvuoron työntekijälista
     * @return Työntekijän löytyessä järjestysnumero, muutoin -1
     */
    private int getShift(String employeeName, ArrayList<String> shiftList) { 
        for (int i = 0; i < shiftList.size(); i++) {
            if (employeeName.equals(shiftList.get(i))) { 
                return i;
            }
        }
        return -1;    
    }
    
    /**
     * Palauttaa parin, jonka ensimmäinen osa on lista vuoron työntekijöistä ja toinen osa vuoron minimivahvuus.
     * @param shift Tarkasteltava työvuoro
     * @return Pari-olio, jonka ensimmäinen osa on vuoron työntekijälista ja toinen osa vuoron minimivahvuus
     */
    
    private Pair<ArrayList<String>, Integer> getShiftList(String shift) { 
        switch (shift) { 
            case "aamu":
                return new Pair(this.morning , this.morningMin);
            case "ilta":
                return new Pair(this.evening , this.eveningMin);
            case "yö":
                return new Pair(this.night , this.nightMin);
            case "vapaa":
                return new Pair(this.dayoff , 999);
            default:
                return null;
        } 
    }
    
    /**
     * Hakee työntekijän nimen perusteella tämän työvuoron
     * @param employeeName Tarkasteltava työntekijän nimi
     * @return Löytyessään palauttaa vuoron nimen, muutoin palaute on null
     */
    public String findEmployeeShift(String employeeName) { 
        for (int i = 0; i < this.morning.size(); i++) {
            if (employeeName.equals(this.morning.get(i))) { 
                return "aamu";
            }
        }    
        for (int i = 0; i < this.evening.size(); i++) {
            if (employeeName.equals(this.evening.get(i))) { 
                return "ilta";
            }
        }    
        for (int i = 0; i < this.night.size(); i++) {
            if (employeeName.equals(this.night.get(i))) { 
                return "yö";
            }
        }    
        for (int i = 0; i < this.dayoff.size(); i++) { 
            if (employeeName.equals(this.dayoff.get(i))) { 
                return "vapaa";
            }
        } 
        return null;    
    }    

     /**
     * Laskee vuoron minimivahvuuden perusteella, montako työntekijää vuoroon vielä tarvitaan
     * @param shift Tarkasteltava vuoro
     * @return Mikäli työntekijöiden minimivahvuutta ei olla saavutettu, palauttaa lukeman tarvittavasta määrästä. Muutoin palauttaa -2
     */

    public int howManyMoreToShift(String shift) { 
        Pair<ArrayList<String>, Integer> pair = getShiftList(shift);
        ArrayList<String> shiftEmployees = pair.getValue0();
        int minValue = pair.getValue1();
        if (shiftEmployees.size() < minValue) { 
            int thisManyMore =  minValue - shiftEmployees.size();
            return thisManyMore;
        } else {
            return -2; 
        }
    }        
    
    public String toString() {
        return this.getWeekday();
    }

}
