package InputOutput;

import java.util.*;

/**
 *
 * @author nieschri125
 */
public class Keyboard {

    static Scanner keyboard = new Scanner(System.in);
    static String inputText = "";

    public static String readString() {
        return keyboard.nextLine();
    }

    public static int readInt() {
        return keyboard.nextInt();
    }

    public static double readDouble() {
        return keyboard.nextDouble();
    }

    public static long readLong() {

        return keyboard.nextLong();
    }

    public static boolean readBoolean() {

        return keyboard.nextBoolean();
    }
} // class


