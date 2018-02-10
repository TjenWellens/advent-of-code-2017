package com.example.day1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class Day1ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void given_111_expects_1() throws Exception {
		int result = captcha("112");
		assertThat(result, is(equalTo(1)));
	}

	@Test
	public void given_1122_expects_3() throws Exception {
		int result = captcha("1122");
		assertThat(result, is(equalTo(3)));
	}

	@Test
	public void given_1111_expects_4() throws Exception {
		int result = captcha("1111");
		assertThat(result, is(equalTo(4)));
	}

	@Test
	public void given_1234_expects_0() throws Exception {
		int result = captcha("1234");
		assertThat(result, is(equalTo(0)));
	}

	private int captcha(String s) {
        final String[] chars = (s + s.substring(0,1)).split("");
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
