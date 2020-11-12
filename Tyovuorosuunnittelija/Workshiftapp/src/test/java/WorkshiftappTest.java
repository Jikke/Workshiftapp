/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import workshiftapp.workshiftapp.Day;
import workshiftapp.workshiftapp.Person;

/**
 *
 * @author jeoleivo
 */
public class WorkshiftappTest {
    
    public WorkshiftappTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void constructorCreatesPersonProperly() {
     Person testPerson = new Person("Test");
     assertEquals("Test", testPerson.getName());  
     }
     
     @Test
     public void constructorCreatesDayProperly() {
     Day testDay = new Day("Test");
     assertEquals("Test", testDay.getWeekday());  
     }
     
     @Test
     public void daySetMorningShiftWorks() {
     ArrayList<String> testList = new ArrayList<>();
     testList.add("Aatami");
     testList.add("Bertta");
     testList.add("Cecilia");
     Day testDay = new Day("Test");
     testDay.setShift("Aatami", "aamu");
     testDay.setShift("Bertta", "aamu");
     testDay.setShift("Cecilia", "aamu");
     assertTrue(testList.containsAll(testDay.getMorning()) && testDay.getMorning().containsAll(testList));
     }
     
     @Test
     public void daySetEveningShiftWorks() {
     ArrayList<String> testList = new ArrayList<>();
     testList.add("David");
     testList.add("Eemeli");
     testList.add("Faarao");
     Day testDay = new Day("Test");
     testDay.setShift("David", "ilta");
     testDay.setShift("Eemeli", "ilta");
     testDay.setShift("Faarao", "ilta");
     assertTrue(testList.containsAll(testDay.getEvening()) && testDay.getEvening().containsAll(testList));
     }
     
     @Test
     public void daySetDayoffWorks() {
     ArrayList<String> testList = new ArrayList<>();
     testList.add("Gabriel");
     testList.add("Hannes");
     testList.add("Iivo");
     testList.add("Jaakko");
     testList.add("Kalevi");
     Day testDay = new Day("Test");
     testDay.setShift("Gabriel", "vapaa");
     testDay.setShift("Hannes", "vapaa");
     testDay.setShift("Iivo", "vapaa");
     testDay.setShift("Jaakko", "vapaa");
     testDay.setShift("Kalevi", "vapaa");
     assertTrue(testList.containsAll(testDay.getDayoff()) && testDay.getDayoff().containsAll(testList));
     }
}
