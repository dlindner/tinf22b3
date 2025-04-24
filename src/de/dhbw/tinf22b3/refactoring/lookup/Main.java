package de.dhbw.tinf22b3.refactoring.lookup;

import static org.mockito.ArgumentMatchers.anyBoolean;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		Weekday day = Weekday.THURSDAY;
		int numLetters = switch (day) {
		    case MONDAY, FRIDAY, SUNDAY -> 6;
		    case TUESDAY                -> 7;
		    case THURSDAY, SATURDAY     -> 8;
		    case WEDNESDAY              -> 9;
		};
		System.out.println(numLetters);
		
		Map<Weekday, Integer> lettersOfDay = new HashMap<Weekday, Integer>();
		lettersOfDay.put(Weekday.MONDAY, 6);
		lettersOfDay.put(Weekday.TUESDAY, 7);
		lettersOfDay.put(Weekday.WEDNESDAY, 9);
		lettersOfDay.put(Weekday.THURSDAY, 8);
		
		Integer anzahlBuchstaben = lettersOfDay.get(day);
		System.out.println(anzahlBuchstaben);
		
		Map<Weekday, Integer> lettersOfDay2 = Map.of(
			Weekday.MONDAY, 6,
			Weekday.TUESDAY, 7
		);
		
		Map<Weekday, Consumer<String>> verhalten = new HashMap<>();
		verhalten.put(Weekday.MONDAY, (name) -> {
	    	System.out.println("Ein schlimmer Tag für " + name);
		}); // Closure, Lambda-Ausdruck
		day = Weekday.MONDAY;
		verhalten.get(day).accept("Garfield");
		
	}
}
