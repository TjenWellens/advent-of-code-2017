package com.example.day1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class Day2ApplicationTests {

    @Test
    public void row_5_1_9_5_returns_8() throws Exception {
        assertThat(checksum("5 1 9 5"), is(equalTo(8)));
    }

    @Test
    public void row_7_5_3_returns_4() throws Exception {
        assertThat(checksum("7 5 3"), is(equalTo(4)));
    }

    @Test
    public void row_2_4_6_8_returns_6() throws Exception {
        assertThat(checksum("2 4 6 8"), is(equalTo(6)));
    }

    @Test
    public void sheet_returns_18() throws Exception {
        String sheet = ""
                + "5 1 9 5"
                + "\n"
                + "7 5 3"
                + "\n"
                + "2 4 6 8"
                ;
        assertThat(checksum(sheet), is(equalTo(18)));
    }

    private int checksum(String s) {
        return 0;
    }
}
