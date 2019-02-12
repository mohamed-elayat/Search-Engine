/* Auteurs: Mohamed El Ayat
		  : Loubar Youghourta */



import java.io.IOException;
import java.util.Scanner;

public class Engin {

	public static void main(String[] args) throws IOException {


		//tests pour effectuer la methode desirée de l'utilisateur
		while (true) {

			System.out.println(  "\n"  );
			System.out.println("Veuillez entrer une commande: ");
			System.out.println("'indexer', 'inverser', 'afficher', 'rechercher' ou 'fin' \n");

			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);

			String consigne1 = input.nextLine();

			String[] consigne2 = consigne1.split(" ", 2);

			if (consigne2[0].equals("indexer")) {
				Index.index = new ListeMot();
				if (consigne2.length > 1 ) {

					indexer(consigne2[1]);

				}
				
			} else if (consigne2[0].equals("inverser")) {
			
				indexerInv();
				
			} else if (consigne2[0].equals("afficher")) {

				afficher();

			} else if (consigne2[0].equals("rechercher")) {
				ListeDoc.searchResult=null;
				if (consigne2.length > 1) {

					rechercher(consigne2[1]);
					
				}
				if(ListeDoc.searchResult == null) {
					System.out.println("la requete n'existe pas dans les fichiers");
				}

			} else if (consigne2[0].equals("fin")) {

				System.out.println("---> fin programme <---");
				break;
				
			} else {

				System.out.println("---> la commande n'existe pas <---");

			}

		}

	}

	// Appelle la methode pour indexer la source
	public static void indexer(String fichier) throws IOException {

		Index.indexSrc(  fichier  );

	}

	// Appelle la methode indexInvSrc qui inverse l'index
	public static void indexerInv() throws IOException {

		IndexInv.indexInvSrc();

	}


	// appelle la methode rechercheSrc qui repond a la requete
	public static List rechercher(String requete) throws IOException {

		return Recherche.rechercheSrc(  requete  );

	}



	// Cette méthode affiche le contenu des deux structures d’index sur l’écran.
	public static void afficher() {

		System.out.println("\n");

		Index.index.afficherListeVerticale();

		System.out.println("\n");

		IndexInv.indexInv.afficherListeVerticale();

		System.out.println("\n");

	}



}
