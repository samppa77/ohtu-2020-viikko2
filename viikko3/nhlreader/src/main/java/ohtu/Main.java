/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author mluukkai
 */
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println(bodyText);

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        for (Player player : players) {
            player.setPoints(player.getGoals() + player.getAssists());
        }

        // Järjestetään
        ArrayList<Player> playersNotFiltered = new ArrayList<Player>(Arrays.asList(players));
        ArrayList<Player> playersFiltered = new ArrayList<Player>();

        // Poistetaan ei suomalaiset
        for (Player player : playersNotFiltered) {
            if (player.getNationality().equals("FIN")) {
                playersFiltered.add(player);
            }
        }
        
//        System.out.println("Tehdään sorttaus");        
        ArrayList<Player> playersSorted = new ArrayList<>();
        while (!playersFiltered.isEmpty()) {
            Player suurinPelaaja = new Player();
            int suurin = -1;
            for (Player player : playersFiltered) {
                if (player.getPoints() > suurin) {
                    suurin = player.getPoints();
                    suurinPelaaja = player;
                }
            }
            playersSorted.add(suurinPelaaja);
            playersFiltered.remove(suurinPelaaja);
        }

// Tulostetaan sortatut        
        for (Player player : playersSorted) {
                System.out.print(player.getName() + " ");
                System.out.print(player.getTeam() + " ");
                System.out.print(player.getGoals() + " + ");
                System.out.print(player.getAssists() + " = ");
                System.out.print(player.getPoints() + " ");
                System.out.println(player.getNationality());
        }

    }

}
