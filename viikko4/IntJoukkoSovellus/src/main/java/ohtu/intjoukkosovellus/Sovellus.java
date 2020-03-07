package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;
    private static Scanner lukija;

    
    private static IntJoukko mikaJoukko() {
        while (true) {
            String luettu = lukija.nextLine().toUpperCase();
            if (luettu.equals("A")) {
                return A;
            } else if (luettu.equals("B")) {
                return B;
            } else if (luettu.equals("C")) {
                return C;
            } else {
                System.out.println("Virheellinen joukko! " + luettu);
                System.out.print("Yritä uudelleen!");
            }
        }
    }

    private static void lisaa() {
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko();
        System.out.println("");
        System.out.print("Mikä luku lisätään? ");
        int lisattavaLuku = lukija.nextInt();
        joukko.lisaa(lisattavaLuku);
    }

    private static void yhdiste() {
        IntJoukko aJoukko, bJoukko, c;
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        c = IntJoukko.yhdiste(aJoukko, bJoukko);
        System.out.println("A yhdiste B = " + c.toString());
    }

    private static void leikkaus() {
        IntJoukko aJoukko, bJoukko, c;
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        c = IntJoukko.leikkaus(aJoukko, bJoukko);
        System.out.println("A leikkaus B = " + c.toString());
    }

    private static void erotus() {
        IntJoukko aJoukko, bJoukko, c;
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        c = IntJoukko.erotus(aJoukko, bJoukko);
        System.out.println("A erotus B = " + c.toString());
    }

    private static void poista() {
        System.out.print("Mistä joukosta? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku poistetaan? ");
        int lisLuku = lukija.nextInt();
        joukko.poista(lisLuku);
    }

    private static void kuuluu() {
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku? ");
        int kysLuku = lukija.nextInt();
        boolean kuuluuko = joukko.kuuluu(kysLuku);
        if (kuuluuko) {
            System.out.println(kysLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysLuku + " ei kuulu joukkoon ");
        }
    }

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        String luettu;

        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");

        Scanner lukija = new Scanner(System.in);
        while (true) {
            luettu = lukija.nextLine();
            if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa();
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista();
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu();
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                yhdiste();
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                leikkaus();
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                erotus();
            } else if (luettu.equalsIgnoreCase("A")) {
                System.out.println(A);
            } else if (luettu.equalsIgnoreCase("B")) {
                System.out.println(B);
            } else if (luettu.equalsIgnoreCase("C")) {
                System.out.println(C);
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento! " + luettu);
                System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            }
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }
}
