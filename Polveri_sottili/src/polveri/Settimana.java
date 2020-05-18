package polveri;

/**
 * {@linkplain Class} Classe che rappresenta una <b> Settimana </b>
 */

public class Settimana {
	/** {@value} */
	private static final String MEDIA_TRA_CAMPIONI = "\nLa media dei campioni settimanale e' stata di ";
	/** {@value} */
	private static final String WARNING_SUPERATA_SOGLIA_MEDIA = "\n WARNING! superata la soglia di sicurezza media per la settimana (";
	/** {@value} */
	private static final String IMPOSSIBILE_COSTRUIRE_SETTIMANA = "Impossibile costruire una settimana con giorni diversi da 7";
	/** {@value} */
	private static final String PICCO_TRA_CAMPIONI = "\nIl picco tra i campioni della settimana e' stato ";
	/** {@value} */
	private static final String WARNING_SUPERATA_SOGLIA_MASSIMA = "\n WARNING! superata la soglia di sicurezza massima per la settimana (";
	/** numero di giorni di una settimana {@code 7} */
	public static final int GIORNI_SETTIMANA = Giorno.values().length;
	/** {@value} valore soglia <b> allarme medio </b> */
	private static final int WARNING_MEDIA = 50;
	/** {@value} valore soglia <b> allarme picco </b> */
	private static final int WARNING_PICCO = 75;
	/** {@linkplain Giorno} di {@linkplain #giornoPicco} */
	private Giorno giornoPicco;
	/** <b>Media</b> tra tutti i {@linkplain #campioni} */
	private int media_settimana;
	/** E' il valore piu' alto tra tutti {@linkplain #campioni} */
	private int picco_Settimana;
	/**
	 * <b>Attributo</b> {@linkplain Settimana} che identifica l' {@linkplain Array}
	 * di {@linkplain #campioni}
	 */
	private int[] campioni;

	/**
	 * <b>Costruttore</b> viene istanziato un oggetto di tipo {@linkplain #campioni}
	 * {@linkplain Settimana}, con :
	 * 
	 * @param settimanaInserire {@linkplain #campioni}=<code>intera settimana</code>
	 * 
	 * @throws IllegalArgumentException se l'array passato e' composto da piu' (o
	 *                                  meno) di {@linkplain #GIORNI_SETTIMANA}
	 */

	public Settimana(int[] settimanaInserire) {
		if (settimanaInserire.length != GIORNI_SETTIMANA)
			throw new IllegalArgumentException(IMPOSSIBILE_COSTRUIRE_SETTIMANA);
		campioni = settimanaInserire;
		setMedia_Settimana();
		setPicco_settimana();

	}

	

	/**
	 * <b>Metodo</b> <b>che calcola la media settimanale</b> dei
	 * {@linkplain campioni} <b>imposta attributo</b> {@linkplain #media_settimana}
	 */
	private void setMedia_Settimana() {
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

	/**
	 * <b>metodo</b>per <b>che calcola la media settimanale</b> dei
	 * {@linkplain campioni} <b>imposta attributo</b> {@linkplain #picco_Settimana}
	 * {@linkplain #picco_Settimana}=<code>campione massimo</code> see
	 * {@linkplain Settimana} {@linkplain #campioni}
	 */

	public void setPicco_settimana() {
		int massimo = campioni[0];
		int nGiorno = 0;
		for (int i = 1; i < campioni.length; i++) {
			if (campioni[i] > massimo) {
				massimo = campioni[i];
				nGiorno = i;
			}
		}
		giornoPicco = Giorno.values()[nGiorno];
		picco_Settimana = massimo;
	}

	/**
	 * <b>metodo</b>che verifica il<b>superamento allarme medio</b>
	 * @return true se la media dei campioni di @{@linkplain #campioni} e maggiore di{@linkplain #WARNING_MEDIA}
	 */
	public boolean allarmeMedio() {
		return (media_settimana >= WARNING_MEDIA);

	}
    
	/**
	 * <b>metodo</b>che verifica il<b>superamento allarme picco</b>
	 * @return true se uno dei  @{@linkplain #campioni} è maggiore di{@linkplain #WARNING_PICCO}
	 */
	public boolean allarmePicco() {
		return (picco_Settimana >= WARNING_PICCO);

	}

	@Override
	public String toString() {
		StringBuilder fine = new StringBuilder();
		fine.append(MEDIA_TRA_CAMPIONI + getMedia_settimana() + UtilPolveriSottili.misuraSI);
		if (allarmeMedio())
			fine.append(WARNING_SUPERATA_SOGLIA_MEDIA + WARNING_MEDIA + ")");
		fine.append(PICCO_TRA_CAMPIONI + giornoPicco.toString() + " con " + getPicco_Settimana()
				+ UtilPolveriSottili.misuraSI);
		if (allarmePicco())
			fine.append(WARNING_SUPERATA_SOGLIA_MASSIMA + WARNING_PICCO + ")");
		return fine.toString();
	}

}
