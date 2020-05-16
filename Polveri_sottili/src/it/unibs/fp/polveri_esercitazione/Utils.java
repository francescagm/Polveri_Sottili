package it.unibs.fp.polveri_esercitazione;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.time.temporal.WeekFields;

public class Utils {
	
	LocalDate DallAnno= LocalDate.of(1950,01, 01);
	
	
	 public static void numeroSettimana() {
	 // imposta settimana con lunedi come primo giorno 
	  WeekFields settimana = WeekFields.of(DayOfWeek.MONDAY,1); 
	 // imposta settimana del mese 
      TemporalField settimaDelMese = settimana.weekOfMonth(); 
    // imposta settimana anno  
      TemporalField settimaDelAnno = settimana.weekOfYear(); 
      // data di rifermento sul giorno 
	   LocalDate giorno = LocalDate.of(2020,5, 15); //data diinzio miurazioni 
	  // settimana del mese per giorno di riferimento su settimana
	  int numeroSettimanaMesePerGiorno = giorno.get(settimaDelMese); 
	  // settimana dell' anno per giorno di riferimento su settimana 
	  int numSettimanaAnnoPerGiorno =   giorno.get(settimaDelAnno); 
	  // giorno della settimana da enum 
	  DayOfWeek  giornoDellaSettimana =  giorno.getDayOfWeek();
	  // numero del giorno su enum gionrno 
	  int numeroGiornoDellaSettimana =  giorno.getDayOfWeek().getValue();
	 
	   
	    }
	
		
		 
	 
	 
	 
	
	public static void leggiData() {
    // LocalDate ld = LocalDate.parse("2012-01-1", DateTimeFormatter.ISO_WEEK_DATE);	
    CharSequence text = null ;
	LocalDate data = LocalDate.parse(text,DateTimeFormatter.ofPattern("dd-MMM-yy"));
     //String dataIta = data.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));	
    
	}

}
