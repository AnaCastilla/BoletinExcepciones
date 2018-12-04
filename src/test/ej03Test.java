package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ejercicios.ej03;

class ej03Test {

	@Test
	void esPrimoTest() {
		assertTrue(ej03.esPrimo(5));
		assertFalse(ej03.esPrimo(6));
	}

}
