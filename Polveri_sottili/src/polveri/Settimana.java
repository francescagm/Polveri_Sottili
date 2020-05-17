package polveri;

import java.util.ArrayList;

public class Settimana {

	// private ArrayList<Giorno>settimana = new ArrayList<>();
	public static final int GIORNI_SETTIMANA = Giorno.values().length;
	private static final int WARNING_MEDIA = 50;
	private static final int WARNING_PICCO = 75;
	
	private static final String RICHIESTA_NUM_SETTIMANA = "inserisci il numero della settimana nel anno";
	private static final int MAX_SETTIMANE = 53;
	private static final String RICHIESTA_ANNO = "insrisci anno riferimento";
	private int NUM_SETTIMANA_ANNO;
	private Giorno giorno_
	private int media_settimana;
	private int picco_Settimana;
	private Integer[] campioni;

	public Settimana(Integer[] settimanaInserire) {
		if (settimanaInserire.length != GIORNI_SETTIMANA)
			throw new IllegalArgumentException("impossibile costruire una settimana con giorni diversi da 7");
		campioni = settimanaInserire;
		setMedia_Settimana();
		setPicco_settimana();

		
	}

	public void setMedia_Settimana() {
		int totaleCampioniSettimanali = 0;

		for (int i = 0; i < campioni.length; i++) {
			totaleCampioniSettimanali += campioni[i];
		}
		media_settimana= Math.round(media_settimana = totaleCampioniSettimanali / GIORNI_SETTIMANA);
	}

	public int getMedia_settimana() {
		return media_settimana;
	}

	public int getPicco_Settimana() {
		return picco_Settimana;
	}

	public void setPicco_settimana() {
		int massimo = campioni[0];
		for (int i = 1; i < campioni.length; i++) {
			if(campioni[i]>massimo) {
			 massimo = campioni[i];
			 
			}
				
		}
		picco_Settimana = massimo;

	}

	public boolean allarmeMedio() {
		if (media_settimana >= WARNING_MEDIA)
			return true;
		return false;
	}

	public boolean allarmePicco() {
		if (picco_Settimana>= WARNING_PICCO)
			return true;
		return false;
	}

	@Override
	public String toString() {
		 StringBuilder fine =new StringBuilder();
		 fine.append("la media dei campioni settimanale e' stata : " +getMedia_settimana());
		 if(allarmeMedio())
			 fine.append("%n WARNING! superata la soglia di sicurezza media per la settimana "+WARNING_MEDIA);
		 fine.append("il picco tra i campioni della settimana e'sato il giorno"+)
	}

	
	
}

