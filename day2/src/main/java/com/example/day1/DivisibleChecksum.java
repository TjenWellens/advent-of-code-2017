package com.example.day1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class DivisibleChecksum extends Checksum {
    private static final Logger log = LoggerFactory.getLogger(DivisibleChecksum.class);

    @Override
    protected int calculateRow(String row) {
        return getEvenDivideResult(getIntStream(row).toArray(), 0, 2);
    }

    int getEvenDivideResult(int[] numbers, int dividerIndex, int times) {
        if (dividerIndex >= numbers.length) {
            // no even division possible
            log.debug("no division possible");
            return -1;
        }

        final int divider = numbers[dividerIndex];
        final int attempt = divider * times;
        final int maxNumber = Arrays.stream(numbers).max().getAsInt();

        if (attempt > maxNumber) {
            // try with next number
            log.trace(String.format("try next number (dividerIndex + 1 = %d, times = %d)", dividerIndex + 1, times));
            return getEvenDivideResult(numbers, dividerIndex + 1, 2);
        }

        final boolean evenDivision = Arrays.stream(numbers).anyMatch(dividee -> dividee == attempt);
        if (!evenDivision) {
            // try next multiplication
            log.trace(String.format("try next multiplication (dividerIndex = %d, times = %d)", dividerIndex, times + 1));
            return getEvenDivideResult(numbers, dividerIndex, times + 1);
        }

        log.debug(String.format("found one! index = %d, number = %d, times = %d", dividerIndex, divider, times));
        return times;
    }
}
