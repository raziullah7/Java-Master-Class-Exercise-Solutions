import java.util.ArrayList;

// bounded type arguments, Player is said to be upper bound of T
public class Team<T extends Player> implements Comparable<Team<T>> {
    // public class Team<T extends Player & Coach & Manager> {...}
// but only player will be a class and remaining will be interfaces
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;
    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public boolean addPlayer(T player) {
        if (members.contains(player)) {
//  this line gives an error unless it is explicitly cast in
//  the required type (not recommended) (ugly AF)
//            System.out.println(((Player) player).getName() + " is already in the team");
            // the above cast is removed because of the bounded type argument due to
            // which Player is said to be upper bound of T
            System.out.println(player.getName() + " is already in the team");
            return false;
        }
        else {
            members.add(player);
//  this line gives an error unless it is explicitly cast in
//  the required type (not recommended) (ugly AF)
//            System.out.println(((Player) player).getName() + " is already in the team");
            // the above cast is removed because of the bounded type argument due to
            // which Player is said to be upper bound of T
            System.out.println(player.getName() + " is already in the team");
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }


    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        String message;
        if (ourScore > theirScore) {
            won++;
            message = " beat ";
        }
        else if (ourScore == theirScore) {
            tied++;
            message = " drew with ";
        }
        else {
            lost++;
            message = " lost to ";
        }
        played++;

        if (opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}