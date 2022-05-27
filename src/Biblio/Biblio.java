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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ressourceExterne.CodeGenerator;

public class Biblio implements Serializable {

	int MAXDOCUMENTS = 500;
	String nom;
	ArrayList <Document> documents = new ArrayList();
	int nbDocuments;

	public Biblio() {
		setNom("Bibliotheque Sans Nom");
	}

	public Biblio(String nom) {
		setNom(nom);
	}

	public void ajout(Document newDocument) {
		if (documents.size() < MAXDOCUMENTS) { // Pas de generation si on est plein!
<<<<<<< HEAD
			int longueurTitre = newDocument.getTitre().length();
			int longueurAnnee = Integer.toString(((Livre) newDocument).getAnnee()).length();
			String code = CodeGenerator.generateCode(newDocument.getTitre(), ((Volume) newDocument).getAuteur(),
					((Livre) newDocument).getAnnee(), longueurTitre, longueurAnnee);
			newDocument.setCode(code);
=======
			int longueurTitre = 5;
			int longueurAnnee = 2;
			if(newDocument instanceof Livre) {

				String code = CodeGenerator.generateCode(newDocument.getTitre(),((Volume) newDocument).getAuteur(),((Livre)newDocument).getAnnee(),longueurTitre,longueurAnnee);
				newDocument.setCode(code);
			}
			if(newDocument instanceof BandeDessinee) {
				String code = CodeGenerator.generateCode(newDocument.getTitre(),((Volume) newDocument).getAuteur(),((BandeDessinee)newDocument).numEdition,longueurTitre,longueurAnnee);
				newDocument.setCode(code);
			}
			if(newDocument instanceof Journal) {
				String code = CodeGenerator.generateCode(newDocument.getTitre(),((Journal) newDocument).getParution(),0,longueurTitre,longueurAnnee);
			}



>>>>>>> branch 'main' of https://github.com/SR2168886/Projet03_POO2.git
			documents.add(newDocument);
			nbDocuments++;

		}
	}

	public void supression(int index) {
		documents.remove(index);
	}

	public String pret(int index) {
		if(documents.get(index)instanceof Livre) {
			((Livre)documents.get(index)).setNbCopieDispo(((Livre)documents.get(index)).getNbCopieDispo()-1);
			return "prêt: \t"+ ((Livre)documents.get(index)).toString();
		}
		else {
			return "Le document ne peut être emprunter";
		}
	}
	public String retourner(int index) {
		if(documents.get(index)instanceof Livre) {
			((Livre)documents.get(index)).setNbCopieDispo(((Livre)documents.get(index)).getNbCopieDispo()+1);
			return "retour: \t"+ ((Livre)documents.get(index)).toString();
		}
		else {
			return "Le document ne peut être retourner";
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

				String classe = strk.nextToken();
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
<<<<<<< HEAD
				Document nouveauDocument;
				switch (classe) {
				case "Document":
					nouveauDocument = new Document();
					ajout(nouveauDocument);
					break;
				case "Volume":
					nouveauDocument = new Volume();
					ajout(nouveauDocument);
					break;
				case "BandeDessinee":
					nouveauDocument = new BandeDessinee();
					ajout(nouveauDocument);
					break;
				case "Journal":
					nouveauDocument = new Journal();
					ajout(nouveauDocument);
					break;
				case "Livre":
					nouveauDocument = new Livre();
					ajout(nouveauDocument);
					break;
				}
=======


>>>>>>> branch 'main' of https://github.com/SR2168886/Projet03_POO2.git

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
		String path = "./Ressource/Document.json";
		try (Writer out = new FileWriter(path);) {

			Gson js = new

					GsonBuilder().setPrettyPrinting().create();

			js.toJson(documents, out);
		}
	}

	@Override
	public String toString() {
		String message = "Liste triée des documents : \n ";
		for (Document each: documents ) {
			message += each.toString();

		}
		return message;
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
