package it.unibs.fp.polveri_esercitazione;
import java.sql.Time;
import java.time.DayOfWeek; 
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField; 
import java.time.temporal.WeekFields; 



public class Settimana {
	
	
	 private static DayOfWeek giornata;
	 private static  int campione;
	 private TemporalField settimaDelMese;
	 private TemporalField settimaDelAnno;
	 private Misurazioni [] campioniSettimana;
	
	 
	 public Settimana(Misurazioni[] campioniSettimana) {
	    
		this.campioniSettimana = campioniSettimana;
	} 
	
	

}
