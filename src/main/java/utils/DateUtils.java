package utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Created by apreda on 25.07.2016.
 */
public class DateUtils {

    public static boolean timeInLast15Minutes(LocalDateTime timestamp){
        LocalDateTime currentDate = LocalDateTime.now();
        return timestamp.until( currentDate, ChronoUnit.MINUTES) < 15;
    }
}
