package polveri;


import java.time.LocalDate;

import util.mylib.*;

public class Manager {

	private static int numero;
	private static final String INTESTAZIONE_MENU = "" + numero;
	private static final String[] VOCI_MENU = {"","",};
	public static final  String miusraSI = "µg/m³";


    
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
//    public static  void  aggiungiSettimana(){
//    	
//    	int anno =InputDati.leggiIntero(INSERIRE_ANNO, ANNO_MINIMO, ULTIMO_ANNO);
//    	int settimanaRiferimento =InputDati.leggiIntero(NUMERO_SETTIMANA, NUMERO_MINIMO_SETTIMANA, NUMERO_SETTIMANE_ANNO);
//        Integer[]rilevazione = new Integer[]
//        for
//			
//    }
    
    public static void inserisciAnno() {
  
    if(Archivio_anni.inserisci_anno(UtilPolveriSottili.creaAnno()))
    	System.out.println("Anno creato correttamente");
    else System.out.println("Impossibile aggiungere l'anno, in quanto gia' presente nell archivio");
    
    }

}
    
    	
  
			 
    
    
    

	