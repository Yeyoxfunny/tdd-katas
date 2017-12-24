package com.sergio.kata.stringcalculator;

import java.util.Arrays;

public class StringCalculator {

	public static int sumar(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		return Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).sum();
	}

}
