package com.example.day1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Checksum {
    public int calculate(String sheet) {
        if(sheet.contains("\n")) {
            return Arrays.stream(sheet.split("\n"))
                    .mapToInt(this::calculate)
                    .sum();
        }

        String row = sheet;
        return calculateRow(row);
    }

    protected int calculateRow(String row) {
        return getIntStream(row).max().getAsInt() - getIntStream(row).min().getAsInt();
    }

    protected IntStream getIntStream(String row) {
        return Arrays.stream(row.split("\\s+")).mapToInt(Integer::parseInt);
    }
}
