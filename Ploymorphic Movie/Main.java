public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Movie movie = randomMovie();
            System.out.println("Movie # " + i + " : " + movie.getName() + '\n' +
                                "Plot : " + movie.plot() + '\n');
        }
    }

    public static Movie randomMovie() {
        int randomNum = (int) (Math.random() * 5) + 1;
        System.out.println("Generated random number : " + randomNum);
        return switch (randomNum) {
            case 1 -> new BladeRunner();
            case 2 -> new DraculaUntold();
            case 3 -> new IpMan();
            case 4 -> new Jaws();
            case 5 -> new Forgettable();
            default -> null;
        };
    }
}
