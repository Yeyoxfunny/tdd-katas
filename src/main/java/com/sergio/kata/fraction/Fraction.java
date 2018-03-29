package com.sergio.kata.fraction;

import java.util.Objects;

public class Fraction {
	
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator) {
		this(numerator, 1);
	}
	
	public Fraction(int numerator, int denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException();
		}
		int mcd = mcd(numerator, denominator);
		this.numerator = numerator / mcd;
		this.denominator = denominator / mcd;
	}
	
	public Fraction add(Fraction fraction) {
		int mcm = mcm(this.denominator, fraction.denominator);
		int a = (mcm / this.denominator) * this.numerator;
		int b = (mcm / fraction.denominator) * fraction.numerator;
		return new Fraction(a + b, mcm);
	}
	
	public Fraction substract(Fraction fraction) {
		int mcm = mcm(this.denominator, fraction.denominator);
		int a = (mcm / this.denominator) * this.numerator;
		int b = (mcm / fraction.denominator) * fraction.numerator;
		return new Fraction(a - b, mcm);
	}

	private static int mcd(int a, int b) {
		return b == 0 ? a : mcd(b, a % b);
	}
	
	private static int mcm(int a, int b) {
		return (a * b) / mcd(a, b);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numerator, denominator);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if (denominator != other.denominator)
			return false;
		if (numerator != other.numerator)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	
}
