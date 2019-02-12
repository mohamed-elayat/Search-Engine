/* Auteurs: Mohamed El Ayat
		  : Loubar Youghourta */

import java.io.*;


//class
public class Tokenizer {

	public String texte;
	public String[] texteToken;

	public Tokenizer() {

	}

	// prend un path en paramètre, va chercher le contenu du texte
	// donner par le path et initie le texte
	public void lireFichier(String path) throws IOException {

		@SuppressWarnings("resource")

		// le fileReader prend un path relatif qui est le root du projet creer

		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = "";
		String text = "";

		while ((line = reader.readLine()) != null) {

			text += line + " ";
		}

		this.texte = text;

	}

	// prend le texte et créé le tokenize
	public void createTokens() {

		texte = texte.toLowerCase();
		texte = texte.replaceAll("[^A-z0-9àâçéèêëîïôûùüÿñÀÂÇÉÈÊËÎÏÔÛÙÜŸæœ]", " ");
		this.texteToken = this.texte.split(" +");

	}

	// une fonction qui prend comme paramètre un repertoire ou un fichier
	// et fait la tokenisation du/des fichiers
	public static String[] tokenizer(String file) throws IOException {

		File f = new File(file);

		if (f.length() == 0) {
			return null;
		}

		else {

			Tokenizer token = new Tokenizer();
			token.lireFichier(file);
			token.createTokens();
			Index.InsertionSort(token.texteToken);

			return token.texteToken;
		}

	}

}
