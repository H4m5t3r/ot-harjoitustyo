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
    public void kortinSaldonAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(5000);
        assertEquals("saldo: 50.10", kortti.toString());
    }
    
    @Test
    public void rahanOttaminenToimiiOikein() {
        kortti = new Maksukortti(1000);
        assertEquals(kortti.otaRahaa(5), true);
        assertEquals("saldo: 9.95", kortti.toString());
        
        assertEquals(kortti.otaRahaa(1000), false);
        assertEquals("saldo: 9.95", kortti.toString());
    }
    
    @Test
    public void saldoOikein() {
        kortti = new Maksukortti(1000);
        assertEquals(1000, kortti.saldo());
    }
}
