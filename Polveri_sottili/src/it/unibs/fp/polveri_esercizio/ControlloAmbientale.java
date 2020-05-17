package it.unibs.fp.polveri_esercizio;

public interface ControlloAmbientale {
	public boolean allarmeMedio();
	public boolean allarmePicco();
	public int picco();
	public int campioneMedio();
	public void campionamento();
	public void  rileva();
}
