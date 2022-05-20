package Biblio;

public class Document {
	private String code;

	private String titre;

	public Document() {

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

		return "";
	}

}
