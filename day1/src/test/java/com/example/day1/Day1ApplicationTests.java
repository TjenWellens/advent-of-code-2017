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
@SpringBootTest
public class Day1ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void given_11_expects_1() throws Exception {
		int result = captcha("11");
		assertThat(result, is(equalTo(1)));
	}

	private int captcha(String s) {
        final String[] chars = s.split("");
        final int[] digits = Arrays.asList(chars).stream().mapToInt(Integer::parseInt).toArray();
        return digits[0];
	}
}
