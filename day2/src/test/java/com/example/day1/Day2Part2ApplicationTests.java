package com.example.day1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class Day2Part2ApplicationTests {

    private Checksum checksum;

    @Before
    public void setUp() throws Exception {
        checksum = new DivisibleChecksum();
    }

    @Test
    public void row_5_9_2_8_returns_4() throws Exception {
        assertThat(checksum.calculate("5 9 2 8"), is(equalTo(4)));
    }

    @Test
    public void row_9_4_7_3_returns_3() throws Exception {
        assertThat(checksum.calculate("9 4 7 3"), is(equalTo(3)));
    }

    @Test
    public void row_3_8_6_5_returns_2() throws Exception {
        assertThat(checksum.calculate("3 8 6 5"), is(equalTo(2)));
    }

    @Test
    public void sheet_returns_9() throws Exception {
        String sheet = ""
                + "5 9 2 8"
                + "\n"
                + "9 4 7 3"
                + "\n"
                + "3 8 6 5"
                ;
        assertThat(checksum.calculate(sheet), is(equalTo(9)));
    }
}
