package Biblio;

public class Volume extends Document {
	protected String auteur;

	public Volume() {

	}

	public Volume(String titre, String auteur) {
		setTitre(titre);
		setAuteur(auteur);
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return code + ",\t" + titre + ",\t" + auteur;
	}
}
