package Biblio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import ressourceExterne.CodeGenerator;

public class Biblio implements Serializable {

	int MAXDOCUMENTS = 500;
	ArrayList documents = new ArrayList();
	int nbDocuments;

	public Biblio() {

	}

	public void ajout(String titre, String auteur, int annee, String genre, int nbcopie, int dispo) {
		if (documents.size() < MAXDOCUMENTS) { // Pas de generation si on est plein!
			String code = CodeGenerator.generateCode();
			Document newDocument = new Document(auteur, titre, annee, genre, nbcopie);
			newDocument.setCode(code);
			newDocument.setNbCopieDispo(dispo);
			documents.add(newDocument);
			nbDocuments++;
		}
	}

	public void pret(String code) { // emprunte un livre et r�duit le nombre de livre dispo
		int pos = rechercheC(code);
		if ((documents[pos].getNbCopieDispo() - 1) >= 0) {
			documents[pos].setNbCopieDispo(documents[pos].getNbCopieDispo() - 1);
		} else {
			JOptionPane.showMessageDialog(null, "emprunt a �chou�");
		}
	}

	public void retour(String code) { // retourne le livre emprunter et augmente le livre de dipo
		int pos = rechercheC(code);
		if (documents[pos].getNbCopieDispo() <= documents[pos].getNbCopie()) {
			documents[pos].setNbCopieDispo(documents[pos].getNbCopieDispo() + 1);
		} else {
			JOptionPane.showMessageDialog(null, "retour a �chou�");
		}
	}

	@Override
	public String toString() { // affiche la liste de livre de la biblioth�que
		String message = "";
		Arrays.sort(documents, 0, nbLivre);
		for (int i = 0; i < documents.length; i++) {
			if (documents[i] != null) {
				message += documents[i].toString() + "\n";
			}
		}
		return message;

	}

	public void supression(String code) { // suprime un livre du r�pertoire
		int pos = rechercheC(code);
		for (int i = pos; i < documents.length; i++) {
			if (documents[i] != null) {
				documents[i] = documents[i + 1];
			}
		}
		nbLivre--;

	}

	public Livre obtention(int pos) { // obtien le livre bas�e sur la position trouv�e
		Livre temp = documents[pos];
		return temp;
	}

	public int rechercheC(String code) { // effectue uner recherche du livre bas�e sur le code
		int position = 0;
		for (int i = 0; i < documents.length; i++) {
			if (documents[i] != null) {
				documents[i].getCode();
				if (code.equals(documents[i].getCode())) {
					position = i;
					return position;
				}

			}

		}
		return position;
	}

	public int rechercheN(String nom) { // effectue une recherche du livre bas�e sur le nom
		int position = 0;
		for (int i = 0; i < documents.length; i++) {
			if (documents[i] != null) {
				String temp = documents[i].getTitre();

				if (nom.equals(temp)) {
					position = i;
				}
			}
		}
		return position;

	}

	public void chargement() {
		String path = "./MesRessource/Livre.txt";
		String ligne = null;

		int nb = 0; // compteur de personnes
		try // try with
		(FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr);) {

			while (br.ready() && (nb < documents.length)) {
				// lire une ligne
				ligne = br.readLine();

				// extraire les donnees
				StringTokenizer strk = new StringTokenizer(ligne, ";");

				String titre = strk.nextToken();
				String auteur = strk.nextToken();
				int nbCopie = Integer.parseInt(strk.nextToken());
				int nbCopieDispo = Integer.parseInt(strk.nextToken());
				int annee = Integer.parseInt(strk.nextToken());
				String genre = strk.nextToken();

				// instancier Livre
				// Livre p = new Livre (auteur,titre,annee, genre, nbCopie);
				// p.setNbCopieDispo(nbcopiedispo);

				// l'ajouter au tableau
				// livres[nb] = p;
				// nb=Livre.g;
				ajout(titre, auteur, annee, genre, nbCopie, nbCopieDispo);

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
		String path = "./MesRessource/Livre.json";
		try (Writer out = new FileWriter(path);) {

			// Gson gs = new GsonBuilder().setPrettyPrinting().create();

			// gs.toJson(livres, out);
		}
	}

}
