package it.unibs.fp.polveri_esercizio;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;

import util.mylib.*;

public class Giorno implements ControlloAmbientale {
	
	private  int campione;
	private String miusraSI = "µg/m³";
	private String PM10 = campione + miusraSI;
	private int giorno; //
    private int giorno_settimana;// nome giorno e o numero 
	private int  num_Settimana_Anno;  //leggi numero settimana anno 
	
	
	//costuttore uno
	public Giorno(int _campione, int _giorno) {
		
		this.campione = _campione;
		this.giorno = _giorno;
		this.giorno_settimana =giorno_settimana;
		this.num_Settimana_Anno= num_Settimana_Anno;
		this.miusraSI="µg/m³";
		this.PM10= campione+ miusraSI;
	}


   @Override
	public String toString() {
		return "Giorno [campione=" + campione + ", miusraSI=" + miusraSI + ", PM10=" + PM10 + ", giorno=" + giorno
				+ ", giorno_settimana=" + giorno_settimana + ", num_Settimana_Anno=" + num_Settimana_Anno + "]";
	}


	// ocstruttore due 
	public Giorno(String pM10, int giorno_settimana) {
		
		PM10 = pM10;
		this.giorno_settimana = giorno_settimana;
	}
	
	// metodo rilevazione giorno da cui si parte con le rivlevazioni settimanali vedo se lasciarlo cosi oppure fare settimana e basta 
	
	public void  rileva() {
	char  giornoInizio  = InputDati.leggiChar("inserisci data inziorilevazioni");
	LocalDate giornoInzio = LocalDate.of(2020,5, 15);
	// iserire dun giorno da una data che ritorna poi settimana dell anno e legge data ;
	
	}
	


	public int getCampione() {
		return campione;
	}


	public void setCampione(int campione) {
		this.campione = campione;
	}


	public String getPM10() {
		return PM10;
	}


	public void setPM10(String pM10) {
		PM10 = pM10;
	}


	public int getGiorno() {
		return giorno;
	}


	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}


	public int getGiorno_settimana() {
		return giorno_settimana;
	}


	public void setGiorno_settimana(int giorno_settimana) {
		this.giorno_settimana = giorno_settimana;
	}


	public int getNum_Settimana_Anno() {
		return num_Settimana_Anno;
	}


	public void setNum_Settimana_Anno(int num_Settimana_Anno) {
		this.num_Settimana_Anno = num_Settimana_Anno;
	}


	public static Giorno newIstance(Giorno giorno, int campione) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean allarmeMedio() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean allarmePicco() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int picco() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int campioneMedio() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void campionamento() {
		// TODO Auto-generated method stub
		
	}


	
	
	
	
	
	
	
    
}
