package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Christoph on 23.11.2014.
 */
public final class ConsoleHelper {

    /**
     * liest die Konsoleneingabe und gibt die Eingabe zurueck
     *
     * @return
     */
    public static String readFromConsole(){
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferRead.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * liest die Konsoleneingabe eines integer Wertes
     *
     * @return
     */
    public static int readIntFromConsole(){
        return Integer.valueOf(readFromConsole());
    }

    /**
     * liest die Konsoleneingabe eines double Wertes
     *
     * @return
     */
    public static double readDoubleFromConsole(){
        return Double.valueOf(readFromConsole());
    }

    /**
     * clears the console, but didn't worked out for windows 8.1
     */
    @Deprecated
    public static void clearConsole(){
        try
        {
            final String os = System.getProperty("os.name");

            Process p = os.contains("Windows") ? Runtime.getRuntime().exec("cls") : Runtime.getRuntime().exec("clear");

//            if (os.contains("Windows"))
//                Runtime.getRuntime().exec("cls");
//            else
//                Runtime.getRuntime().exec("clear");
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
    }

}
