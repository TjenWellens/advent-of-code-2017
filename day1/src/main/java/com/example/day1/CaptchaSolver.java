package com.example.day1;

import java.util.Arrays;

public class CaptchaSolver {
    public int solve(String captcha) {
        final String[] chars = captcha.split("");
        final int[] digits = Arrays.asList(chars).stream().mapToInt(Integer::parseInt).toArray();
        return addIfSameDigitAsBefore(digits, 0);
    }

    private int addIfSameDigitAsBefore(int[] digits, int index) {
        if (index >= digits.length)
            return 0;

        int currentDigit = digits[index];
        int nextDigit = digits[(index + 1) % digits.length];
        if (currentDigit == nextDigit)
            return currentDigit + addIfSameDigitAsBefore(digits, index + 1);
        else
            return addIfSameDigitAsBefore(digits, index + 1);
    }
}
