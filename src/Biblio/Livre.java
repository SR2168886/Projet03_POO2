package Biblio;

public class Livre extends Volume {



	private int annee;

	private String genre;


	public Livre() {

	}

	public Livre(String auteur ,String titre,int annee,String genre, int nbcopie ) {
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




	public void setAnnee(int année) {
		this.annee = année;
	}


	@Override
	public String toString() {
		String message = "Livre"+ "\t"+ getCode()+ "\t"+getTitre() + "\t"+getAuteur()+"\t"+ genre + "\t" +getNbCopie()+"\t"+ getNbCopieDispo();
		return message;
	}


}
