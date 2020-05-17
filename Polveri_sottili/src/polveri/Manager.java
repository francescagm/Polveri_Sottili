package polveri;


import java.time.LocalDate;

import util.mylib.*;

public class Manager {
	
	private static final int NUMERO_SETTIMANE_ANNO = 53;
	private static final int NUMERO_MINIMO_SETTIMANA = 1;
	private static final String NUMERO_SETTIMANA = "inserire il numero della settimana nell'anno di riferimento";
	private static final String INSERIRE_ANNO = "inserire anno di riferimento del campionamento ";
	private static final int ULTIMO_ANNO = LocalDate.now().getYear();
	private static int numero;
	private static final String INTESTAZIONE_MENU = "" + numero;
	private static final String[] VOCI_MENU = {"","",};
	public static final  String miusraSI = "µg/m³";
	private static final int ANNO_MINIMO = 1950;

    
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
	
//  
//    public static  void  aggiungiSettimana(){
//    	
//    	int anno =InputDati.leggiIntero(INSERIRE_ANNO, ANNO_MINIMO, ULTIMO_ANNO);
//    	int settimanaRiferimento =InputDati.leggiIntero(NUMERO_SETTIMANA, NUMERO_MINIMO_SETTIMANA, NUMERO_SETTIMANE_ANNO);
//        Integer[]rilevazione = new Integer[]
//        for
//			
//    }
    
    public static void creaAnno() {
    int anno=InputDati.leggiIntero(INSERIRE_ANNO, ANNO_MINIMO, ULTIMO_ANNO);
    Archivio_anni.inserisci_anno(anno);
    }

}
    
    	
  
			 
    
    
    

	