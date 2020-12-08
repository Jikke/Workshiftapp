package workshiftapptest;

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

        testPeriod = new Period(3, 3, 2);
        testDay = new Day("Test", 3, 3, 2);
        testList = new ArrayList<>();
        testEmployee = new Person("testEmployee");
        testPeriod.addEmployee(testEmployee);

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
        assertEquals(3, testDay.getMorningMin());
        assertEquals(3, testDay.getEveningMin());
        assertEquals(2, testDay.getNightMin());
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
    public void constructorCreatesPeriodProperly() {
        assertEquals("[Maanantai1, Tiistai1, Keskiviikko1, Torstai1, Perjantai1, Lauantai1, Sunnuntai1, "
                + "Maanantai2, Tiistai2, Keskiviikko2, Torstai2, Perjantai2, Lauantai2, Sunnuntai2, "
                + "Maanantai3, Tiistai3, Keskiviikko3, Torstai3, Perjantai3, Lauantai3, Sunnuntai3]",
                 testPeriod.getDays().toString());
    }

//     @Test
//     public void personAddAndGetShiftTest(){
//         Person testPerson = new Person("testPerson");
//         testPerson.addShift("Tiistai2", "ilta");
//         int dayIndex = testPerson.getDayIndex("Tiistai2");
//         assertEquals("ilta",testPerson.getShift(dayIndex));
//     }
    @Test
    public void periodGetDayProperArgument() {
        assertEquals(testPeriod.getDays().get(15), testPeriod.findDay("Tiistai3"));
    }

    @Test
    public void periodGetDayWrongArgument() {
        assertNotEquals(testPeriod.getDays().get(16), testPeriod.findDay("Tiistai3"));
    }

    @Test
    public void periodFindEmployeeProperArgument() {
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
    public void periodFindEmployeeWrongArgument() {
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
    public void periodIsEmployeeAvailableYes(){
         
         Day day2 = testPeriod.getDays().get(1);
         Day day3 = testPeriod.getDays().get(2);
         day2.setShift(testEmployee.getName(), "aamu");
         day3.setShift(testEmployee.getName(), "vapaa");
         boolean free = testPeriod.isEmployeeAvailable(testEmployee,day3,"ilta");
         assertEquals(true, free);
     }
     
     @Test
     public void periodIsEmployeeAvailableNo(){
         testDay = new Day("Tiistai1",3,3,2);
         testPeriod.setEmployeeMorning(testDay, testEmployee.getName());
         boolean free = testPeriod.isEmployeeAvailable(testEmployee,testDay,"ilta");
         assertEquals(false, free);
     }
     
      @Test
    public void dayFindEmloyeeShiftProperArgument() {
        Day day2 = testPeriod.getDays().get(1);
        day2.setShift(testEmployee.getName(), "aamu");
        assertEquals("aamu", day2.findEmployeeShift(testEmployee.getName()));
    }
     
     @Test
    public void dayRemoveShiftMorning() {
        Day day2 = testPeriod.getDays().get(1);
        day2.setShift(testEmployee.getName(), "aamu");
        day2.removeShift(testEmployee.getName());
        assertEquals(null, day2.findEmployeeShift(testEmployee.getName()));
    }
    
     @Test
    public void periodSetEmployeeMorningProperArgument() {
        testPeriod.setEmployeeMorning(testPeriod.getDays().get(1),testEmployee.getName());
        assertEquals("aamu",testPeriod.getDays().get(1).findEmployeeShift(testEmployee.getName()));
    }
    
     @Test
    public void periodSetEmployeeEveningProperArgument() {
        testPeriod.setEmployeeEvening(testPeriod.getDays().get(1),testEmployee.getName());
        assertEquals("ilta", testPeriod.getDays().get(1).findEmployeeShift(testEmployee.getName()));
    }
    
     @Test
    public void periodSetEmployeeNightProperArgument() {
        testPeriod.setEmployeeNight(testPeriod.getDays().get(1),testEmployee.getName());
        assertEquals("yö", testPeriod.getDays().get(1).findEmployeeShift(testEmployee.getName()));
    }
    
     @Test
    public void periodSetEmployeeDayoffProperArgument() {
        testPeriod.setEmployeeDayoff(testPeriod.getDays().get(1),testEmployee.getName());
        assertEquals("vapaa", testPeriod.getDays().get(1).findEmployeeShift(testEmployee.getName()));
    }
    
    @Test
    public void dayRemoveShiftEvening() {
        testDay.setShift(testEmployee.getName(), "ilta");
        testDay.removeShift(testEmployee.getName());
        assertNotEquals("ilta", testDay.findEmployeeShift(testEmployee.getName()));
    }
    
    @Test
    public void dayRemoveShiftNight() {
        testDay.setShift(testEmployee.getName(), "yö");
        testDay.removeShift(testEmployee.getName());
        assertNotEquals("yö", testDay.findEmployeeShift(testEmployee.getName()));
    }
    
    @Test
    public void dayRemoveShiftDayoff() {
        testDay.setShift(testEmployee.getName(), "vapaa");
        testDay.removeShift(testEmployee.getName());
        assertNotEquals("vapaa", testDay.findEmployeeShift(testEmployee.getName()));
    }
    
    @Test
    public void dayHowManyMoreToShiftMorning(){
        testDay.setShift(testEmployee.getName(),"aamu");
        assertEquals(2,testDay.howManyMoreToShift("aamu"));
    }
    
    @Test
    public void dayHowManyMoreToShiftEvening(){
        testDay.setShift(testEmployee.getName(),"ilta");
        assertEquals(2,testDay.howManyMoreToShift("ilta"));
    }
    
    @Test
    public void dayHowManyMoreToShiftNight(){
        testDay.setShift(testEmployee.getName(),"yö");
        assertEquals(1,testDay.howManyMoreToShift("yö"));
    }
    
    @Test
    public void dayHowManyMoreToShiftNightCapped(){
        testDay.setShift(testEmployee.getName(),"yö");
        testDay.setShift(testEmployee.getName(),"yö");
        assertEquals(-2,testDay.howManyMoreToShift("yö"));
    }
    
    @Test
    public void periodGetEmployees(){
      ArrayList<Person> employeeArray = new ArrayList<Person>();
      employeeArray.add(testEmployee);
      assertEquals(employeeArray, testPeriod.getEmployees());
    }
    
    @Test
    public void periodPrintEmployees(){
        String employeeString = "\ntestEmployee\nSecond\n";
        testPeriod.addEmployee(new Person("Second"));
        assertEquals(employeeString, testPeriod.printEmployees());
    }
}
