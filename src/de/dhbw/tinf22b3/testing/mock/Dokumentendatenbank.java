package de.dhbw.tinf22b3.testing.mock;

import java.io.IOException;
import java.util.Map;

public interface Dokumentendatenbank {
	
	// Dictionary (key -> value)
	Map<String, String> eintragFür(String id) throws IOException;
	
	String andereMethode();
}
