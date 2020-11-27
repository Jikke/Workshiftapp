/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import domain.Day;
import domain.Period;
import domain.Person;

/**
 *
 * @author jeoleivo
 */
public class WorkshiftappTest {
    
    Period testPeriod;
    Day testDay;
    ArrayList<String> testList;
    Person testEmployee;
    
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
        
     testPeriod = new Period();
     testDay = new Day("Test");   
     testList = new ArrayList<String>();
     testEmployee = new Person("testEmployee");
        
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
     assertEquals("Test", testDay.getWeekday());  
     }
     
     @Test
     public void daySetMorningShiftWorks() {
     testList.add("Aatami");
     testList.add("Bertta");
     testList.add("Cecilia");
     testDay.setShift("Aatami", "aamu");
     testDay.setShift("Bertta", "aamu");
     testDay.setShift("Cecilia", "aamu");
     assertTrue(testList.containsAll(testDay.getMorning()) && testDay.getMorning().containsAll(testList));
     }
     
     @Test
     public void daySetEveningShiftWorks() {
     testList.add("David");
     testList.add("Eemeli");
     testList.add("Faarao");
     testDay.setShift("David", "ilta");
     testDay.setShift("Eemeli", "ilta");
     testDay.setShift("Faarao", "ilta");
     assertTrue(testList.containsAll(testDay.getEvening()) && testDay.getEvening().containsAll(testList));
     }
     
     @Test
     public void daySetDayoffWorks() {
     testList.add("Gabriel");
     testList.add("Hannes");
     testList.add("Iivo");
     testList.add("Jaakko");
     testList.add("Kalevi");
     testDay.setShift("Gabriel", "vapaa");
     testDay.setShift("Hannes", "vapaa");
     testDay.setShift("Iivo", "vapaa");
     testDay.setShift("Jaakko", "vapaa");
     testDay.setShift("Kalevi", "vapaa");
     assertTrue(testList.containsAll(testDay.getDayoff()) && testDay.getDayoff().containsAll(testList));
     }
     
     @Test
     public void constructorCreatesPeriodProperly(){
         assertEquals("[Maanantai1, Tiistai1, Keskiviikko1, Torstai1, Perjantai1, Lauantai1, Sunnuntai1, "
                 + "Maanantai2, Tiistai2, Keskiviikko2, Torstai2, Perjantai2, Lauantai2, Sunnuntai2, "
                 + "Maanantai3, Tiistai3, Keskiviikko3, Torstai3, Perjantai3, Lauantai3, Sunnuntai3]"
         , testPeriod.getDays().toString());
     }
     
     @Test
     public void personAddAndGetShiftTest(){
         Person testPerson = new Person("testPerson");
         testPerson.addShift("Tiistai2", "ilta");
         int dayIndex = testPerson.getDayIndex("Tiistai2");
         assertEquals("ilta",testPerson.getShift(dayIndex));
     }
     @Test
     public void periodGetDayProperArgument(){
         assertEquals(testPeriod.getDays().get(15), testPeriod.findDay("Tiistai3"));
     }
     
     @Test
     public void periodGetDayWrongArgument(){
         assertNotEquals(testPeriod.getDays().get(16), testPeriod.findDay("Tiistai3"));
     }
    
     @Test
     public void periodFindEmployeeProperArgument(){
         Person abc = new Person("abc");
         Person def = new Person("def");
         Person hij = new Person("hij");
         testPeriod.addEmployee(abc);
         testPeriod.addEmployee(testEmployee);
         testPeriod.addEmployee(def);
         testPeriod.addEmployee(hij);
         assertEquals(testEmployee, testPeriod.findEmployee("testEmployee"));
     }
     
     @Test
     public void periodFindEmployeeWrongArgument(){
         Person abc = new Person("abc");
         Person def = new Person("def");
         Person hij = new Person("hij");
         testPeriod.addEmployee(abc);
         testPeriod.addEmployee(testEmployee);
         testPeriod.addEmployee(def);
         testPeriod.addEmployee(hij);
         assertEquals(null, testPeriod.findEmployee("cba"));
     }
     
     @Test
     public void periodIsEmployeeFreeProperArgument(){
         test.addShift
         testPeriod.isEmployeeFree("test", dayName, neededShift);
     }
}
