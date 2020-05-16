package it.unibs.fp.polveri_esercitazione_1;

import java.time.DayOfWeek;
import java.time.temporal.WeekFields;



public class Settimana implements Misurazioni  {

	private static Giorno[]settimana;
    private static int NUM_GIORNI = WeekFields.of(DayOfWeek.MONDAY,7).getMinimalDaysInFirstWeek();
	private static int DISPONIBILE =-1;
	private static int []campioneSettimana;
	
	public Settimana() {
	
		settimana = new Giorno[NUM_GIORNI];
		
	}
	
	
	
//	public int  unaSettimana (Giorno giorno ) {
//		int posizione = DISPONIBILE;
//		for ( int i = 0; i <NUM_GIORNI ; i++ ) { 
//			if ( settimana[i] == null ) { 
//				settimana[i] = giorno;
//				posizione = i;
//				i = NUM_GIORNI;
//				}
//		}
//			return posizione;
			
//	}
	
//	private static void  campionamentoSettimanale() {
//	    int durataStandard = WeekFields.of(DayOfWeek.MONDAY,7).getMinimalDaysInFirstWeek();	
//		WeekFields risultatiGiorno = Giorno.getGiorno();
//	    for (int i = 0; i <durataStandard; i++) {
//		settimana[i]=
//		 
//		 }
	
	public void allarmePicco() {}
	public void allarmeMedio() {}
	
	public void campionamento() {
    int durataStandard = WeekFields.of(DayOfWeek.MONDAY,7).getMinimalDaysInFirstWeek();	
	Giorno unGiorno =null;	
	int[]campioneSettimana = new int [durataStandard];
	for (int i = 0; i <durataStandard; i++) {
    campioneSettimana[i]=unGiorno.getCampione();
    // mi serve per fare i conti delgi allarmi  
    //valori interi presenti in una settimana sono scema lo potevo andare a prendere dall arrai settimana .... eh se sei cretina adesso vado adormire 
     //settimana[i]=Giorno.newIstance(Giorno.getGiorno(),Giorno.getCampione());
	}
			 		
		
	}
    public void capionamentoMedio() {
    int campioneMedio =0;
    int []campioneSettimana = null;
    Giorno unGiorno =null;
    for (int j = 0; j < settimana.length; j++) {
    	 campioneSettimana[j]= 
    	 media +=campioneSettimana[i]; 
         media/settimana.settimana.length;
     } 
	   	 campioneMedio= media/settimana.settimana.length;

//	   	public int valoreMassimo()
//	    {
//	  	  int massimo = misure[0];
//	  	  for (int i=1; i < misure.length; i++)
//	  	  {
//	  		  if (misure[i] > massimo)
//	  			  massimo =misure[i]; 
//	  	  }
//	  	  
//	  	  return massimo; 
	   	
   



	public static Giorno[] getSettimana() {
		return settimana;
	}



	public static void setSettimana(Giorno[] settimana) {
		Settimana.settimana = settimana;
	}



	@Override
	public String toString() {
		
		
		return "Settimana []";
	}
	
}

	
	
	
	

