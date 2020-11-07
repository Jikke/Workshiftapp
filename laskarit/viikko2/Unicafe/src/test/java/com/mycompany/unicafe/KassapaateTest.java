/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author jeoleivo
 */
public class KassapaateTest {
    
    Kassapaate paate;
    Maksukortti kortti;

    @Before
    public void setUp() {
        paate = new Kassapaate();
    }
    
    @Test
    public void luodunPaatteenRahat() {
        assertTrue(0==paate.edullisiaLounaitaMyyty());
        assertTrue(0==paate.maukkaitaLounaitaMyyty());
        assertTrue(100000==paate.kassassaRahaa());      
    }
    
    @Test
    public void riittavaEdullinenKateisostoToimii() {
        assertTrue(260==paate.syoEdullisesti(500));
        assertTrue(1==paate.edullisiaLounaitaMyyty());
        assertTrue(100240==paate.kassassaRahaa());
    }
    
    @Test
    public void riittamatonEdullinenKateisostoToimii() {
        assertTrue(200==paate.syoEdullisesti(200));
        assertTrue(0==paate.edullisiaLounaitaMyyty());
        assertTrue(100000==paate.kassassaRahaa());
    }
    
    @Test
    public void riittavaMaukasKateisostoToimii() {
        assertTrue(100==paate.syoMaukkaasti(500));
        assertTrue(1==paate.maukkaitaLounaitaMyyty());
        assertTrue(100400==paate.kassassaRahaa());
    }
    
    @Test
    public void riittamatonMaukasKateisostoToimii() {
        assertTrue(300==paate.syoMaukkaasti(300));
        assertTrue(0==paate.maukkaitaLounaitaMyyty());
        assertTrue(100000==paate.kassassaRahaa());
    }
    
    @Test
    public void riittavaEdullinenKorttimaksuToimii() {
        kortti = new Maksukortti(1000);
        assertTrue(paate.syoEdullisesti(kortti));
        assertTrue(760==kortti.saldo());
        assertTrue(1==paate.edullisiaLounaitaMyyty());
        assertTrue(100240==paate.kassassaRahaa());
    }
    
    @Test
    public void riittavaMaukasKorttimaksuToimii() {
        kortti = new Maksukortti(1000);
        assertTrue(paate.syoMaukkaasti(kortti));
        assertTrue(600==kortti.saldo());
        assertTrue(1==paate.maukkaitaLounaitaMyyty());
        assertTrue(100400==paate.kassassaRahaa());
    }
    
    @Test
    public void riittamatonEdullinenKorttimaksuToimii() {
        kortti = new Maksukortti(200);
        assertTrue(false==paate.syoEdullisesti(kortti));
        assertTrue(200==kortti.saldo());
        assertTrue(0==paate.edullisiaLounaitaMyyty());
        assertTrue(100000==paate.kassassaRahaa());
    }
    
    @Test
    public void riittamatonMaukasKorttimaksuToimii() {
        kortti = new Maksukortti(200);
        assertTrue(false==paate.syoMaukkaasti(kortti));
        assertTrue(200==kortti.saldo());
        assertTrue(0==paate.maukkaitaLounaitaMyyty());
        assertTrue(100000==paate.kassassaRahaa());
    }
    
    @Test
    public void kortilleLatausToimii() {
        kortti = new Maksukortti(200);
        paate.lataaRahaaKortille(kortti, 100);
        assertTrue(300==kortti.saldo());
        assertTrue(100100==paate.kassassaRahaa());
    }
    
    @Test
    public void kortilleLatausEiToimii() {
        kortti = new Maksukortti(200);
        paate.lataaRahaaKortille(kortti, -100);
        assertTrue(200==kortti.saldo());
        assertTrue(100000==paate.kassassaRahaa());
    }
}
