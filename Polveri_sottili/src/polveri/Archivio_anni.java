package polveri;

import java.util.ArrayList;
/**
 * {@linkplain Archivio_anni} classe che rappresental'archivio di tutti gli anni campionati
 * 
 */

public class Archivio_anni {
	/**
	 * <b>Attributo</b>di classe {@linkplain Archivio_anni} che identifica un
	 * {@linkplain ArrayList} di {@linkplain Anno}
	 */
	
	private static ArrayList<Anno> anni_archiviati = new ArrayList<>();
/**
 * <b>costruttore</b>
 */
	private Archivio_anni() {

	}
      /** <b>metodo</b> che <b>controlla per numero </b> se un nuovo_anno � <b>presente</b>
	   * e in caso contraio lo aggiunge in {@linkplain #anni_archiviati}
	   * @param nuovo_anno nuovo anno da inserire
	   * @return <b>conferma</b> inserimento <b>avvenuto con successo</b>
	   * @see inserisci_anno(Anno)
	   */	 
	public static boolean inserisci_anno(int nuovo_anno) {
		if(!contiene(nuovo_anno))
		return anni_archiviati.add(new Anno(nuovo_anno));
		return false;
	}
	/**
	    * 
	    * @param anno nuovo_anno da inserire 
	    * @return <b>conferma</b> inserimento <b>avvenuto con successo</b>
	    * @see inserisci_anno(int)
	    */
	
	public static boolean inserisci_anno(Anno anno) {
		return inserisci_anno(anno.getAnno_riferimento());
	}
	/**
	 * <b>metodo ricerca della posizione</b> in{@linkplain #anni_archiviati}
	 * @param anno_daCercare per numero anno
	 * @return posizione dell'anno 
	 * @see cercaPosAnno(int)
	 */
	public static int cercaPosAnno(int anno_daCercare) {
		for (int i = 0; i < anni_archiviati.size(); i++) {
			if (anni_archiviati.get(i).getAnno_riferimento() == anno_daCercare)
				return i;

		}
		return -1;
	}
	/**
	 * <b>controlla esistenza per posizione</b> 
	 * @return true se la poszione esiste in{@linkplain #anni_archiviati}
	 * @see cercaPosAnno(int)
	 */
	public static boolean contiene(int anno_cercato) {
		return (cercaPosAnno(anno_cercato) != -1);
	}
	
	public static boolean contiene(Anno anno_cercato) {
		return contiene(anno_cercato.getAnno_riferimento());
	}
	/**
	  * <b>elimina </b> anno da {@linkplain #anni_archiviati} per <b>posizione</b>
	  * @return true se l'anno � stato <b>rimosso con successo</b>
	  */
	public static boolean elimina_Anno(int anno_daEliminare) {
		int pos = (cercaPosAnno(anno_daEliminare));
		if (pos != -1) {
			anni_archiviati.remove(pos);
			return true;
		}
		return false;

	}
	/**
	  * <b>elimina </b> anno da {@linkplain #anni_archiviati} per <b>{@linkplain Anno}</b>
	  * @param anno_daEliminare  per anno
	  * @return true se l'anno � stato <b>rimosso con successo</b>
	  */
	public static boolean elimina_Anno(Anno anno_daEliminare) {
		return elimina_Anno(anno_daEliminare.getAnno_riferimento());
	}
/**
 * <b>metodo</b> per ottenere
 * <b>dimensione archivio</b>
 * @return dimensione {@linkplain ArrayList} {@linkplain #anni_archiviati}
 */
	public static int getNumAnniInArchivio() {
		return anni_archiviati.size();
	}
	
	/**<b>metodo per menu</b>
	 * per uso menu 
	 * @return un  Array di Stringhe
	 */
	public static String[] visualizzaAnniInArchivio() {
		String[] fine=new String[getNumAnniInArchivio()];
		for (int i=0;i<getNumAnniInArchivio();i++) {
			fine[i]=Integer.toString(anni_archiviati.get(i).getAnno_riferimento());
		}
		return fine;
	}
	/**
	 * <b>metodo</b> che cerca anno per
	 * <b>indice </b>
	 * @param index indice archivio {@linkplain ArrayList} {@linkplain #anni_archiviati}
	 * @return anno cercato 
	 */
	public static Anno getAnno(int index) {
		return anni_archiviati.get(index);
	}
	/**
	 * <b>metodo</b> che cerca anno per
	 * <b>posizione </b>
	 * @param annoDaCercare per posizione 
	 * @return anno cercato 
	 */
	public static Anno cercaAnno(int annoDaCercare) {
		return anni_archiviati.get(cercaPosAnno(annoDaCercare));
	}
	
	public static String toStringa() {

		if(getNumAnniInArchivio()>0) {
		StringBuilder fine =new StringBuilder();
		for (int i = 0; i < anni_archiviati.size(); i++) {
			fine.append(anni_archiviati.get(i).toString());
			fine.append("\n");
		}
		return fine.toString();
		}else {
			return "vuoto";
		}
	}
}
