public class Main {
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team ravensPro = new Team("Ravens Pro");
        ravensPro.addPlayer(joe);
        ravensPro.addPlayer(pat);
        ravensPro.addPlayer(beckham);

        System.out.println(ravensPro.numPlayers());
    }
}
