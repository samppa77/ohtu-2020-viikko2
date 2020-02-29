package ohtu;

public class TennisGame {

    private int m_score1;
    private int m_score2;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.m_score1 = 0;
        this.m_score2 = 0;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            this.m_score1 += 1;
        } else {
            this.m_score2 += 1;
        }
    }

    public String getScore() {
        if (this.m_score1 == this.m_score2) {
            return evenScore(this.m_score1);
        }
        if (this.m_score1 >= 4 || this.m_score2 >= 4) {
            return overScore(this.m_score1, this.m_score2);
        }
        return otherScore(this.m_score1, this.m_score2);
    }

    private String evenScore(int score1) {
        switch (score1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    String overScore(int score1, int score2) {
        int minusResult = score1 - score2;
        if (minusResult == 1) {
            return "Advantage player1";
        }
        if (minusResult == -1) {
            return "Advantage player2";
        }
        if (minusResult >= 2) {
            return "Win for player1";
        }
        return "Win for player2";

    }

    String otherScore(int score1, int score2) {
        int tempScore = 0;
        String score = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = score1;
            } else {
                score += "-";
                tempScore = score2;
            }
            score = setScore(score, tempScore);
        }
        return score;
    }

    
    String setScore(String score, int tempScore) {
        switch (tempScore) {
            case 0:
                return score + "Love";
            case 1:
                return score + "Fifteen";
            case 2:
                return score + "Thirty";
            case 3:
                return score + "Forty";
        }
        return score;
    }

}
