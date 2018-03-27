package com.sergio.kata.frases;

import java.util.Objects;

public class Word {

	private static final String ALL_NONE_ALPHABETIC_CHARACTERS = "[^a-zA-Z]";

	public static boolean isPalindrome(String phrase) {
		Objects.requireNonNull(phrase);
		if (phrase.isEmpty() || phrase.length() == 1) {
			return true;
		}
		return checkIfIsPalindrome(phrase);
	}

	private static boolean checkIfIsPalindrome(String phrase) {
		String word = phrase.replaceAll(ALL_NONE_ALPHABETIC_CHARACTERS, "");
		boolean isPalindrome = true;
		int length = word.length();
		for (int i = 0, size = length / 2; i < size && isPalindrome; i++) {
			isPalindrome = equalsIgnoreCase(word.charAt(i), word.charAt(length - 1 - i));
		}
		return isPalindrome;
	}

	private static boolean equalsIgnoreCase(char a, char b) {
		return Character.toLowerCase(a) == Character.toLowerCase(b);
	}

}
