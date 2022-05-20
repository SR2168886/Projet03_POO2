package Biblio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import ressourceExterne.CodeGenerator;

public class Biblio implements Serializable {

	int MAXLIVRE = 500;
	Livre[] livres= new Livre[MAXLIVRE];
	int nbLivre;


	public Biblio() {


	}


	public void ajout(String titre,String auteur,int annee,String genre, int nbcopie, int dispo) {



		String code = CodeGenerator.generateCode();
		Document[nbLivre]= new Document(auteur,titre,annee,genre,nbcopie);


		Document[nbLivre].setCode(code);
		Document[nbLivre].setNbCopieDispo(dispo);
		nbLivre++;
	}


	public void pret(String code) {              //emprunte un livre et réduit le nombre de livre dispo
		int pos = rechercheC(code);
		if (livres[pos].getNbCopieDispo()-1>=0) {
			livres[pos].setNbCopieDispo(livres[pos].getNbCopieDispo()-1);
		} else {
			JOptionPane.showMessageDialog(null, "emprunt a échoué");
		}
	}

	public void retour(String code) {           //retourne le livre emprunter et augmente le livre de dipo
		int pos = rechercheC(code);
		if (livres[pos].getNbCopieDispo()<=livres[pos].getNbCopie()) {
			livres[pos].setNbCopieDispo(livres[pos].getNbCopieDispo()+1);
		} else {
			JOptionPane.showMessageDialog(null, "retour a échoué");
		}
	}

	@Override
	public String toString() {      //affiche la liste de livre de la bibliothèque
		String message="";
		Arrays.sort(livres,0,nbLivre);
		for(int i=0; i<livres.length; i++) {
			if(livres[i]!=null) {
				message += livres[i].toString()+"\n";
			}
		}
		return message;

	}

	public void supression(String code) {        //suprime un livre du répertoire
		int pos = rechercheC(code);
		for(int i=pos; i< Document.length; i++) {
			if(Docuement [i]!=null) {
				livres[i] = livres[i+1];
			}
		}
		nbLivre--;

	}

	public Livre obtention(int pos) {           //obtien le livre basée sur la position trouvée
		Livre temp =livres[pos];
		return temp;
	}

	public int rechercheC(String code) {   //effectue uner recherche du livre basée sur le code
		int position=0;
		for(int i=0; i<livres.length;i++) {
			if (livres[i]!=null) {
				livres[i].getCode();
				if (code.equals(livres[i].getCode())) {
					position = i;
					return position;
				}

			}

		}
		return position;
	}
	public int rechercheN(String nom) {     //effectue une recherche du livre basée sur le nom
		int position=0;
		for(int i=0; i<livres.length;i++) {
			if (livres[i]!=null) {
				String temp = livres[i].getTitre();

				if (nom.equals(temp)) {
					position = i;
				}
			}
		}
		return position;

	}

	public void chargement() {
		String path= "./MesRessource/Livre.txt";
		String ligne = null;

		int nb = 0; // compteur de personnes
		try // try with
		(FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr);) {

			while (br.ready() && nb < livres.length) {
				//lire une ligne
				ligne = br.readLine();

				// extraire les donnees
				StringTokenizer strk = new StringTokenizer(ligne, ";");

				String titre = strk.nextToken();
				String auteur = strk.nextToken();
				int nbCopie = Integer.parseInt(strk.nextToken());
				int nbCopieDispo =  Integer.parseInt(strk.nextToken());
				int annee = Integer.parseInt(strk.nextToken());
				String genre=strk.nextToken();


				// instancier Livre
				//Livre p = new Livre (auteur,titre,annee, genre, nbCopie);
				//p.setNbCopieDispo(nbcopiedispo);

				// l'ajouter au tableau
				//livres[nb] = p;
				//nb=Livre.g;
				ajout(titre,auteur,annee,genre,nbCopie, nbCopieDispo);

			}

			br.close();
		} catch (NumberFormatException e) {
			System.out.println("Erreur d'age");
		} catch (FileNotFoundException e) {
			System.out.println("Erreur : fichier non trouve");
		} catch (IOException e) {
			System.out.println("Erreur de lecture du fichier");
		} catch (NoSuchElementException e) {
			System.out.println("\nErreur de donnees du fichier : impossible de parser la ligne");
		}
	}

	public void Sauvegarde() throws IOException {
		String path= "./MesRessource/Livre.json";
		try(Writer out = new FileWriter(path);){

			//	Gson gs = new GsonBuilder().setPrettyPrinting().create();

			//	gs.toJson(livres, out);
		}
	}

}





