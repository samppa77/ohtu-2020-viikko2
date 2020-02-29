package ohtu;

public class Player {
    private String name;
    private String team;
    private int goals;
    private int assists;
    private int penalties;
    private String nationality;
    private int points;

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.name = team;
    }
    public void setGoals(int goals) {
        this.goals = goals;
    }
    public void setAssists(int assists) {
        this.assists = assists;
    }
    public void setPoints(int points) {
        this.points = points;
    }    

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return this.team;
    }
    public int getGoals() {
        return this.goals;
    }
    public int getAssists() {
        return this.assists;
    }
    public int getPoints() {
        return this.points;
    }    
    public int getPenalties() {
        return this.penalties;
    }
    public String getNationality() {
        return this.nationality;
    }



    @Override
    public String toString() {
        return name;
    }

/*    
    @Override
    public int compareTo(Player o) {
        return this.getPoints().compareTo(o.getPoints());
    }
*/


}
