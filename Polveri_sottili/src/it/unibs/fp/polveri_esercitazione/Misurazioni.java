package it.unibs.fp.polveri_esercitazione;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.temporal.WeekFields;

public interface  Misurazioni {

	
	
	class SigoloCampione implements Misurazioni
	{
		
		private int campione;
		private String miusraSI = "µg/m³";
		private String PM10 = campione + miusraSI;
	    private static int perGiorno;
	    
	    public SigoloCampione(int campione,int perGiorno) {
			super();
			this.campione = campione;
			this.perGiorno= perGiorno;
					
	    }

		@Override
		public String toString() {
			return "SigoloCampione [perGiorno=" + perGiorno + ",PM10=" + PM10 + "]";
		}	
	    
					
			
		}

		
	    
		
	}
	
	

