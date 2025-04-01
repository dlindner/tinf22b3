package de.dhbw.tinf22b3.testing.mock;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class LadeBenutzerTest {

	@Test
	public void lädt_einen_Administrator() throws IOException {
		// Arrange
		Dokumentendatenbank given = Mockito.mock(Dokumentendatenbank.class);
		Mockito.when(
			given.eintragFür("admin")
		).thenReturn(
			Map.of(
				"rolle", "Administrator"	
			)
		);
		LadeBenutzer target = new LadeBenutzer(given);
		
		// Act
		Benutzer actual = target.für("admin");
		
		// Assert
		Assertions.assertEquals(Rolle.Administrator, actual.rolle());
		Assertions.assertEquals("admin", actual.login());
	}
	
	@Test
	public void lädt_Vorname_und_Nachname() throws IOException {
		// Arrange
		Dokumentendatenbank given = Mockito.mock(Dokumentendatenbank.class);
		Mockito.when(
			given.eintragFür("felix")
		).thenReturn(
			Map.of(
				"vorname", "Felix",
				"nachname", "Dittmann"	
			)
		);
		LadeBenutzer target = new LadeBenutzer(given);
		
		// Act
		Benutzer actual = target.für("felix");
		
		// Assert
		Assertions.assertEquals(Rolle.Normal, actual.rolle());
		Assertions.assertEquals("Felix", actual.vorname());
		Assertions.assertEquals("Dittmann", actual.nachname());
	}
	
	@Test(expected = IOException.class)
	public void Datenbank_nicht_erreichbar() throws IOException {
		// Arrange
		Dokumentendatenbank given = Mockito.mock(Dokumentendatenbank.class);
		Mockito.when(
			given.eintragFür(anyString())
		).thenThrow(
			IOException.class
		);
		LadeBenutzer target = new LadeBenutzer(given);
		
		// Act
		target.für("admin");
		
		// Assert
//		Assertions.assertEquals(Rolle.Administrator, actual.rolle());
//		Assertions.assertEquals("admin", actual.login());
	}
}
