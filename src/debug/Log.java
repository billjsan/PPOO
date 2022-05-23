package debug;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    public static final boolean ISLOGABLE = true;
    private static final String TAG = "PPOO";

    public static void d(String subtag, String message){

        System.out.println(getCurrentTimeFormatted() + " [" + TAG + "] [" + subtag + "] " + message);
    }

    private static String getCurrentTimeFormatted() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }
}
