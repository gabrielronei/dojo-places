package br.com.alura.dojoplaces.utils;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class DaysUtil {

    public static String between(Temporal start, Temporal end) {
        long days = ChronoUnit.DAYS.between(start, end);

        if (days < 0) return "-";
        if (days == 0) return "Hoje";
        if (days == 1) return "1 dia atrás";
        return "%d dias atrás".formatted(days);
    }
}
