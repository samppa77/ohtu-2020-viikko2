package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        // seuraavassa osoitteessa 27.11.2019 päivitetyt tilastot
        String url = "https://nhl27112019.herokuapp.com/players.txt"; // ajan tasalla olevat tilastot osoitteessa
        // "https://nhlstatisticsforohtu.herokuapp.com/players.txt"

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        // 0.  Oli valmiina
//        Matcher m = new And(new HasAtLeast(5, "goals"),
//                new HasAtLeast(5, "assists"),
//                new PlaysIn("PHI")
//        );
//
        // 1. Eka - and
//        Matcher m = new And(
//                new Not(new HasAtLeast(1, "goals")),
//                new PlaysIn("NYR")
//        );
//
        // 2. Jälkimmäinen - toimii -hasFewer
//        Matcher m = new And(
//                new HasFewerThan(1, "goals"),
//                new PlaysIn("NYR")
//        );
        // 3.  ALL
//        Matcher m = new All(
//                new PlaysIn("NYR")
//        );
// Tehtava 3:
        // a) OR
//        Matcher m = new Or(new HasAtLeast(20, "goals"),
//                new HasAtLeast(20, "assists")
//        );
//
//        
//        for (Player player : stats.matches(m)) {
//            System.out.println(player);
//        }
        // b) OR
//        Matcher m = new And(
//                new HasAtLeast(20, "points"),
//                new Or(
//                        new PlaysIn("NYR"),
//                        new PlaysIn("NYI"),
//                        new PlaysIn("NJD")
//                )
//        );
//
//
//
// Tehtava 4: a)
//        QueryBuilder query = new QueryBuilder();
//        Matcher m = query.build();
//
//        for (Player player : stats.matches(m)) {
//            System.out.println(player);
//        }

//
//
//
// Tehtava 4: b)
        QueryBuilder query = new QueryBuilder();

        Matcher m = query.playsIn("NYR").build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

    }
}
