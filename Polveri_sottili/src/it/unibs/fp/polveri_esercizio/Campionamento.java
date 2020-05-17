package it.unibs.fp.polveri_esercizio;

import it.unibs.fp.mylib.MyMenu;

public class Campionamento {
	
	private static int numero;
	private static final String INTESTAZIONE_MENU = "" + numero;
	private static final String[] VOCI_MENU = {"","",};
	
    ControlloAmbientale settimanale = new Settimana();
    ControlloAmbientale annuale = new Anno();
	
    
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
				/// prende una settimana la legge e notifica allarmi 
				
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
	

}
