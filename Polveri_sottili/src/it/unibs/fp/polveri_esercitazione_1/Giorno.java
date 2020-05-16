package it.unibs.fp.polveri_esercitazione_1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;

public class Giorno {
	
	//private static  DayOfWeek giorno;
	private int campione;
	private String miusraSI = "µg/m³";
	private String PM10 = campione + miusraSI;
	private static WeekFields giorno = WeekFields.of(DayOfWeek.MONDAY,7);
    
	public Giorno (WeekFields _giorno, int _campione) {
    	
    	this.giorno = _giorno;
    	this.campione =_campione;
    	this.PM10= campione + miusraSI;
    			
    }

	public static WeekFields getGiorno() {
		return giorno;
	}

	public static void setGiorno(WeekFields giorno) {
		Giorno.giorno = giorno;
	}

	public int getCampione() {
		return campione;
	}

	public void setCampione(int campione) {
		this.campione = campione;
	}

	@Override
	public String toString() {
		return "Giorno [giorno =" + giorno + ",  PM10=" + PM10 + "]";
	}

	
}
