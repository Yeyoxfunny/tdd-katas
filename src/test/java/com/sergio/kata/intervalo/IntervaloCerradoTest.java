package com.sergio.kata.intervalo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IntervaloCerradoTest {

	@Parameter(0)
	public int min;
	@Parameter(1)
	public int max;

	@Parameter(2)
	public int numero;
	@Parameter(3)
	public IntervaloCerrado intervaloTest;

	@Parameter(4)
	public boolean expectedIncluyeValor;
	@Parameter(5)
	public boolean expectedIncluyeIntervalo;
	@Parameter(6)
	public boolean expectedIntersectando;

	@Parameter(7)
	public IntervaloCerrado expectedUnion;

	@Parameter(8)
	public IntervaloCerrado expectedInterseccion;

	@Parameters(name = "Min: {0}, Max: {1}, IntervaloTest: {3}, IncluyeValor({2}) = {4}")
	public static Collection<Object[]> data() {
		List<Object[]> items = new ArrayList<>();
		items.add(new Object[] { -2, 4, 0, new IntervaloCerrado(2, 5), true, false, true, new IntervaloCerrado(-2, 5),
				new IntervaloCerrado(2, 4) });
		items.add(new Object[] { -5, 7, -10, new IntervaloCerrado(-8, 4), false, false, true,
				new IntervaloCerrado(-8, 7), new IntervaloCerrado(-5, 4) });
		items.add(new Object[] { -10, 12, 6, new IntervaloCerrado(0, 9), true, true, true,
				new IntervaloCerrado(-10, 12), new IntervaloCerrado(0, 9) });
		return items;
	}

	private IntervaloCerrado intervalo;

	@Before
	public void before() {
		intervalo = new IntervaloCerrado(min, max);
	}

	@Test
	public void testIncluyeValor() {
		assertEquals(expectedIncluyeValor, intervalo.incluye(numero));
	}

	@Test
	public void testIncluyeIntervalo() {
		assertEquals(expectedIncluyeIntervalo, intervalo.incluye(intervaloTest));
	}

	@Test
	public void testIntersectando() {
		assertEquals(expectedIntersectando, intervalo.intersectando(intervaloTest));
	}

	@Test
	public void testUnion() {
		assertEquals(expectedUnion, intervalo.union(intervaloTest));
	}

	@Test
	public void testInterseccion() {
		assertEquals(expectedInterseccion, intervalo.interseccion(intervaloTest));
	}
}
