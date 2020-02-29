/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/*
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
 */
/**
 *
 * @author sampo
 */
public class KauppaTest {

    private Pankki pankki;
    private Viitegeneraattori viite;
    private Varasto varasto;
    private Kauppa k;

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);

        // määritellään että viitegeneraattori palauttaa viitten 42
        //when(viite.uusi()).thenReturn(42);

        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        // määritellään että tuote numero 2 on maito jonka hinta on 6 ja saldo 15
        when(varasto.saldo(2)).thenReturn(15);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipä", 6));

        // määritellään että tuote numero 2 on maito jonka hinta on 7 ja saldo 0
        when(varasto.saldo(3)).thenReturn(0);
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "voi", 7));

        k = new Kauppa(varasto, pankki, viite);

    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), anyInt());
    }

    // 1.
    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("matti", "23456");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("matti"), anyInt(), eq("23456"), anyString(), eq(5));

    }

    // 2.
    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla2() {
        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(2);     // ostetaan tuotetta numero 2 eli leipä
        k.tilimaksu("matti", "23456");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("matti"), anyInt(), eq("23456"), anyString(), eq(11));

    }

    // 3.
    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla2samaa() {
        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 2 eli leipä
        k.tilimaksu("matti", "23456");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("matti"), anyInt(), eq("23456"), anyString(), eq(10));

    }

    // 4.
    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla2ToinenTyhja() {
        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(3);     // ostetaan tuotetta numero 2 eli leipä
        k.tilimaksu("matti", "23456");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("matti"), anyInt(), eq("23456"), anyString(), eq(5));

    }

    // Teht 5 a)
    @Test
    public void asioinninAloitusAlustaaTilanteen() {
        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("matti", "23456");
        k.aloitaAsiointi();
        k.tilimaksu("pekka", "34567");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("34567"), anyString(), eq(0));

    }

    // Teht 5 b)
    @Test
    public void uudetViitteetMuodostuvat() {

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("matti", "23456");
        verify(viite, times(1)).uusi();

        k.aloitaAsiointi();
        k.lisaaKoriin(2);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "34567");
        verify(viite, times(2)).uusi();


    }

}
