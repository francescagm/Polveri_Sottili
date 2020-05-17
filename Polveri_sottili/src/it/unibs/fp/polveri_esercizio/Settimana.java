package it.unibs.fp.polveri_esercizio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class Settimana implements ControlloAmbientale {
	private ArrayList<Giorno>settimana = new ArrayList<>();
	private static final int  SETTIMANA_STANDARD = WeekFields.of(DayOfWeek.MONDAY,7).getMinimalDaysInFirstWeek();
	private static final int WARNING_MEDIA = 50;
	private static final int WARNING_PICCO = 75;
	private static final int ANNO_MINIMO = 1950;
	private static final String RICHIESTA_NUM_SETTIMANA = "inserisci il numero della settimana nel anno" ;
	private static final int MAX_SETTIMANE = 53;
	private static final String RICHIESTA_ANNO = "insrisci anno riferimento";
	private int NUM_SETTIMANA_ANNO;
	private ArrayList<Integer> unaSettimana;
	private int media_settimana;
	private int picco_Settimana;
	
	public Settimana() {

	
	settimana = new ArrayList<>(SETTIMANA_STANDARD);
		
	}
	
	
	public void campionamento() {
	ArrayList<Integer> unaSettimana = new ArrayList<>();
	for (int i = 0; i < settimana.size(); i++) {
	unaSettimana.add(settimana.get(i).getCampione());
    }
	}
	public void  rileva()
	{
		  WeekFields setSettimanaStandard = WeekFields.of(DayOfWeek.MONDAY,1); 
		  TemporalField settimaDelAnno = setSettimanaStandard.weekOfYear(); 
		  LocalDate dataInput = LocalDate.of(2020,5, 15); //data diinzio miurazioni 
		  int numSettimanaAnnoPerGiorno =  dataInput.get(settimaDelAnno); 
		  //DayOfWeek  giornoDellaSettimana =dataInput .getDayOfWeek();
		  //int numeroGiornoDellaSettimana = dataInput.getDayOfWeek().getValue();
		  
		//int anno = InputDati.leggiInteroConMinimo(RICHIESTA_ANNO, ANNO_MINIMO);
		//int numeroSettimana = InputDati.leggiIntero(RICHIESTA_NUM_SETTIMANA,1,MAX_SETTIMANE);
	    // qui io vorrei creare un inputo con leggi data ...e dalla data indentificare numero settimana e tutto il resto ma per ora faccio cosi 
		for (int i = 0; i <settimana.size(); i++)
			 {
		    Giorno giorno = null;
		    int campione = 0;
			settimana.add(Giorno.newIstance(giorno, campione));
			 }
		
		 }
		
	
	
	
	public int campioneMedio() {
	int totaleCampioniSettimanali =0;
	
	for (int i = 0; i <unaSettimana.size(); i++) {
		totaleCampioniSettimanali+= unaSettimana.get(i);
	}
	 return media_settimana =totaleCampioniSettimanali/SETTIMANA_STANDARD;// qui devo mettere fuzione mat per approssimare all intero piu grande 
	}
	
	public int picco() {
		//oridina ArrayList<Integer> unaSettimana dal piu grande al piu piccolo e prendi il primo della lista ...oppure 
		picco_Settimana =0;
		for (int i = 0; i <unaSettimana.size(); i++) {
			if (picco_Settimana<=unaSettimana.get(i))
			 	picco_Settimana =unaSettimana.get(i);
			
		}
		return 	picco_Settimana;
		
	}
	public boolean allarmeMedio() {
	    if(picco_Settimana>= WARNING_MEDIA)
		return true;
		return false;
	}
	public boolean allarmePicco() {
		if(picco_Settimana>=WARNING_PICCO)
		return true;
		return false;
	}


	@Override
	public String toString() {// da sitemate benene 
		return "Settimana [settimana=" + settimana + ", NUM_SETTIMANA_ANNO=" + NUM_SETTIMANA_ANNO + ", unaSettimana="
				+ unaSettimana + ", media_settimana=" + media_settimana + ", picco_Settimana=" + picco_Settimana
				+ ", campioneMedio()=" + campioneMedio() + ", picco()=" + picco() + ", allarmeMedio()=" + allarmeMedio()
				+ ", allarmePicco()=" + allarmePicco() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
