package com.sergio.kata.frases;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void anEmptyStringIsPalindrome() {
		assertThat(Word.isPalindrome(""), is(true));
	}

	@Test
	public void aSingleLetterStringIsPalindrome() {
		assertThat(Word.isPalindrome("a"), is(true));
	}

	@Test
	public void abIsNotPalindrome() {
		assertThat(Word.isPalindrome("ab"), is(false));
	}

	@Test
	public void radarIsPalindrome() {
		assertThat(Word.isPalindrome("radar"), is(true));
	}

	@Test
	public void notAllWordsThatStartAndEndWithSameCharacterArePalindrome() {
		assertThat(Word.isPalindrome("reader"), is(false));
	}

	@Test
	public void palindromeCheckingIsCaseInsensitive() {
		assertThat(Word.isPalindrome("Anna"), is(true));
	}

	@Test
	public void wordWithSpacesIsPalindrome() {
		assertThat(Word.isPalindrome("A Santa at NASA"), is(true));
	}

	@Test
	public void palindromeCheckingIgnoreNoneLetters() {
		assertThat(Word.isPalindrome(
				"Are we not pure? “No sir!” Panama’s moody Noriega brags. “It is garbage!” Irony dooms a man; a prisoner up to new era."),
				is(true));
	}

}
