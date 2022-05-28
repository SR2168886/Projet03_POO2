package Biblio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ressourceExterne.CodeGenerator;

public class Biblio implements Serializable {
	private static final long serialVersionUID = 1L;
	int MAXDOCUMENTS = 500;
	String nom;
	ArrayList<Document> documents = new ArrayList<Document>();
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
			int longueurAnnee = Integer.toString(((Livre) newDocument).getAnnee()).length();
			String code = CodeGenerator.generateCode(newDocument.getTitre(), ((Volume) newDocument).getAuteur(),
					((Livre) newDocument).getAnnee(), longueurTitre, longueurAnnee);
			longueurTitre = 5;
			longueurAnnee = 2;
			if (newDocument instanceof Livre) {
				code = CodeGenerator.generateCode(newDocument.getTitre(), ((Volume) newDocument).getAuteur(),
						((Livre) newDocument).getAnnee(), longueurTitre, longueurAnnee);
			}
			if (newDocument instanceof BandeDessinee) {
				code = CodeGenerator.generateCode(newDocument.getTitre(), ((Volume) newDocument).getAuteur(),
						((BandeDessinee) newDocument).numEdition, longueurTitre, longueurAnnee);
			}
			if (newDocument instanceof Journal) {
				code = CodeGenerator.generateCode(newDocument.getTitre(), ((Journal) newDocument).getParution(), 0,
						longueurTitre, longueurAnnee);
			}
			newDocument.setCode(code);
			documents.add(newDocument);
			nbDocuments++;

		}
	}

	public void supression(int index) {
		documents.remove(index);
	}

	public String pret(int index) {
		if (documents.get(index) instanceof Livre) {
			((Livre) documents.get(index)).setNbCopieDispo(((Livre) documents.get(index)).getNbCopieDispo() - 1);
			return "pret: \t" + ((Livre) documents.get(index)).toString();
		}
		return "Le document ne peut etre emprunter";
	}

	public String retourner(int index) {
		if (documents.get(index) instanceof Livre) {
			((Livre) documents.get(index)).setNbCopieDispo(((Livre) documents.get(index)).getNbCopieDispo() + 1);
			return "retour: \t" + ((Livre) documents.get(index)).toString();
		}
		return "Le document ne peut etre retourner";
	}

	public Document rechercheCode(String code) {
		for (Document d : documents) {
			if (d.getCode() == code)
				return d;
		}
		return null;
	}

	public Document rechercheTitre(String titre) {
		for (Document d : documents) {
			if (d.getTitre() == titre)
				return d;
		}
		return null;
	}

	public void chargement() throws FileNotFoundException, IOException {
		String path = "./src/resources/Document.json";
		Gson js = new GsonBuilder().setPrettyPrinting().create();
		try (Reader in = new FileReader(path);) {
			documents = js.fromJson(path, ArrayList.class);
		} catch (NumberFormatException | IOException e) {
			System.out.println("Type d'erreur: " + e.getMessage());
		}
	}

	public void Sauvegarde() throws IOException {
		String path = "./src/resources/Document.json";
		Gson js = new GsonBuilder().setPrettyPrinting().create();
		try (Writer out = new FileWriter(path);) {
			js.toJson(toString(), out);
		}
	}

	@Override
	public String toString() {
		String message = "Liste triee des documents : \n";
		for (Document each : documents) {
			message += each.toString() + "\n";
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
