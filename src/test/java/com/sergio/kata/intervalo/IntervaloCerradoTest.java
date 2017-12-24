package com.sergio.kata.intervalo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IntervaloCerradoTest {

	@Test
	public void intervalo2Y8IncluyeElNumero3() {
		// Arrange
		IntervaloCerrado intervalo = new IntervaloCerrado(2, 8);
		// Assert
		assertTrue(intervalo.incluye(3));
	}

	@Test
	public void intervaloMenos3YUnoNoIncluyeElNumeroMenosCuatro() {
		// Arrange
		IntervaloCerrado intervalo = new IntervaloCerrado(-3, 1);
		// Assert
		assertFalse(intervalo.incluye(-4));
	}

	@Test
	public void intervalo4Y12IncluyeIntervalo5Y9() {
		// Arrange
		IntervaloCerrado intervalo1 = new IntervaloCerrado(4, 12);
		IntervaloCerrado intervalo2 = new IntervaloCerrado(5, 9);
		// Act
		assertTrue(intervalo1.incluye(intervalo2));
	}

	@Test
	public void intervaloMenos1Y3NoIncluyeIntervaloMenos3Y1() {
		// Arrange
		IntervaloCerrado intervalo1 = new IntervaloCerrado(-1, 3);
		IntervaloCerrado intervalo2 = new IntervaloCerrado(-3, 1);

		// Assert
		assertFalse(intervalo1.incluye(intervalo2));
	}

	@Test
	public void intervaloMenos2Y6EstaIntersectandoConIntervalo5Y10() {
		// Arrange
		IntervaloCerrado intervalo1 = new IntervaloCerrado(2, 6);
		IntervaloCerrado intervalo2 = new IntervaloCerrado(5, 10);

		// Assert
		assertTrue(intervalo1.intersectando(intervalo2));
	}

	@Test
	public void intervaloMenos3Y3EstaIntersectandoConIntervaloMenos5YUno() {
		// Arrange
		IntervaloCerrado intervalo1 = new IntervaloCerrado(-3, 3);
		IntervaloCerrado intervalo2 = new IntervaloCerrado(-5, 1);

		// Assert
		assertTrue(intervalo1.intersectando(intervalo2));
	}

	@Test
	public void intervalo0Y3EstaIntersectandoConIntervaloMenos1Y7() {
		// Arrange
		IntervaloCerrado intervalo1 = new IntervaloCerrado(0, 3);
		IntervaloCerrado intervalo2 = new IntervaloCerrado(-1, 7);

		// Assert
		assertTrue(intervalo1.intersectando(intervalo2));
	}

	@Test
	public void intervalo3Y7UnionIntervaloMenos2Y4RetornaIntervaloMenos2Y7() {
		// Arrange
		IntervaloCerrado intervalo1 = new IntervaloCerrado(3, 7);
		IntervaloCerrado intervalo2 = new IntervaloCerrado(-2, 4);

		// Act
		IntervaloCerrado actual = intervalo1.union(intervalo2);
		IntervaloCerrado esperado = new IntervaloCerrado(-2, 7);

		// Assert
		assertEquals(esperado, actual);
	}

	@Test
	public void intervaloMenos2YCuatroInterseccion2Y5RetornaIntervalo2Y4() {
		// Arrange
		IntervaloCerrado intervalo1 = new IntervaloCerrado(-2, 4);
		IntervaloCerrado intervalo2 = new IntervaloCerrado(2, 5);

		// Act
		IntervaloCerrado actual = intervalo1.interseccion(intervalo2);
		IntervaloCerrado esperado = new IntervaloCerrado(2, 4);

		// Assert
		assertEquals(esperado, actual);
	}
}
