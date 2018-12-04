package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ejercicios.ej01;

class ej01Test {

	@Test
	void operationTest() {
		assertEquals(ej01.operation(4, 2, "+"), 6);
		assertEquals(ej01.operation(-4, -2, "+"), -6);
		assertEquals(ej01.operation(-4, 2, "+"), -2);
		assertEquals(ej01.operation(4, -2, "+"), 2);
		assertEquals(ej01.operation(0, 2, "+"), 2);
		assertEquals(ej01.operation(4, 0, "+"), 4);
		assertEquals(ej01.operation(4.5, 2.5, "+"), 7);
		
		assertEquals(ej01.operation(4, 2, "-"), 2);
		assertEquals(ej01.operation(-4, -2, "-"), -2);
		assertEquals(ej01.operation(-4, 2, "-"), -6);
		assertEquals(ej01.operation(4, -2, "-"), 6);
		assertEquals(ej01.operation(0, 2, "-"), -2);
		assertEquals(ej01.operation(4, 0, "-"), 4);
		assertEquals(ej01.operation(4.5, 2.5, "-"), 2);
		
		assertEquals(ej01.operation(4, 2, "*"), 8);
		assertEquals(ej01.operation(-4, -2, "*"), 8);
		assertEquals(ej01.operation(-4, 2, "*"), -8);
		assertEquals(ej01.operation(4, -2, "*"), -8);
		assertEquals(ej01.operation(0, 2, "*"), 0);
		assertEquals(ej01.operation(4, 0, "*"), 0);
		assertEquals(ej01.operation(4.5, 2.5, "*"), 11.25);
		
		assertEquals(ej01.operation(4, 2, "/"), 2);
		assertEquals(ej01.operation(-4, 2, "/"), -2);
		assertEquals(ej01.operation(-4, -2, "/"), 2);
		assertEquals(ej01.operation(4, -2, "/"), -2);
		assertEquals(ej01.operation(0, 2, "/"), 0);
		//assertEquals(ej01.operation(4, 0, "/"), 0);
		assertEquals(ej01.operation(4.5, 2.5, "/"), 1.8);
		
	}

}
