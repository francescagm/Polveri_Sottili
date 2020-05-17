package it.unibs.fp.polveri_esercitazione;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;

public class Polveri_Main {

	public static void main(String[] args) {
		
		
		
		
	
			  WeekFields settimana = WeekFields.of(DayOfWeek.MONDAY,1); 
			  TemporalField settimaDelAnno = settimana.weekOfYear(); 
			  LocalDate giorno = LocalDate.of(2020,5, 15); //data diinzio miurazioni 
			  int numSettimanaAnnoPerGiorno =   giorno.get(settimaDelAnno); 
			  DayOfWeek  giornoDellaSettimana =  giorno.getDayOfWeek();
			  int numeroGiornoDellaSettimana =  giorno.getDayOfWeek().getValue();
			   System.out.println(giorno);
			   System.out.println(numSettimanaAnnoPerGiorno);
			
		// TODO Auto-generated method stub

	}

}
