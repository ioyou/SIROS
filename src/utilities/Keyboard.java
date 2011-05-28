/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.*;

/**
 *
 * @author Chris
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

