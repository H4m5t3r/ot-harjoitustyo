
import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    Kassapaate kassapaate;
    Maksukortti kortti;

    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        kortti = new Maksukortti(400);
    }

    @Test
    public void luodunKassapaatteenRahamaaraJaMyytyjenLounaidenMaaraOikea() {
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kateisostoToimiiEdullistenLounaidenOsalta () {
        assertEquals(260, kassapaate.syoEdullisesti(500));
        assertEquals(100240, kassapaate.kassassaRahaa());
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(100, kassapaate.syoEdullisesti(100));
        assertEquals(100240, kassapaate.kassassaRahaa());
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kateisostoToimiiMaukkaidenLounaidenOsalta () {
        kassapaate = new Kassapaate();
        assertEquals(100, kassapaate.syoMaukkaasti(500));
        assertEquals(100400, kassapaate.kassassaRahaa());
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(100, kassapaate.syoMaukkaasti(100));
        assertEquals(100400, kassapaate.kassassaRahaa());
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiostoToimiiEdullistenLounaidenOsalta () {
        kassapaate = new Kassapaate();
        assertEquals(true, kassapaate.syoEdullisesti(kortti));
        assertEquals(160, kortti.saldo());
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
        
        assertEquals(false, kassapaate.syoEdullisesti(kortti));
        assertEquals(160, kortti.saldo());
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void korttiostoToimiiMaukkaidenLounaidenOsalta () {
        kassapaate = new Kassapaate();
        kortti = new Maksukortti(500);
        assertEquals(true, kassapaate.syoMaukkaasti(kortti));
        assertEquals(100, kortti.saldo());
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
        
        assertEquals(false, kassapaate.syoMaukkaasti(kortti));
        assertEquals(100, kortti.saldo());
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kortilleRahaaLataaminenToimiiOikein () {
        kassapaate = new Kassapaate();
        kortti = new Maksukortti(500);
        kassapaate.lataaRahaaKortille(kortti, 3000);
        assertEquals(103000, kassapaate.kassassaRahaa());
        assertEquals(3500, kortti.saldo());
        
        kassapaate.lataaRahaaKortille(kortti, -500);
        assertEquals(103000, kassapaate.kassassaRahaa());
        assertEquals(3500, kortti.saldo());
    }
}
