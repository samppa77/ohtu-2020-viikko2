/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author sampo
 */
public class Or implements Matcher {

    private Matcher[] matchers;

    public Or(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        boolean loytyi = false;
        for (Matcher matcher : matchers) {
            if (matcher.matches(p)) {                
                loytyi =  true;
            }
        }
        if (loytyi == true){
            return true;
        }        
        return false;
    }

}
