package com.example.day1;

public class VariableOffsetCaptchaSolver extends CaptchaSolver {
    @Override
    protected int compareWithIndex(int index, int length) {
        final int offset = length / 2;
        return (index + offset) % length;
    }
}
