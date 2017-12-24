package com.sergio.kata.stringcalculator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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

	@Test
	public void sumarNumerosDelimitadosPorNuevaLinea() {
		assertThat(StringCalculator.sumar("24\n3"), is(27));
	}

	@Test
	public void sumarNumerosDelimitadosPorComaONuevaLinea() {
		assertThat(StringCalculator.sumar("24,32\n15"), is(71));
	}

	@Test
	public void sumarNumerosEspecificandoDelimitador() {
		assertThat(StringCalculator.sumar("//;\n52;13"), is(65));
	}

	@Test
	public void sumarNumerosEspecificandoDelimitadorEspecial() {
		assertThat(StringCalculator.sumar("//.\n67.12"), is(79));
		assertThat(StringCalculator.sumar("//*\n13*8*2*5"), is(28));
		assertThat(StringCalculator.sumar("//?\n43?89?45"), is(177));
	}

}
