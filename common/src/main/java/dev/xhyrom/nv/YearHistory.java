package dev.xhyrom.nv;

import java.util.Arrays;

public enum YearHistory {
    // YEAR_2026(26, 4), // how many drops were there in 2026
    // YEAR_2027(27, 3); // how many drops were there in 2027
    ;

    final int year;
    final int totalDrops;

    YearHistory(int year, int totalDrops) {
        this.year = year;
        this.totalDrops = totalDrops;
    }

    public static int getOffsetForYear(int currentYear) {
        return Arrays.stream(values())
                .filter(h -> h.year < currentYear)
                .mapToInt(h -> h.totalDrops)
                .sum();
    }
}

