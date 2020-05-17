package polveri;

import java.time.LocalDate;

import util.mylib.InputDati;

public class UtilPolveriSottili {
	
	private static final int ANNO_MINIMO = 1950;
	private static final int ULTIMO_ANNO = LocalDate.now().getYear();
	private static final String NUMERO_SETTIMANA = "inserire il numero della settimana nell'anno di riferimento";
	private static final String INSERIRE_ANNO = "Inserire anno di riferimento del campionamento ";

	public static Anno creaAnno() {
		return new Anno(InputDati.leggiIntero(INSERIRE_ANNO, ANNO_MINIMO, ULTIMO_ANNO));
	}
}
