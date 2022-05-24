package Biblio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import ressourceExterne.CodeGenerator;

public class Biblio implements Serializable {

	int MAXDOCUMENTS = 500;
	String nom;
	ArrayList documents = new ArrayList();
	int nbDocuments;

	public Biblio() {
		setNom("Bibliotheque Sans Nom");
	}

	public Biblio(String nom) {
		setNom(nom);
	}

	public void ajout(Document newDocument) {
		if (documents.size() < MAXDOCUMENTS) { // Pas de generation si on est plein!
			int longueurTitre = newDocument.getTitre().length();
			int longueurAnnee = Integer.toString(((Livre)newDocument).getAnnee()).length();
			String code = CodeGenerator.generateCode(newDocument.getTitre(),((Volume) newDocument).getAuteur(),((Livre)newDocument).getAnnee(),longueurTitre,longueurAnnee);
			newDocument.setCode(code);
			documents.add(newDocument);
			nbDocuments++;
		}
	}

	public void chargement() {
		String path = "./MesRessource/Livre.txt";
		String ligne = null;

		int nb = 0; // compteur de personnes
		try // try with
		(FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr);) {

			while (br.ready() && (nb < documents.size())) {
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

	public int getMAXDOCUMENTS() {
		return MAXDOCUMENTS;
	}

	public void setMAXDOCUMENTS(int mAXDOCUMENTS) {
		MAXDOCUMENTS = mAXDOCUMENTS;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList documents) {
		this.documents = documents;
	}

	public int getNbDocuments() {
		return nbDocuments;
	}

	public void setNbDocuments(int nbDocuments) {
		this.nbDocuments = nbDocuments;
	}

}
