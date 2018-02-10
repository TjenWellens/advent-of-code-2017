package com.example.day1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class Day1Part2Tests {

    private CaptchaSolver captchaSolver;

    @Before
    public void setUp() throws Exception {
        captchaSolver = new VariableOffsetCaptchaSolver();
    }

    @Test
	public void given_1212_expects_6() throws Exception {
		int result = captchaSolver.solve("1212");
		assertThat(result, is(equalTo(6)));
	}

    @Test
	public void given_1221_expects_0() throws Exception {
		int result = captchaSolver.solve("1221");
		assertThat(result, is(equalTo(0)));
	}

    @Test
	public void given_123425_expects_4() throws Exception {
		int result = captchaSolver.solve("123425");
		assertThat(result, is(equalTo(4)));
	}

    @Test
	public void given_123123_expects_12() throws Exception {
		int result = captchaSolver.solve("123123");
		assertThat(result, is(equalTo(12)));
	}

    @Test
	public void given_12131415_expects_4() throws Exception {
		int result = captchaSolver.solve("12131415");
		assertThat(result, is(equalTo(4)));
	}

}
