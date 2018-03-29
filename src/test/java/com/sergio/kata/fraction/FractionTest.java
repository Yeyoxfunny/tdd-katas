package com.sergio.kata.fraction;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;


public class FractionTest {

	@Test
	public void fourTwentiethsItsReducingToOneFifth() {
		assertThat(new Fraction(4, 20), equalTo(new Fraction(1, 5)));
	}
	
	@Test
	public void sevenFifteenthsItIsNotReducible() {
		assertThat(new Fraction(7, 15), equalTo(new Fraction(7, 15)));
	}
	
	@Test
	public void aSingleIntegerHasAnInplicitDenominator() {
		assertThat(new Fraction(7), equalTo(new Fraction(7, 1)));
	}
	
	@Test
	public void aNegativeNumeratorAndANegativeDenominatorIsEqualToPositiveFraction() {
		assertThat(new Fraction(-5, -2), equalTo(new Fraction(5, 2)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void aFractionCannotHaveZeroDenominator() {
		new Fraction(5, 0);
	}
	
	@Test
	public void twoThirdsPlusFourFifthsIsTwentyTwoFifteenths() {
		assertThat(new Fraction(2, 3).add(new Fraction(4, 5)), equalTo(new Fraction(22, 15)));
	}
	
	@Test
	public void minusFourNinthsPlusSevenHalfIsFiftyFiveEighteenths() {
		assertThat(new Fraction(-4, 9).add(new Fraction(7, 2)), equalTo(new Fraction(55, 18)));
	}
	
	@Test
	public void fiveFourthsMinusSevenSixthsIsOneTwelfths() {
		assertThat(new Fraction(5, 4).substract(new Fraction(7, 6)), equalTo(new Fraction(1, 12))); 
	}
}
