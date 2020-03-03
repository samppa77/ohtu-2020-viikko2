/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author sampo
 */
public class Erotus extends Komento {

    private Sovelluslogiikka sovellus;
    private TextField syotekentta;
    private TextField tuloskentta;

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
    }

    public void suorita() {
        int arvo = Integer.parseInt(this.syotekentta.getText());
        this.sovellus.miinus(arvo);
        int laskunTulos = sovellus.tulos();
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + laskunTulos);
    }

//    public void peru() { }

}
