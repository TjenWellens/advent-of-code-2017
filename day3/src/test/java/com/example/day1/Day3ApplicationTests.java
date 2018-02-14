package com.example.day1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class Day3ApplicationTests {

	@Test
	public void square_1_is_0() {
		assertThat(steps(1), is(0));
	}

	@Test
	public void square_12_is_3() {
		assertThat(steps(12), is(3));
	}

	@Test
	public void square_23_is_2() {
		assertThat(steps(23), is(2));
	}

	@Test
	public void square_26_is_5() {
		assertThat(steps(26), is(5));
	}

	@Test
	public void square_47_is_4() {
		assertThat(steps(47), is(4));
	}

	@Test
	public void square_48_is_5() {
		assertThat(steps(48), is(5));
	}

	@Test
	public void square_49_is_6() {
		assertThat(steps(49), is(6));
	}

	@Test
	public void square_50_is_7() {
		assertThat(steps(50), is(7));
	}

	@Test
	public void square_1024_is_31() {
		assertThat(steps(1024), is(31));
	}

	@Test
	public void solution_part_1() {
		assertThat(steps(289326), is(419));
	}

	@Test
	public void test_circle_of_1_is_0() {
		assertThat(circle(1), is(0));
	}

	@Test
	public void test_circle_of_9_is_1() {
		assertThat(circle(9), is(1));
	}

	@Test
	public void test_circle_of_10_is_2() {
		assertThat(circle(10), is(2));
	}

	@Test
	public void test_circle_of_12_is_2() {
		assertThat(circle(12), is(2));
	}

	@Test
	public void test_circle_of_23_is_2() {
		assertThat(circle(1), is(0));
	}

	@Test
	public void test_circle_of_26_is_3() {
		assertThat(circle(1), is(0));
	}

	@Test
	public void test_stepsInCirlce_of_9_is_1() {
		assertThat(stepsInCircle(9), is(1));
	}

	@Test
	public void test_stepsInCirlce_of_10_is_1() {
		assertThat(stepsInCircle(10), is(1));
	}

	@Test
	public void test_stepsInCirlce_of_13_is_2() {
		assertThat(stepsInCircle(10), is(1));
	}

	private int steps(int square) {
		final int stepsToCircle = stepsToCircle(square);
		final int stepsInCircle = stepsInCircle(square);
		return stepsToCircle + stepsInCircle;
	}

	private int stepsInCircle(int square) {
		if(square==1)
			return 0;
		int circle = circle(square);
		int nthInCircle = nthInCircle(square);
		int squaresInSide = squaresInCircle(circle) / 4;
		int nthInSide = nthInCircle % squaresInSide;
		int offset = - (circle - 1);
		return Math.abs(nthInSide + offset );
	}

	private int stepsToCircle(int square) {
		return circle(square);
	}

	private int circle(int square) {
		if (square == 1)
			return 0;

		int sum = 1;
		int circle = 0;
		while (square > sum) {
			circle++;
			sum += squaresInCircle(circle);
		}

		return circle;
	}

	private int nthInCircle(int square) {
		for (int circle = 0; square > squaresInCircle(circle); circle++) {
			square -= squaresInCircle(circle);
		}
		return square - 1;
	}

	private int squaresInCircle(int circle) {
		if (circle == 0) {
			return 1;
		}
		return circle * 8;
	}
}
