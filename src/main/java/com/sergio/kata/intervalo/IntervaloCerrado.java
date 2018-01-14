package com.sergio.kata.intervalo;

import java.util.Objects;

public class IntervaloCerrado {

	private int min;
	private int max;

	public IntervaloCerrado(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("min no debe ser superior a max");
		}
		this.min = min;
		this.max = max;
	}

	public boolean incluye(int numero) {
		return numero >= this.min && numero <= this.max;
	}

	public boolean incluye(IntervaloCerrado intervalo) {
		Objects.requireNonNull(intervalo);
		return this.incluye(intervalo.min) && this.incluye(intervalo.max);
	}

	public boolean intersectando(IntervaloCerrado intervalo) {
		Objects.requireNonNull(intervalo);
		return this.incluye(intervalo.min) || this.incluye(intervalo.max) || intervalo.incluye(this);
	}

	public IntervaloCerrado union(IntervaloCerrado intervalo) {
		Objects.requireNonNull(intervalo);
		return new IntervaloCerrado(Math.min(this.min, intervalo.min), Math.max(this.max, intervalo.max));
	}

	public IntervaloCerrado interseccion(IntervaloCerrado intervalo) {
		Objects.requireNonNull(intervalo);
		if (!this.intersectando(intervalo)) {
			throw new IllegalArgumentException("Los intervalos no se están intersectando");
		}
		return new IntervaloCerrado(Math.max(this.min, intervalo.min), Math.min(this.max, intervalo.max));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + max;
		result = prime * result + min;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntervaloCerrado other = (IntervaloCerrado) obj;
		if (max != other.max)
			return false;
		if (min != other.min)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[min=" + min + ", max=" + max + "]";
	}

}
