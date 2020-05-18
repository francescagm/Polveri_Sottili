package polveri;

import java.time.LocalDate;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import util.mylib.InputDati;

public class UtilPolveriSottili {
	
	private static final int ANNO_MINIMO = 1950;
	private static final int ULTIMO_ANNO = LocalDate.now().getYear();
	private static final String NUMERO_SETTIMANA = "inserire il numero della settimana nell'anno di riferimento";
	private static final String INSERIRE_ANNO = "Inserire anno di riferimento del campionamento ";
	public static final  String misuraSI = "µg/m³";

	public static Anno creaAnno() {
		return new Anno(InputDati.leggiIntero(INSERIRE_ANNO, ANNO_MINIMO, ULTIMO_ANNO));
	}

	public static Settimana creaSettimana() {
		int[] settimanaInserire= new int [Settimana.GIORNI_SETTIMANA];
		for (int i = 0; i < Settimana.GIORNI_SETTIMANA; i++) {
			settimanaInserire[i]=(InputDati.leggiInteroConMinimo("Inserisci il valore di PM10 per "+Giorno.values()[i], 0));
		}
		return new Settimana(settimanaInserire);
	}
}
