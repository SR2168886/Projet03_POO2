package Biblio;

public class BD extends Volume {

	private int numEdition;

	public BD() {

	}
	public BD(String Titre, String auteur, int numEdition) {

	}



	public int getNumEdition() {
		return numEdition;
	}
	public void setNumEdition(int numEdition) {
		this.numEdition = numEdition;
	}

	@Override
	public String toString() {
		return "";
	}
}