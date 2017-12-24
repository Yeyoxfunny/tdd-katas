package com.sergio.kata.stringcalculator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void sumarVacioRetorna0() {
		assertThat(StringCalculator.sumar(""), is(0));
	}

	@Test
	public void sumarUnSoloNumeroRetornaASiMismo() {
		assertThat(StringCalculator.sumar("50"), is(50));
	}

	@Test
	public void sumarMultiplesNumerosSeparadorPorComa() {
		assertThat(StringCalculator.sumar("10,35,28"), is(73));
	}

}
