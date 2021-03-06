package polveri;

import java.time.LocalDate;


import util.mylib.*;

public class Manager {
	private static final String ARCHIVIO_VUOTO = "Archivio vuoto";
	private static final String ELIMINAZIONE_ANNO = "ELIMINAZIONE ANNO";
	private static final String INSERISCI_LA_DATA_DA_CERCARE = "Inserisci la data da cercare";
	private static final String ELIMINAZIONE_ANNULLATA = "Eliminazione annullata";
	private static final String RICERCA_ANNULLATA = "Ricerca annullata ";
	private static final String VUOI_RIPROVARE = "Vuoi riprovare? ";
	private static final String[] ELIMINA_ANNO = { "Elimina per scelta", "Elimina per inserimento" };
	private static final String ELIMINAZIONE_AVVENUTA = "Eliminazione avvenuta";
	private static final String PROBLEMI_NELL_ELIMINAZIONE = "";

	private static final String[] inserisciInArchivio = { "Inserisci anno", "Inserisci settimane", "Elimina un anno",
			"Modifica settimana" };
	private static final String[] VOCI = { "Aggiorna archivio", "Visualizza Archivio" };
	private static final MyMenu menu = new MyMenu("Main Menu", VOCI);

	/** Metodo per usare il Manager */
	public static void startManager() {
		Manager.mainMenu();
	}

	private static void mainMenu() {
		boolean finito = false;
		do {
			switch (menu.scegli()) {
			case 1:
				Manager.inserisciInArchivio();
				break;

			case 2: Manager.visualizzaArchivio();
			break;
			case 0:
				finito = true;
				break;
			default:
				System.out.println("ERRORE");
				break;
			}

		} while (!finito);

	}

	private static void inserisciInArchivio() {

		MyMenu menu = new MyMenu("Inserisci in archivio", inserisciInArchivio);
		switch (menu.scegli()) {
		case 1:
			inserisciAnno();
			break;
		case 2:
			inserimentoSettimana();
			break;

		case 3:
			eliminaAnno();
			break;
		case 4:
			modificaSettimana();
			break;
		default:
			break;
		}
	}

