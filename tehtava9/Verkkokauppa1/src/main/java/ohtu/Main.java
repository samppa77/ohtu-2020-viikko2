package ohtu;

import ohtu.verkkokauppa.*;

public class Main {

    public static void main(String[] args) {
        // Alkuperäinen
//        Kauppa kauppa = new Kauppa();
// Tehtävä 9:
//        Kauppa kauppa = new Kauppa(
//                Varasto.getInstance(),
//                Pankki.getInstance(),
//                Viitegeneraattori.getInstance()
//        );
        
// Tehtävä 10:
        Viitegeneraattori viitegen = new Viitegeneraattori();
        Kirjanpito kirjanpito = new Kirjanpito();
        Varasto varasto = new Varasto(kirjanpito);
        Pankki pankki = new Pankki(kirjanpito);
        Kauppa kauppa = new Kauppa(varasto, pankki, viitegen);

// Tehtävä 12:
        
//    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
// 
//    Viitegeneraattori viitegen = ctx.getBean(Viitegeneraattori.class);
//    Kirjanpito kirjanpito      = new Kirjanpito();
//    Varasto varasto            = new Varasto(kirjanpito);
//    Pankki pankki              = new Pankki(kirjanpito);
//    Kauppa kauppa              = new Kauppa(varasto, pankki, viitegen);        
        
        
        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        // kirjanpito
        for (String tapahtuma : kirjanpito.getTapahtumat()) {
            System.out.println(tapahtuma);
        }
    }
}
