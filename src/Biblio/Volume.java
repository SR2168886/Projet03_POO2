package Biblio;

public class Volume extends Document {
	private String auteur;

	public Volume() {

	}
	public Volume (String titre, String auteur) {

	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "";
	}
}
