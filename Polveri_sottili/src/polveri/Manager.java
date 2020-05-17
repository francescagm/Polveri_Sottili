package polveri;

import util.mylib.*;

public class Manager {
	
	private static int numero;
	private static final String INTESTAZIONE_MENU = "" + numero;
	private static final String[] VOCI_MENU = {"","",};
	private static final  String miusraSI = "µg/m³";
	private final  static String PM10 = campione + miusraSI;
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
	
  
    public void  rileva()
	{
		  WeekFields setSettimanaStandard = WeekFields.of(DayOfWeek.MONDAY,1); 
		  TemporalField settimaDelAnno = setSettimanaStandard.weekOfYear(); 
		  LocalDate dataInput = LocalDate.of(2020,5, 15); //data diinzio miurazioni 
		  int numSettimanaAnnoPerGiorno =  dataInput.get(settimaDelAnno); 
		  //DayOfWeek  giornoDellaSettimana =dataInput .getDayOfWeek();
		  //int numeroGiornoDellaSettimana = dataInput.getDayOfWeek().getValue();
		  
		//int anno = InputDati.leggiInteroConMinimo(RICHIESTA_ANNO, ANNO_MINIMO);
		//int numeroSettimana = InputDati.leggiIntero(RICHIESTA_NUM_SETTIMANA,1,MAX_SETTIMANE);
	    // qui io vorrei creare un inputo con leggi data ...e dalla data indentificare numero settimana e tutto il resto ma per ora faccio cosi 
		for (int i = 0; i <settimana.size(); i++)
			 {
		    Giorno giorno = null;
		    int campione = 0;
			settimana.add(Giorno.newIstance(giorno, campione));
			 }
    
    
    
}
