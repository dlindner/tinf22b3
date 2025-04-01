package de.dhbw.tinf22b3.testing.mock;

import java.io.IOException;
import java.util.Map;

public class LadeBenutzer {

	private final Dokumentendatenbank datenbank;

	public LadeBenutzer(Dokumentendatenbank datenbank) {
		super();
		this.datenbank = datenbank;
	}
	
	public Benutzer für(final String login) throws IOException {
		final Map<String, String> eintrag = datenbank.eintragFür(login);
		final String vorname = eintrag.getOrDefault("vorname", "");
		final String nachname = eintrag.getOrDefault("nachname", "");
		final String rollenname = eintrag.getOrDefault("rolle", Rolle.Normal.name());
		final Rolle rolle = Rolle.valueOf(rollenname);
		return new Benutzer() {
			@Override
			public String vorname() {
				return vorname;
			}
			
			@Override
			public String nachname() {
				return nachname;
			}
			
			@Override
			public String login() {
				return login;
			}
			
			@Override
			public Rolle rolle() {
				return rolle;
			}
		};
	}
}
