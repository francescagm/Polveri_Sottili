package polveri;

import java.util.ArrayList;
/**
 * {@linkplain Anno} classe che rappresenta collezione settimane in un anno normalizzato a {@linkplain #NUMERO_SETTIMANE_ANNO}
 */

public class Anno {
	/**
	 * <b>Attributo</b>di classe {@linkplain Anno} che identifica un
	 * {@linkplain ArraList} di {@linkplain #settimane}
	 */
    private ArrayList<Settimana> settimane;
	/** <b>attributo</b> che identifica il numero standard di settimane in un anno {@linkplain #NUMERO_SETTIMANE_ANNO} */
	public static final int NUMERO_SETTIMANE_ANNO = 53;
	/**
	 * <b>attributo</b> che identifica l'anno di campionamento
	 * {@linkplain #getAnno_riferimento()}
	 */
	private int anno_riferimento;
	/**
	 * <b>attributo</b> identifica la somma delle <b>medie delle settimane campionate</b>
	 * {@linkplain #getMedia_annuale()}
	 */
	private int somma_medie;
	/**
	 * <b>attributo</b> che identifica la <b> settimana con picco più alto </b>
	 * {@linkplain #anno_riferimento} e {@linkplain #settConPiccoPiuAlto}
	 */
	private int settConPiccoPiuAlto = -1;
	/**
	 * <b>metodo</b> che ritorna <b>anno di campionamento</b>
	 * @return {@linkplain #anno_riferimento}
	 */
	public int getAnno_riferimento() {
		return anno_riferimento;
	}

	/**
	 * <b>Costruttore</b> viene istanziato un oggetto di tipo {@linkplain Anno}
	 * {@linkplain ArrayList} di {@linkplain #settimane}<b> disponibili
	 * campionate</b> per
	 * 
	 * @param anno_riferimento anno della raccolta campioni
	 */
	public Anno(int anno_riferimento) {
		this.anno_riferimento = anno_riferimento;
		settimane = new ArrayList<>(NUMERO_SETTIMANE_ANNO);

	}
	/**
	 * <b>metodo</b> 
	 * @param settimana campionata durante {@linkplain #anno_riferimento} 
	 * <b>salva la settimana con picco più alto</b>{@linkplain #settConPiccoPiuAlto} 
	 * <b>aggiunge</b>lamedia della settimana a{@linkplain #somma_medie}
	 * @return true <b>conferma</b> inserimento in {@linkplain #settimane} 
	 */
     public boolean inserisciSettimana(Settimana settimana) {
		if (NUMERO_SETTIMANE_ANNO >= settimane_Inserite()) {
			settimane.add(settimana);
			somma_medie += settimana.getMedia_settimana();
			calcolasettConPiccoPiuAlto(settimane_Inserite() - 1);
			return true;
		}
		return false;

	}
     /** @return dimensioni di {@linkplain #settimane} */
	public int settimane_Inserite() {

		return settimane.size();
	}
    
	public Settimana getSettimana(int index) {
		return settimane.get(index);
	}
	
	/**
	 * <b>verifica settimana per numero </b> in {@linkplain #settimane_Inserite()} 
	 * @param numero_settimana numero della settimana in {@linkplain #anno_riferimento}
	 * @return true se compreso nella lista
	 */
	public boolean existSettimana(int numero_settimana) {
		return (!(numero_settimana > settimane_Inserite()));

	}
	/**
	 * <b>metodo che permette di correggere una settimana inserita</b>
	 * 
	 * @param numero_settimana in {@linkplain #anno_riferimento}
	 * @param settimana        di {@linkplain #anno_riferimento} 
	 * <b>rimuove</b> lasettimana se presente
     * <b>sostiuisce</b> con nuova settimana campionata
	 * @return true se la sostituzione è 
	 * <b> avvenuta con successo </b> 
	 * esegue
	 *         {@linkplain #ricalcolaSettConPiccoPiuAlto()}
	 *         e{@linkplain #ricalcolaSommaMedia()}
	 */
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
	/**
	 * <b> metodo che raffronta </b> il valore di <b>picco</b> della <b>settimana
	 * corrente</b> con {@linkplain #settConPiccoPiuAlto} e se maggiore <b>setta
	 * nuova</b>{@linkplain #settConPiccoPiuAlto}
	 * 
	 * @param settimana in cerca del valore più alto tra i campioni settimanali
	 */
     private void calcolasettConPiccoPiuAlto(int nSettimana) {
		if (this.settConPiccoPiuAlto == -1)
			this.settConPiccoPiuAlto = nSettimana;
		else {
			if (settimane.get(nSettimana).getPicco_Settimana() > settimane.get(settConPiccoPiuAlto)
					.getPicco_Settimana())
				this.settConPiccoPiuAlto = nSettimana;
		}
	}
     /** <b>controlla </b> {@linkplain #calcolasettConPiccoPiuAlto(Settimana)} */
	private void ricalcolaSettConPiccoPiuAlto() {
		settConPiccoPiuAlto = -1;
		for (int i = 0; i < settimane.size(); i++) {
			calcolasettConPiccoPiuAlto(i);
		}
	}
	/**
	 * <b>metodo</b> per il calcolo della <b>media</b> di tutte le
	 * {@linkplain #settimane} campionate in {@linkplain #anno_riferimento}
	 * 
	 * @return media annuale
	 */
	public int getMedia_annuale() {
		return Math.round(somma_medie / settimane.size());
	}
	/** @return {@linkplain String} media PM10 dell'anno di interesse */
	public String toString() {
		return String.format("Anno %d, settimane inserite %d. \nLa media di PM10 per quest'anno fin'ora e' %d%s\n",
				getAnno_riferimento(), settimane_Inserite(), getMedia_annuale(), UtilPolveriSottili.misuraSI,settimanaPiccoString());
	}

	public String settimanaPiccoString() {
		Settimana settimana= settimane.get(settConPiccoPiuAlto);
		return String.format("La settimana con il picco piu' alto e' la numero %d\nIl giorno era %s, ed il valore e' %d", settConPiccoPiuAlto,settimana.getGiornoPicco(),settimana.getPicco_Settimana());
	}
}