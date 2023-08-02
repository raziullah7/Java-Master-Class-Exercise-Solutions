public class Main {
    public static String SecondsToTime(int sec) {
        int hours = 0, minutes = 0;
        int seconds = sec % 60;

        for (int i = 0; i < sec; i+=60) {
            minutes++;
        }

        for (int i = 0; i < minutes; i+=60) {
            hours++;
        }

        minutes = (minutes % 60) - 1;
        hours = (hours % 60) - 1;

        String time = hours + " : " + minutes + " : " + seconds;
        return "Seconds converted to Hours, Minutes and Seconds is: " + time ;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(SecondsToTime(33218));
    }
}