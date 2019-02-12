/* Auteurs: Mohamed El Ayat
		  : Loubar Youghourta */


import java.io.IOException;
import java.io.File;

public class Index {






	public static ListeMot index = new ListeMot();

	// Cette m�thode permet de mettre � jour la structure de donn�es Index,
	// en �tudiant tous les mots du/des document(s) lu d�une source.
	public static void indexSrc(String fichier) throws IOException {

		File f = new File(fichier);


		//cas ou la source est un fichier
		if (f.isFile()) {

			if (Tokenizer.tokenizer(fichier) != null) {

				index.ajout(  new Object(fichier, Index.inserer(Tokenizer.tokenizer(fichier)))  );

			} else {
				System.out.println("---> le fichier est vide <---");
			}
		}

		//cas ou la source est un repertoire
		else if (f.isDirectory()) {

			String[] content = f.list();

			for (int i = 0; i < content.length; i++) {

				Noeud n = index.head;

				if (Tokenizer.tokenizer(fichier + "/" + content[i]) != null) {

					index.ajout(  new Object(content[i], Index.inserer(Tokenizer.tokenizer(fichier + "/" + content[i])))  );

				} else {

					System.out.println("le fichier " + content[i] + " n'a pas �t� index� car il est vide");

				}

			}

		} else {

			System.out.println("le fichier ou le repertoire n'existe pas"+"\n");
		}

	}






	// fonction qui prend un tableau et un mot en param�tre,
	// et calcule la fr�quence du mot dans le tableau
	public static int motFrequence(String word, String[] array) {

		int count = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(word)) {
				count++;
			}
		}

		return count;
	}
	
	// pour trier le tableau en ordre alphab�tique
	public static void InsertionSort(String tab[]) {

		for (int i = 1; i < tab.length; ++i) {
			
			String cle = tab[i];
			int j = i - 1;

			// Bouge les �l�ments de arr[0..i-1] qui sont plus grandes que la cl�
			// jusqu'� ce qu'on trouve un �l�ment plus petit
			
			while (j >= 0 && tab[j].compareTo(cle) > 0) {
				tab[j + 1] = tab[j];
				j = j - 1;
			}
			tab[j + 1] = cle;
		}
		
	}
	
	// m�thode pour convertir un tableau en liste et ins�rer les mots d'un fichier dans la liste
	public static ListeMot inserer(String[] array) {

		ListeMot temp = new ListeMot();

		if (array == null) {
			return null;
		}

		else {

			for (int i = 0; i < array.length; i++) {

				int freq = motFrequence(array[i], array);
				// si la liste vide ajoute le au premier
				if (temp.head == null) {

					temp.head = new Noeud(new Object(array[i], freq), null);

				}

				else {

					Noeud n = temp.head;

					while (n.getProchainNoeud() != null) {
						n = n.getProchainNoeud();
					}
					// si le mot n'est pas d�ja dans la liste ajoute le
					if (!n.getObject().getMot().equals(array[i])) {

						n.setProchainNoeud(new Noeud(new Object(array[i], freq), null));

					}

				}
			}
			return temp;
		}
	}

}
