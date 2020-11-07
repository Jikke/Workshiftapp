package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void luodunKortinSaldoOikein() {
        assertTrue(10==kortti.saldo());      
    }
    
    @Test
    public void rahanLataaminenToimii() {
        kortti.lataaRahaa(10);
        assertTrue(20==kortti.saldo());      
    }
    
    @Test
    public void rahanVahentaminenToimii() {
        assertTrue(true==kortti.otaRahaa(5));
        assertTrue(5==kortti.saldo());
    }
    
    @Test
    public void rahaaEiVahennetaLiikaa() {
        assertTrue(false==kortti.otaRahaa(15));
        assertTrue(10==kortti.saldo());      
    }
    
    @Test
    public void tulosteenTestaus() {
        assertEquals("saldo: 0.10", kortti.toString());      
    }
}
