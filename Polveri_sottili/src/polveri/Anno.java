package polveri;

import java.util.ArrayList;

public class Anno {

	private ArrayList<Settimana> settimane;
	public static final int NUMERO_SETTIMANE_ANNO = 53;
	private int anno_riferimento;
	private int somma_medie;
	private int settConPiccoPiuAlto = -1;

	public int getAnno_riferimento() {
		return anno_riferimento;
	}

	public Anno(int anno_riferimento) {
		this.anno_riferimento = anno_riferimento;
		settimane = new ArrayList<>(NUMERO_SETTIMANE_ANNO);

	}

	public boolean inserisciSettimana(Settimana settimana) {
		if (NUMERO_SETTIMANE_ANNO >= settimane_Inserite()) {
			settimane.add(settimana);
			somma_medie += settimana.getMedia_settimana();
			calcolasettConPiccoPiuAlto(settimane_Inserite() - 1);
			return true;
		}
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
			somma_medie -= settimane.get(numero_settimana - 1).getMedia_settimana();
			settimane.remove(numero_settimana - 1);
			settimane.add(numero_settimana - 1, settimana);
			somma_medie += settimane.get(numero_settimana - 1).getMedia_settimana();
			ricalcolaSettConPiccoPiuAlto();
			return true;
		}
		return false;
	}

	private void calcolasettConPiccoPiuAlto(int nSettimana) {
		if (this.settConPiccoPiuAlto == -1)
			this.settConPiccoPiuAlto = nSettimana;
		else {
			if (settimane.get(nSettimana).getPicco_Settimana() > settimane.get(settConPiccoPiuAlto)
					.getPicco_Settimana())
				this.settConPiccoPiuAlto = nSettimana;
		}
	}

	private void ricalcolaSettConPiccoPiuAlto() {
		settConPiccoPiuAlto = -1;
		for (int i = 0; i < settimane.size(); i++) {
			calcolasettConPiccoPiuAlto(i);
		}
	}

	public int getMedia_annuale() {
		return Math.round(somma_medie / settimane.size());
	}

	public String toString() {
		return String.format("Anno %d, settimane inserite %d. \nLa media di PM10 per quest'anno fin'ora e' %d%s",
				getAnno_riferimento(), settimane_Inserite(), getMedia_annuale(), UtilPolveriSottili.misuraSI);
	}

}