package com.sergio.kata.stringcalculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class StringCalculator {

	private static final String DEFAULT_DELIMITADOR = ",|\n";
	private String numeros;
	private String delimitadores;

	private StringCalculator(String numeros) {
		this(numeros, DEFAULT_DELIMITADOR);
	}

	private StringCalculator(String numeros, String delimitadores) {
		this.numeros = numeros;
		this.delimitadores = delimitadores;
	}

	public static int sumar(String input) {
		Objects.requireNonNull(input);
		if (input.isEmpty()) {
			return 0;
		}

		StringCalculator calculator = soportaDiferentesDelimitadores(input) ? cambiarDelimitador(input)
				: new StringCalculator(input);
		return sumar(calculator);
	}

	private static boolean soportaDiferentesDelimitadores(String input) {
		return input.startsWith("//");
	}

	private static StringCalculator cambiarDelimitador(String input) {
		String[] line = input.split("\n", 2);
		String delimitador = Pattern.quote(line[0].substring(2));
		return new StringCalculator(line[1], delimitador);
	}

	private static int sumar(StringCalculator calculator) {
		return Arrays.stream(calculator.numeros.split(calculator.delimitadores)).mapToInt(Integer::parseInt).sum();
	}

}
