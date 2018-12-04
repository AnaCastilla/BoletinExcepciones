package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ejercicios.ej05;

class ej05Test {

	@Test
	void perfectoTest() {
		assertTrue(ej05.perfecto(6));
		assertFalse(ej05.perfecto(5));
	}

}
