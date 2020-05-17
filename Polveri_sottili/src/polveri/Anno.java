package polveri;

import java.util.ArrayList;

public class Anno {

	private ArrayList<Settimana> settimane;
	public static final int NUMERO_SETTIMANE_ANNO = 53;
	private int anno_riferimento;

	public int getAnno_riferimento() {
		return anno_riferimento;
	}

	public Anno(int anno_riferimento) {
		this.anno_riferimento = anno_riferimento;
		settimane = new ArrayList<>(NUMERO_SETTIMANE_ANNO);

	}

	public boolean inserisciSettimana(Settimana settimana) {
		if (NUMERO_SETTIMANE_ANNO >= settimane_Inserite())
			return settimane.add(settimana);
		return false;

	}

	public int settimane_Inserite() {

		return settimane.size();
	}

	public boolean existSettimana(int numero_settimana) {
		return (!(numero_settimana > settimane_Inserite()));

	}

	public boolean modificaSettimana(int numero_settimana, Settimana settimana) {
		if (existSettimana(numero_settimana)) {
			settimane.remove(numero_settimana - 1);
			settimane.add(numero_settimana - 1, settimana);
			return true;
		}
		return false;
	}

}