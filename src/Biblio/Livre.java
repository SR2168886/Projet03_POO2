package Biblio;

public class Livre extends Volume {

	private int annee;

	private String genre;

	private int nbCopie;

	private int nbCopieDispo;

	public Livre() {
		setAuteur("Aucun Auteur");
		setTitre("Aucun Titre");
		setAnnee(0);
		setNbCopie(0);
		setGenre("Aucun Genre");
		setNbCopieDispo(0);
	}

	public Livre(String titre,String auteur, int annee, String genre, int nbcopie) {
		setAuteur(auteur);
		setTitre(titre);
		setAnnee(annee);
		setNbCopie(nbcopie);
		setGenre(genre);
		setNbCopieDispo(nbcopie);
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getNbCopie() {
		return nbCopie;
	}

	public void setNbCopie(int nbCopie) {
		this.nbCopie = nbCopie;
	}

	public int getNbCopieDispo() {
		return nbCopieDispo;
	}

	public void setNbCopieDispo(int nbCopieDispo) {
		this.nbCopieDispo = nbCopieDispo;
	}

	@Override
	public String toString() {
		String message = "Livre:" + "\t" + getCode() + "\t" + getTitre() + "\t" + getAuteur() + "\t" + genre + "\t"
				+ getNbCopieDispo()+"/"	+ getNbCopie() ;
		return message;
	}

}
