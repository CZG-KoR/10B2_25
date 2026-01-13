package helper;

public class Pause {


    public static void ns(int time) {
        try {
            Thread.sleep(time/1000);
        } catch (InterruptedException ex) {

        }
    }
    public static void ms(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {

        }
    }

    public static void s(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException ex) {

        }
    }
}