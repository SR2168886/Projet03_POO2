package Biblio;

public class Journal extends Document {

	String parution;

	Journal() {
		setTitre("aucun titre");

	}

	Journal(String titre, String parution) {
		setTitre(titre);
		setParution(parution);
	}

	@Override
	public String toString() {
		return "Journal:\t" + getCode() + "\t" + getTitre() + "\t" + parution;
	}

	public String getParution() {
		return parution;
	}

	public void setParution(String parution) {
		this.parution = parution;

	}

}
