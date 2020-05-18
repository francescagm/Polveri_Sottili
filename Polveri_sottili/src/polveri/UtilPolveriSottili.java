package polveri;

import java.time.LocalDate;



import util.mylib.InputDati;

public class UtilPolveriSottili {
	private final static String frame = "********************************************************";
	private final static String MESS_GOODBYE = "\n ARRIVEDERCI  \n  ";
	private final static String MESS_WELCOME = "       CONTROLLO AMBIENTALE\n       rilevamento particolato PM10";
	
	/** anno minimo di partenza rilevazioni*/
	private static final int ANNO_MINIMO = 1950;
	/** data attuale ultimo inserimento valido*/
	private static final int ULTIMO_ANNO = LocalDate.now().getYear();
	/**{@value} */
	private static final String NUMERO_SETTIMANA = "inserire il numero della settimana nell'anno di riferimento ";
	/**{@value} */
	private static final String INSERIRE_ANNO = "Inserire anno di riferimento del campionamento ";
	/**unità di misura per particolato atmosferico */
	public static final  String misuraSI = "µg/m³";
    /** 
     * @return legge anno del campionamento
     */
	public static Anno creaAnno() {
		return new Anno(InputDati.leggiIntero(INSERIRE_ANNO, ANNO_MINIMO, ULTIMO_ANNO));
	}
    /**
     * input dei campioni per una intera settimana 
     * @return  settimana completa  settimanaInserire 
     */
	public static Settimana creaSettimana() {
		int[] settimanaInserire= new int [Settimana.GIORNI_SETTIMANA];
		for (int i = 0; i < Settimana.GIORNI_SETTIMANA; i++) {
			settimanaInserire[i]=(InputDati.leggiInteroConMinimo("Inserisci il valore di PM10 per "+Giorno.values()[i]+" ", 0));
		}
		return new Settimana(settimanaInserire);
	}
	public static boolean controlloEliminazione(String controllo) {
		String daControllare= InputDati.leggiStringa("Inserisci la parola \""+controllo+"\" per eliminare ");
		return (daControllare.equals(controllo));
	}
	
	/**
	* Prints welcome message
	*/
	public static void printWelcome() {
		System.out.println(frame);
		System.out.println(MESS_WELCOME);
		System.out.println(frame);
	}

	/**
	 * Prints a goodbye message
	 */
	public static void printGoodbye() {
		System.out.println(frame);
		System.out.println(MESS_GOODBYE);
		System.out.println(frame);
}
}
