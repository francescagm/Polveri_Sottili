package polveri;

public class Settimana {

	private static final String MEDIA_TRA_CAMPIONI = "La media dei campioni settimanale e' stata di ";
	private static final String WARNING_SUPERATA_SOGLIA_MEDIA = "\n WARNING! superata la soglia di sicurezza media per la settimana (";
	private static final String IMPOSSIBILE_COSTRUIRE_SETTIMANA = "impossibile costruire una settimana con giorni diversi da 7";
	private static final String PICCO_TRA_CAMPIONI = "\nIl picco tra i campioni della settimana e' stato ";
	private static final String WARNING_SUPERATA_SOGLIA_MASSIMA = "\n WARNING! superata la soglia di sicurezza massima per la settimana (";

	public static final int GIORNI_SETTIMANA = Giorno.values().length;
	private static final int WARNING_MEDIA = 50;
	private static final int WARNING_PICCO = 75;

	private Giorno giornoPicco;
	private int media_settimana;
	private int picco_Settimana;
	private Integer[] campioni;

	public Settimana(Integer[] settimanaInserire) {
		if (settimanaInserire.length != GIORNI_SETTIMANA)
			throw new IllegalArgumentException(IMPOSSIBILE_COSTRUIRE_SETTIMANA);
		campioni = settimanaInserire;
		setMedia_Settimana();
		setPicco_settimana();

	}

	public void setMedia_Settimana() {
		int totaleCampioniSettimanali = 0;

		for (int i = 0; i < campioni.length; i++) {
			totaleCampioniSettimanali += campioni[i];
		}
		media_settimana = Math.round(totaleCampioniSettimanali / GIORNI_SETTIMANA);
	}

	public int getMedia_settimana() {
		return media_settimana;
	}

	public int getPicco_Settimana() {
		return picco_Settimana;
	}

	public void setPicco_settimana() {
		int massimo = campioni[0];
		int nGiorno=0;
		for (int i = 1; i < campioni.length; i++) {
			if (campioni[i] > massimo) {
				massimo = campioni[i];
				nGiorno= i;
			}
		}
		giornoPicco=Giorno.values()[nGiorno];
		picco_Settimana = massimo;
	}

	public boolean allarmeMedio() {
		return (media_settimana >= WARNING_MEDIA);

	}

	public boolean allarmePicco() {
		return (picco_Settimana >= WARNING_PICCO);

	}

	@Override
	public String toString() {
		StringBuilder fine = new StringBuilder();
		fine.append(MEDIA_TRA_CAMPIONI + getMedia_settimana() + Manager.miusraSI);
		if (allarmeMedio())
			fine.append(WARNING_SUPERATA_SOGLIA_MEDIA + WARNING_MEDIA + ")");
		fine.append(PICCO_TRA_CAMPIONI + giornoPicco.toString() + " con " + getPicco_Settimana() + Manager.miusraSI);
		if (allarmePicco())
			fine.append(WARNING_SUPERATA_SOGLIA_MASSIMA + WARNING_PICCO + ")");
		return fine.toString();
	}

}
