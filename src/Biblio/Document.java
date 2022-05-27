package Biblio;

public class Document {
	protected String code;

	protected String titre;

	public Document() {
		setTitre("Aucun Titre");
	}

	public Document(String titre) {
		setTitre(titre);
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

	@Override
	public String toString() {
		String affichage = "document"+"\t"+code + ",\t" + titre;
		return affichage;
	}

}