	private static void inserisciAnno() {
		Anno daInserire = null;
		while (true) {
			daInserire = UtilPolveriSottili.creaAnno();
			if (Archivio_anni.inserisci_anno(daInserire)) {
				System.out.println("Anno inserito correttamente ");
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

	private static void inserimentoSettimana() {
		if (Archivio_anni.getNumAnniInArchivio() > 0) {
			String[] anniInArchivio = Archivio_anni.visualizzaAnniInArchivio();
			String[] strDaVisu = new String[anniInArchivio.length + 1];
			for (int i = 0; i < anniInArchivio.length; i++) {
				strDaVisu[i] = anniInArchivio[i];
			}
			strDaVisu[anniInArchivio.length] = "Anno non presente";

			MyMenu anni = new MyMenu("A che anno inseririre una nuova settimana? ", strDaVisu);
			int scelta = anni.scegli();
			if (scelta == strDaVisu.length) {
				System.out.println("Inserisci allora un nuovo Anno nell'archivio ");
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
			System.out.println(ARCHIVIO_VUOTO);
			if (InputDati.yesOrNo("Vuoi inserire un nuovo Anno da campionare? "))
				Manager.inserisciAnno();
		}
	}

	/** inserisce un nuovo brano nel Cd in quella posizione in archivio */
	private static boolean inserisciSettimana(int posAnno) {
		Settimana daInserire = UtilPolveriSottili.creaSettimana();
		if (Archivio_anni.getAnno(posAnno).inserisciSettimana(daInserire)) {
			System.out.println(String.format("Settimana n %d correttamente inserita ", Archivio_anni.getAnno(posAnno).settimane_Inserite()));
			System.out.println(daInserire.toString());
			return true;
		} else {
			System.out.println("L'anno e tutte le sue settimane sono gia' state campionate ");
			System.out.println("Impossibile aggiungerne altre ");
			return false;
		}
	}

	/** Menu di eliminazione CD */
	private static void eliminaAnno() {
		if (Archivio_anni.getNumAnniInArchivio() > 0) {
			MyMenu menu = new MyMenu(ELIMINAZIONE_ANNO, Manager.ELIMINA_ANNO);
			switch (menu.scegli()) {
			case 1: {
				Manager.eliminaAnnoScelta();
				break;
			}
			case 2: {
				Manager.eliminaAnnoInserimento();
				break;
			}

			default:
				System.out.println(ELIMINAZIONE_ANNULLATA);
				break;
			}
		} else
			System.out.println(ARCHIVIO_VUOTO);
	}

	private static void eliminaAnnoInserimento() {
		int numeroAnnoDaEl = InputDati.leggiInteroPositivo(INSERISCI_LA_DATA_DA_CERCARE);
		Anno annoDaEliminare = Archivio_anni.cercaAnno(numeroAnnoDaEl);
		if (annoDaEliminare != null) {
			System.out.println("Sei sicuro di eliminare l'" + annoDaEliminare.getAnno_riferimento()
					+ ".\nI suoi dati sono:" + annoDaEliminare.toString());

			if (InputDati.yesOrNo("")
					&& UtilPolveriSottili.controlloEliminazione(annoDaEliminare.getAnno_riferimento() + "elimina")) {
				Archivio_anni.elimina_Anno(annoDaEliminare.getAnno_riferimento());
				System.out.println("Hai eliminato" + "\n->" + annoDaEliminare.getAnno_riferimento());
			} else
				System.out.println(ELIMINAZIONE_ANNULLATA);
		} else {
			System.out.println("Non esiste l'anno \"" + numeroAnnoDaEl + "\" nell'archivio");
		}
	}

	/** ELimina un CD da uno scelti */
	private static void eliminaAnnoScelta() {
		MyMenu sottomenu = new MyMenu(Manager.ELIMINA_ANNO[0], Archivio_anni.visualizzaAnniInArchivio());
		int scelta = sottomenu.scegli();
		switch (scelta) {
		case 0:
			System.out.println(ELIMINAZIONE_ANNULLATA);
			return;
		default:
			Anno daElim = Archivio_anni.getAnno(scelta - 1);
			if (InputDati.yesOrNo("Sei sicuro di eliminare " + daElim.getAnno_riferimento())) {
				Archivio_anni.elimina_Anno(daElim);
				System.out.println("Hai eliminato" + "\n->" + daElim.getAnno_riferimento());

			} else
				System.out.println(ELIMINAZIONE_ANNULLATA);
			break;
		}
	}

	private static int sceltaAnno(String titoloMenu, String impossibile) {
		if (Archivio_anni.getNumAnniInArchivio() > 0) {
			MyMenu scegliAnno = new MyMenu(titoloMenu, Archivio_anni.visualizzaAnniInArchivio());
			int scelta = scegliAnno.scegli();
			switch (scelta) {
			case 0:
				System.out.println(RICERCA_ANNULLATA);
				return -1;

			default:
				if (Archivio_anni.getAnno(scelta - 1).settimane_Inserite() != 0)
					return scelta - 1;
				else
					System.out.println("Anno vuoto senza alcun campionamento" + impossibile);
				return -2;
			}
		} else
			System.out.println(ARCHIVIO_VUOTO + impossibile);
		return -2;
	}

	private static void modificaSettimana() {
		if (Archivio_anni.getNumAnniInArchivio() > 0) {
			int pos = Manager.sceltaAnno("Scegli che anno", "Impossibile modificare Settimane");
			if (pos >= 0) {
				Anno annoDaModificare = Archivio_anni.getAnno(pos);
				int settimaneInserite = annoDaModificare.settimane_Inserite();
				int settimanaDaModificare = InputDati.leggiIntero(
						"Che numero di settimana vuoi modificare? MAX " + settimaneInserite+" ", 0, settimaneInserite);
				Settimana settimanaDaInserire = UtilPolveriSottili.creaSettimana();
				if (Archivio_anni.getAnno(pos).modificaSettimana(settimanaDaModificare, settimanaDaInserire))
					System.out.println("Settimana modificata con successo");
				else
					System.out.println("Problemi di modifica");
			}
		} else {
			System.out.println("Archivio vuoto");
		}
	}
	
	private static void visualizzaArchivio() {
		System.out.println(Archivio_anni.toStringa());
	}
}
