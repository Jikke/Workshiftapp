/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workishiftapp.workshiftapp.mockito;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import workshiftapp.workshiftapp.Period;
import org.junit.Assert;
import org.mockito.BDDMockito.*;
import org.mockito.Mockito.*;
import org.hamcrest.Matcher;
import org.hamcrest.CoreMatchers;
import static org.mockito.Mockito.*;

/**
 *
 * @author jeoleivo
 */
public class WorkshiftappMockitoTest {
    
    public WorkshiftappMockitoTest() {
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

     @Test
     public void getEmployeesWorksProperly_usingAMock(){
         Period testPeriod = mock(Period.class);
     }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}
