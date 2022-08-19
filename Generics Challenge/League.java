import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    // fields
    private String name;
    private ArrayList<T> league = new ArrayList<T>();

    // constructor
    public League(String name) {
        this.name = name;
    }

    // add method
    public boolean addTeam(T team) {
        if (league.contains(team)) {
            return false;
        }
        league.add(team);
        return true;
    }

    // method to show teams in order of their points
    public void showLeagueTable() {
        // Collections.sort() works only of the 'compareTo()' method for the
        // list has been implemented, it automatically uses it in the background
        Collections.sort(league);
        System.out.println("----------------------------------");
        for (T team : league) {
            System.out.println(team.getName() + "\t: " + team.ranking());
        }
        System.out.println("----------------------------------");
    }
}
