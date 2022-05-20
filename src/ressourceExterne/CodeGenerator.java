package ressourceExterne;



// Classe utilitaire pour generer le code du livre a partir de ses informations
public class CodeGenerator {

	public static char[] HEXADECIMAL = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
	'F' };

	public static String generateCode(String titre, String auteur, int annee, int longueurTitre, int longueurAnnee) {
		if (longueurTitre <= 0) {
			longueurTitre = 1;
		}
		if (longueurAnnee <= 0) {
			longueurAnnee = 1;
		}
		String returnCode = ""; // String qui contiendra le code final

		returnCode += generateCodeLetter(auteur) + "-";

		returnCode += CustomHash(titre, longueurTitre) + "-";

		returnCode += CustomHash(Integer.toString(annee), longueurAnnee);

		return returnCode;
	}

	public static String generateCodeLetter(String auteur) {
		String returnCode = "";
		String AuteurNom[] = auteur.split(" ");

		if (AuteurNom.length >= 2 && AuteurNom != null) { // Premiere Partie du Code = Premiere lettre Nom Prenom Auteur
			returnCode = AuteurNom[0].substring(0, 1).toUpperCase(); // IE : Patrick Senecal = PS-*****-**
			returnCode += AuteurNom[1].substring(0, 1).toUpperCase();
		} else if (auteur.length() >= 2) { // Si Pas 2 Noms Code = 2 premieres lettres du nom
			returnCode = auteur.substring(0, 2).toUpperCase(); // IE : Corneille = CO-*****-**
		} else if (auteur.length() == 1) {
			returnCode += auteur.toUpperCase() + "0";
		}
		else {
			returnCode += "XX"; // Sinon Code = XX-*****-**
		}

		return returnCode;
	}

	public static String CustomHash(String titre, int longCode) {
		String returnCode = "";
		char[] nomTrans = titre.toCharArray(); // nom converti en Char[]
		int[] nbReduce = new int[longCode]; // Bucket pour le "Hashage"
		String retourAdd = ""; // String temporaire pour transformer le titre en chiffre

		if (titre.length() >= longCode) { // Si la String est >= a la longeur du code

			for (int i = 0; i < nomTrans.length; i++)
			{
				nbReduce[i % nbReduce.length] += nomTrans[i]; // du titre a leur "Bucket" respective
			}

			for (int i = nomTrans.length - 1; i >= 0; i--)
			{
				nbReduce[i % nbReduce.length] += nomTrans[i]; // les "Buckets"
			}

			for (int i = 0; i < nbReduce.length; i++)
			{
				retourAdd += HEXADECIMAL[reduceInt(nbReduce[i])]; // Ajoute la valeur "hashe" au code en HEX ( base 16 )
			}

			returnCode += retourAdd;
		} else { // Si la String est < la longeur du code
			// ** Beaucoup de pattern quand String < que hash sortant **
			for (int i = 0; i < longCode - 1; i++) {
				nbReduce[i % nomTrans.length] += nomTrans[i % nomTrans.length];
			}

			for (int i = longCode - 1; i >= 0; i--)
			{
				nbReduce[(nomTrans[i % nomTrans.length]) % nbReduce.length] += nomTrans[i % nomTrans.length]; // les
				// "Buckets"
			}

			for (int i = 0; i < nbReduce.length; i++) {
				retourAdd += HEXADECIMAL[reduceInt(nbReduce[i])];
			}

			returnCode += retourAdd;
		}

		return returnCode;
	}

	public static int reduceInt(int value) {
		int temp = value;

		if (value < HEXADECIMAL.length) {
			return value;
		} else {
			while (temp >= HEXADECIMAL.length) {
				temp = (temp / 10) + temp % 10;
			}
		}

		return temp;
	}

	public static String reverse(String string) {
		char tempString[] = string.toCharArray();
		String finalString = "";

		for (int i = 0, j = tempString.length - 1; i < string.length(); i++, j--) {
			tempString[j] = string.charAt(i);
		}

		for (int i = 0; i < tempString.length; i++) {
			finalString += tempString[i];
		}

		return finalString;
	}

}
