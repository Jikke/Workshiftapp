/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Day;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jeoleivo
 */
public class FileDayDao implements DayDao{
    private List<Day> days;
    private String file;

    public FileDayDao(String file, PersonDao personDao) throws Exception {
        days = new ArrayList<>();
        this.file = file;
        File dayFile = new File(file);
        if(!dayFile.exists()){
            createFile(file);
        } else {
        try {
            Scanner reader = new Scanner(dayFile);
            while (reader.hasNextLine()) {
                String[] wholeRow = reader.nextLine().split(";");
                Day d = new Day(wholeRow[0]);
                days.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
    
    private boolean createFile(String filePath) throws IOException{
        File file = new File(filePath);
        Boolean result = false;
        try{
        result = file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write("Maanantai1;\nTiistai1;\nKeskiviikko1;\nTorstai1;\nPerjantai1;\nLauantai1;\nSunnuntai1;"
                + "\nMaanantai2;\nTiistai2;\nKeskiviikko2;\nTostai2;\nPerjantai2;\nLauantai2;\nSunnuntai2;"
                + "\nMaanantai3;\nTiistai3;\nKeskiviikko3;\nTorstai3;\nPerjantai3;\nLauantai3;\nSunnuntai3;");
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
    
    private void save() throws Exception {
        try ( FileWriter writer = new FileWriter(new File(file))) {
            for (Day day : days) {
                writer.write(day.getWeekday() + "; Aamuvuoro: "+day.getMorning()+". Iltavuoro: "+day.getEvening()+". Yövuoro: "+day.getNight()+
                        ". Vapaa: "+day.getDayoff()+".\n");
            }
        }
    }

    @Override
    public void create(String day) throws Exception {
        
        save();
    }

    @Override
    public Day findByName(String dayName) {
        return days.stream()
            .filter(u->u.getWeekday()
            .equals(dayName))
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<Day> getAll() {
        return days;
    }

}
