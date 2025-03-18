package de.dhbw.tinf22b3.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BerechnungTest {

	@Test
	@DisplayName("erster Kontakt")
	void erster_Kontakt() {
		// Arrange
		Berechnung target = new Berechnung();
		int given_num1 = 42;
		int given_num2 = 1;
		
		// Act
		int actual = target.für(given_num1, given_num2);
		
		// Assert
		int expected = 42;
		assertEquals(expected, actual);
	}
	
	@Test
	void zweiter_Kontakt() {
		// Arrange
		Berechnung target = new Berechnung();
		int given_num1 = 42;
		int given_num2 = 2;
		
		// Act
		int actual = target.für(given_num1, given_num2);
		
		// Assert
		int expected = 84;
		assertEquals(expected, actual);
	}

	@Test
	void negative_Zahlen() {
		// Arrange
		Berechnung target = new Berechnung();
		int given_num1 = 42;
		int given_num2 = -2;
		
		// Act
		int actual = target.für(given_num1, given_num2);
		
		// Assert
		int expected = -84;
		assertEquals(expected, actual);
	}
	
	@Test
	void vertauscht() {
		// Arrange
		Berechnung target = new Berechnung();
		int given_num1 = 1;
		int given_num2 = 42;
		
		// Act
		int actual = target.für(given_num1, given_num2);
		
		// Assert
		int expected = 42;
		assertEquals(expected, actual);
	}
	
	@Test
	void vertauschte_negative_Zahlen() {
		// Arrange
		Berechnung target = new Berechnung();
		int given_num1 = -42;
		int given_num2 = 2;
		
		// Act
		int actual = target.für(given_num1, given_num2);
		
		// Assert
		int expected = -84;
		assertEquals(expected, actual);
	}
	
	@Test
	void ein_Wert_ist_0() {
		// Arrange
		Berechnung target = new Berechnung();
		int given_num1 = 0;
		int given_num2 = 42;
		
		// Act
		int actual = target.für(given_num1, given_num2);
		
		// Assert
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	@Test
	void beide_Zahlen_negativ() {
		// Arrange
		Berechnung target = new Berechnung();
		int given_num1 = -42;
		int given_num2 = -2;
		
		// Act
		int actual = target.für(given_num1, given_num2);
		
		// Assert
		int expected = +84;
		assertEquals(expected, actual);
	}

	@Test
	void eingedampfte_Syntax() {
		Berechnung target = new Berechnung();
		int actual = target.für(-42, -2);
		assertEquals(+84, actual);
	}
}
