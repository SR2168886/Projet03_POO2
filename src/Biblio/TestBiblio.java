package Biblio;

import java.io.IOException;

public class TestBiblio {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		Document test = new Volume("test","Zack");
		Biblio Bibli = new Biblio();
		Bibli.ajout(test);
		Bibli.Sauvegarde();

	}

}
