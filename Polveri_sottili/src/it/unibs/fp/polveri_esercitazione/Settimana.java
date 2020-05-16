package it.unibs.fp.polveri_esercitazione;
import java.sql.Time;
import java.time.DayOfWeek; 
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField; 
import java.time.temporal.WeekFields;





public class Settimana {
	
	
	 private static  DayOfWeek giornata;
	 private static  int campione;
	 private static  WeekFields settimana;
	 private TemporalField settimaDelMese;
	 private TemporalField settimaDelAnno;
	 private static Misurazioni [] campioniSettimana;
	
	 
	 
	 public Settimana(LocalDate giornata,int _campione) {
		 this.giornata = giornata.getDayOfWeek();
		 this.campione = setCampione(campione);
	 }
	 
	 
	 public Settimana(Misurazioni[] campioniSettimana) {
	    
		this.campioniSettimana = campioniSettimana;
	} 
	
	 private static void  campionamentoSettimanale() {
	    int durataStandard = WeekFields.of(DayOfWeek.MONDAY,7).getMinimalDaysInFirstWeek();	
		 for (int i = 0; i <durataStandard; i++) {
			;
		 }
		 
		 
			 
		 }


	public static WeekFields getSettimana() {
		return settimana;
	}


	public static void setSettimana(WeekFields settimana) {
		Settimana.settimana = settimana;
	}


	public TemporalField getSettimaDelMese() {
		return settimaDelMese;
	}


	public void setSettimaDelMese(TemporalField settimaDelMese) {
		this.settimaDelMese = settimaDelMese;
	}


	public TemporalField getSettimaDelAnno() {
		return settimaDelAnno;
	}


	public void setSettimaDelAnno(TemporalField settimaDelAnno) {
		this.settimaDelAnno = settimaDelAnno;
	}


	public static Misurazioni[] getCampioniSettimana() {
		return campioniSettimana;
	}


	public static void setCampioniSettimana(Misurazioni[] campioniSettimana) {
		Settimana.campioniSettimana = campioniSettimana;
	}


	public static void setGiornata(DayOfWeek giornata) {
		Settimana.giornata = giornata;
	}


	public static int setCampione(int campione) {
		return Settimana.campione = campione;
	}


	public static DayOfWeek getGiornata() {
		return giornata;
	}


	public static int getCampione() {
		return campione;
	}
				
			}
				
