package Biblio;

public class Journal extends Document {
<<<<<<< HEAD
=======

	String Parution;



	Journal(){
		setTitre("aucun titre");


	}

	Journal(String titre,String code,String parution){
		setTitre(titre);
		Parution = parution;
		setCode(code);
	}

	@Override
	public String toString() {
		return "Journal:\t"+getCode()+"\t"+getTitre()+"\t"+Parution;
	}
	public String getParution() {
		return Parution;
	}

	public void setParution(String parution) {
		Parution = parution;

	}
>>>>>>> branch 'main' of https://github.com/SR2168886/Projet03_POO2.git

}
