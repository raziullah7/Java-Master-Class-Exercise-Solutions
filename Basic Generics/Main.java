public class Main {
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> ravensPro = new Team<>("Ravens Pro");
        ravensPro.addPlayer(joe);
//        ravensPro.addPlayer(pat);
//        ravensPro.addPlayer(beckham);

        System.out.println(ravensPro.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Lycaons");
        baseballTeam.addPlayer(pat);

        // won't work because of bounded type arguments in Team<T extends Player>
        /*Team<String> brokenTeam = new Team<>("This Won't Do");
        brokenTeam.addPlayer("no-one");*/

        Team<SoccerPlayer> brokenTeam = new Team<>("This Won't Do");
        brokenTeam.addPlayer(beckham);
    }
}
