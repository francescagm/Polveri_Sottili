package polveri;

import java.util.ArrayList;

public class Archivio_anni {
	public static ArrayList<Anno> anni_archiviati = new ArrayList<>();

	private Archivio_anni() {

	}
  /** @*/
	public static boolean inserisci_anno(int nuovo_anno) {
		if(!contiene(nuovo_anno))
		return anni_archiviati.add(new Anno(nuovo_anno));
		return false;
	}
	
	public static boolean inserisci_anno(Anno anno) {
		return inserisci_anno(anno.getAnno_riferimento());
	}

	public static int cercaPosAnno(int anno_daCercare) {
		for (int i = 0; i < anni_archiviati.size(); i++) {
			if (anni_archiviati.get(i).getAnno_riferimento() == anno_daCercare)
				return i;

		}
		return -1;
	}

	public static boolean contiene(int anno_cercato) {
		return (cercaPosAnno(anno_cercato) != -1);
	}

	public static boolean elimina_Anno(int anno_daEliminare) {
		int pos = (cercaPosAnno(anno_daEliminare));
		if (pos != -1) {
			anni_archiviati.remove(pos);
			return true;
		}
		return false;

	}
}
