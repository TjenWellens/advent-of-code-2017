package com.example.day1;

import java.util.Arrays;

public class CaptchaSolver {
    public int solve(String captcha) {
        final String[] chars = (captcha + captcha.substring(0,1)).split("");
        final int[] digits = Arrays.asList(chars).stream().mapToInt(Integer::parseInt).toArray();
        return addIfSameDigitAsBefore(digits, 1);
    }

    private int addIfSameDigitAsBefore(int[] digits, int index) {
        if(index >= digits.length)
            return 0;

        int previousDigit = digits[index - 1];
        int currentDigit = digits[index];
        if(previousDigit == currentDigit)
            return previousDigit + addIfSameDigitAsBefore(digits, index + 1);
        else
            return addIfSameDigitAsBefore(digits, index + 1);
    }
}
