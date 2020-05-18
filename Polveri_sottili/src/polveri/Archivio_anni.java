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
      /** <b>metodo</b> che <b>controlla per numero </b> se un nuovo_anno è <b>presente</b>
	   * e in caso contraio lo aggiunge in {@linkplain #anni_archiviati}
	   * @param nuovo_anno nuovo anno da inserire
	   * @return <b>conferma</b> inserimento <b>avvenuto con successo</b>
	   * @see {@linkplain #inserisci_anno(Anno)}
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
	 * <b>metodo ricerca posizione</b> in{@linkplain #anni_archiviati}
	 * @param anno_daCercare  numero anno da cercare 
	 * @return posizione dell'anno 
	 * @see metodo   {@linkplain #cercaPosAnno(int)}
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
	 * @param anno_cercato per numero posizione
	 * @return true se la poszione esiste in{@linkplain #anni_archiviati}
	 * @see {@linkplain #cercaPosAnno(int)}
	 */
	public static boolean contiene(int anno_cercato) {
		return (cercaPosAnno(anno_cercato) != -1);
	}
	/**
	  * <b>elimina </b> anno da {@linkplain #anni_archiviati} per <b>posizione</b>
	  * @param anno_daEliminare per numero 
	  * @return true se l'anno è stato <b>rimosso con successo</b>
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
 * <b>metodo</b> per ottenere
 * <b>dimensione archivio</b>
 * @return dimensione {@linkplain ArrayList} {@linkplain #anni_archiviati}
 */
	public static int getNumAnniInArchivio() {
		return anni_archiviati.size();
	}
	
	/**
	 * 
	 * @return  numero anni in archivio 
	 */
	public static String[] visualizzaAnniInArchivio() {
		String[] fine=new String[getNumAnniInArchivio()];
		for (int i=0;i<getNumAnniInArchivio();i++) {
			fine[i]=Integer.toString(anni_archiviati.get(i).getAnno_riferimento());
		}
		return fine;
	}
	/**
	 * <b>metodo</b> per ottenere
	 * <b>indice anno</b>
	 * @param index indice archivio {@linkplain ArrayList} {@linkplain #anni_archiviati}
	 * @return indice
	 */
	public static Anno getAnno(int index) {
		return anni_archiviati.get(index);
	}
	
	public static Anno cercaAnno(int annoDaCercare) {
		return anni_archiviati.get(cercaPosAnno(annoDaCercare));
	}
	
}
