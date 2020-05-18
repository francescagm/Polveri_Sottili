package polveri;

import java.util.ArrayList;

public class Anno {

	private ArrayList<Settimana> settimane;
	public static final int NUMERO_SETTIMANE_ANNO = 53;
	private int anno_riferimento;
	private int somma_medie;
	private Settimana settConPiccoPiuAlto;

	public int getAnno_riferimento() {
		return anno_riferimento;
	}

	public Anno(int anno_riferimento) {
		this.anno_riferimento = anno_riferimento;
		settimane = new ArrayList<>(NUMERO_SETTIMANE_ANNO);

	}

	public boolean inserisciSettimana(Settimana settimana) {
		if (NUMERO_SETTIMANE_ANNO >= settimane_Inserite()) {
			calcolasettConPiccoPiuAlto(settimana);
			somma_medie += settimana.getMedia_settimana();
			return settimane.add(settimana);
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
			settimane.remove(numero_settimana - 1);
			settimane.add(numero_settimana - 1, settimana);
			ricalcolaSommaMedia();
			ricalcolaSettConPiccoPiuAlto();
			return true;
		}
		return false;
	}

	private void ricalcolaSommaMedia() {
		int totaleCapioniSettimana = 0;
		for (int i = 0; i < settimane.size(); i++) {
			totaleCapioniSettimana += settimane.get(i).getMedia_settimana();
		}
		somma_medie = totaleCapioniSettimana;
	}

	private void calcolasettConPiccoPiuAlto(Settimana settimana) {
		if (this.settConPiccoPiuAlto == null)
			this.settConPiccoPiuAlto = settimana;
		else {
			if (settimana.getPicco_Settimana() > this.settConPiccoPiuAlto.getPicco_Settimana())
				this.settConPiccoPiuAlto = settimana;
		}
	}

	private void ricalcolaSettConPiccoPiuAlto() {
		settConPiccoPiuAlto = null;
		for (Settimana settimana : settimane) {
			calcolasettConPiccoPiuAlto(settimana);
		}
	}

	public int getMedia_annuale() {
		return Math.round(somma_medie / settimane.size());
	}

	public String toString() {
		return String.format("Anno %d, settimane inserite %d. \nLa media di PM10 per quest'anno fin'ora e' %d%s",
				getAnno_riferimento(), settimane_Inserite(), getMedia_annuale(), UtilPolveriSottili.miusraSI);
	}

}