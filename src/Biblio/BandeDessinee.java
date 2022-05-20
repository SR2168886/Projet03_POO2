package Biblio;

public class BandeDessinee extends Volume {

	protected int numEdition;

	public BandeDessinee() {
		setTitre("Aucun Titre");
		setAuteur("Aucun Auteur");
		setNumEdition(0);
	}

	public BandeDessinee(String Titre, String auteur, int numEdition) {
		setTitre(titre);
		setAuteur(auteur);
		setNumEdition(numEdition);
	}

	public int getNumEdition() {
		return numEdition;
	}

	public void setNumEdition(int numEdition) {
		this.numEdition = numEdition;
	}

	@Override
	public String toString() {
		return code + ",\t" + titre + ",\t" + auteur + ",\t" + numEdition;
	}
}
