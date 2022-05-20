package Biblio;

public class Document {
	private  String code;

	private String titre;

	private int nbCopie;

	private int nbCopieDispo;

	public Document(){

	}

	public void Document(String titre,int nbCopie) {

	}

	public String getCode() {
		return code;
	}

	public String getTitre() {
		return titre;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNbCopie() {
		return nbCopie;
	}

	public int getNbCopieDispo() {
		return nbCopieDispo;
	}

	public void setNbCopie(int nbCopie) {
		this.nbCopie = nbCopie;
	}

	public void setNbCopieDispo(int nbCopieDispo) {
		this.nbCopieDispo = nbCopieDispo;
	}

	@Override
	public String toString() {

		return "";
	}

}
