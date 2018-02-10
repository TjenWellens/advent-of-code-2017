package com.example.day1;

import org.junit.Before;
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

    private CaptchaSolver captchaSolver;

    @Test
	public void contextLoads() {
	}

    @Before
    public void setUp() throws Exception {
        captchaSolver = new CaptchaSolver();
    }

    @Test
	public void given_112_expects_1() throws Exception {
		int result = captchaSolver.solve("112");
		assertThat(result, is(equalTo(1)));
	}

	@Test
	public void given_1122_expects_3() throws Exception {
		int result = captchaSolver.solve("1122");
		assertThat(result, is(equalTo(3)));
	}

	@Test
	public void given_1111_expects_4() throws Exception {
		int result = captchaSolver.solve("1111");
		assertThat(result, is(equalTo(4)));
	}

	@Test
	public void given_1234_expects_0() throws Exception {
		int result = captchaSolver.solve("1234");
		assertThat(result, is(equalTo(0)));
	}

	@Test
	public void given_91212129_expects_9() throws Exception {
		int result = captchaSolver.solve("91212129");
		assertThat(result, is(equalTo(9)));
	}
}
