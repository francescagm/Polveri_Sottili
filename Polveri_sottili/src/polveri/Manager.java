package polveri;

import java.time.LocalDate;


import util.mylib.*;

public class Manager {
	/** {@value}*/
	private static final String RICERCA_ANNULLATA = "Ricerca annullata ";
	/** {@value}*/
	private static final String VUOI_RIPROVARE = "Vuoi riprovare? ";
	/** {@value}*/
	private static int numero;
	
	private static final String INTESTAZIONE_MENU = "" + numero;
	private static final String[] VOCI_MENU = { "", "", };

	public void rilevazioni() {
		MyMenu rilevazioni = new MyMenu(INTESTAZIONE_MENU + numero, VOCI_MENU);
		boolean finito = false;
		do {
			int scelta = rilevazioni.scegli();
			switch (scelta) {
			case 0:
				finito = true;
				break;

			case 1:
				System.out.println("inserisci campioni settimana per controllo");

				break;
			case 2:
				// piu settimane o solo sopra o while sopra
				break;
			case 3:
				// notifica situazione annuale richiamando le rilavaizoni inplementate
				break;

			}
		} while (!finito);
	}

	//
	// public static void aggiungiSettimana(){
	//
	// int anno =InputDati.leggiIntero(INSERIRE_ANNO, ANNO_MINIMO, ULTIMO_ANNO);
	// int settimanaRiferimento =InputDati.leggiIntero(NUMERO_SETTIMANA,
	// NUMERO_MINIMO_SETTIMANA, NUMERO_SETTIMANE_ANNO);
	// Integer[]rilevazione = new Integer[]
	// for
	//
	// }

	public static void inserisciAnno() {
		Anno daInserire = null;
		while (true) {
			daInserire = UtilPolveriSottili.creaAnno();
			if (Archivio_anni.inserisci_anno(daInserire)) {
				System.out.println("Anno inserito correttamente");
				int pos = Archivio_anni.cercaPosAnno(daInserire.getAnno_riferimento());
				while (inserisciSettimana(pos)) {
					if (!InputDati.yesOrNo("Vuoi inserire una nuova settimana? "))
						return;
				}
			} else {
				System.out.println("Errore nella creazione dell'anno, anno gia' presente");
				if (!InputDati.yesOrNo(Manager.VUOI_RIPROVARE))
					return;
			}
		}

	}

	public static void inserimentoSettimana() {
		if (Archivio_anni.getNumAnniInArchivio() > 0) {
			String[] anniInArchivio = Archivio_anni.visualizzaAnniInArchivio();
			String[] strDaVisu = new String[anniInArchivio.length + 1];
			for (int i = 0; i < anniInArchivio.length; i++) {
				strDaVisu[i] = anniInArchivio[i];
			}
			strDaVisu[anniInArchivio.length] = "Anno non presente";

			MyMenu anni = new MyMenu("A che anno inseririre una nuova settimana?", strDaVisu);
			int scelta = anni.scegli();
			if (scelta == strDaVisu.length) {
				System.out.println("Inserisci allora un nuovo Anno nell'archivio");
				inserisciAnno();
				return;
			}
			switch (scelta) {
			case 0:
				System.out.println(RICERCA_ANNULLATA);
				return;

			default:
				Manager.inserisciSettimana(scelta - 1);
				break;
			}
		} else {
			System.out.println("Archivio vuoto");
			if (InputDati.yesOrNo("Vuoi inserire un nuovo Anno da campionare?"))
				inserisciAnno();
		}
	}

	/** inserisce un nuovo brano nel Cd in quella posizione in archivio */
	private static boolean inserisciSettimana(int posAnno) {
		Settimana daInserire = UtilPolveriSottili.creaSettimana();
		if (Archivio_anni.getAnno(posAnno).inserisciSettimana(daInserire)) {
			System.out.println("Settimana inserita correttamente");
			return true;
		} else {
			System.out.println("L'anno e tutte le sue settimane sono gia' state campionate");
			System.out.println("Impossibile aggiungerne altre");
			return false;
		}
	}

}
