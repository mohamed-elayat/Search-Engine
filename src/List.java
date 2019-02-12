/* Auteurs: Mohamed El Ayat
		  : Loubar Youghourta */

public class List {
	
	Noeud head;
	
	public static List searchResult;
	
	// fonction qui retourne la liste horizontale / liste secondaire
	public String donnerListeHorizontale() {

		if (head == null) {
			return "";
		}

		else {
			Noeud n = head;
			String wordlist = "";

			while (n != null) {
				wordlist = wordlist + n.getObject().getFrequence() + " " + n.getObject().getMot() + " " + "-->" + " ";
				n = n.getProchainNoeud();
			}

			return wordlist;

		}

	}
	
	// pour afficher la liste primaire qui contient les mots ou bien les noms des fichiers avec leurs fr�quences.
	public void afficherListeVerticale() {
		
		if (head != null) {

			Noeud n = head;

			while (n != null) {

				System.out.println(
						n.getObject().getMot() + ": " + n.getObject().getList().donnerListeHorizontale() + " null");
				
				n = n.getProchainNoeud();
				
				
			}
		}
	}


	//retourne la longueur d'une liste
	public int longueur(){

		Noeud n = head;

		int count = 0;

		while (n != null){

			count++;
			n=n.getProchainNoeud();

		}
		return count;

	}

	//Vérifie si une liste est vide
	public boolean estVide(){

		if (head == null){
			return true;
		}

		else {
			return false;
		}
	}

	//ajoute un Object a une liste
	public void ajout(Object element2){
		//Si la Liste est vide
		if(this.estVide()){
			head = new Noeud(element2,null); //On change la r�f�rence � premier
		}
		//Si la Liste n'est pas vide
		else{
			Noeud n = head;
			//On parcourt la Liste jusqu'au dernier Noeud
			while(n.getProchainNoeud()!=null){
				n = n.getProchainNoeud();
			}
			//On ajoute le Noeud � la fin de la Liste
			n.setProchainNoeud(new Noeud(element2, null));
		}
	}

	
	// m�thode pour afficher la liste de r�ponse.
	public void afficherRecherche() {

		if (head != null) {

			Noeud n = head;

			while (n != null) {

				System.out.println(n.getObject().getFrequence() + " fois dans " + n.getObject().getMot());
				n = n.getProchainNoeud();

			}
		}
	}


	//methode pour convertir une liste en tableau d'Object
	//utilisé lors du tri de documents selon la frequence
	public static Object[] toArr(List list){

		Object[] arr = new Object[list.longueur()];

		if (  !list.estVide()  ){

			Noeud n = list.head;
			int i = 0;

			while (  n != null  ){

				arr[i] = n.getObject();
				i++;


				n=n.getProchainNoeud();
			}

		}

		return arr;
	}


	//methode partition utilisé recursivement par la methode sort
	public static int partition (Object arr[], int low, int high){

		int pivot = arr[high].getFrequence();

		int i = low - 1;

		for (int j = low; j < high; j++){


			if (arr[j].getFrequence() >= pivot){

				i = i +1;

				int temp = arr[i].getFrequence();
				String temps = arr[i].getMot();

				arr[i].setFrequence( arr[j].getFrequence() );
				arr[i].setMot(  arr[j].getMot()  );

				arr[j].setFrequence(  temp  );
				arr[j].setMot(  temps  );

			}

		}

		int temp = arr[i + 1].getFrequence();
		String temps = arr[i+1].getMot();

		arr[i + 1].setFrequence(  arr[high].getFrequence()  );
		arr[i + 1].setMot(  arr[high].getMot()  );

		arr[high].setFrequence(  temp  );
		arr[high].setMot(  temps  );

		return i + 1;

	}

	//méthode qui effectue un tri quicksort du tableau en paramètre, dans le cadre spécifié
	public static void sort (Object[] arr, int low, int high){

		if ( low < high ){

			int p = partition(  arr, low, high  );


			sort(  arr, low, p - 1  );

			sort(  arr, p + 1, high  );


		}

	}


	//convertit un tableau d'object en liste
	public static List toSortedList (Object[] arr){

		List temp = new List();

		if (  arr == null  ){

			return null;

		}

		else{

			for ( int i = 0; i < arr.length; i++  ){

				temp.ajout(  arr[i]  );

			}

		}
		return temp;
	}


	//methode pour effectuer le quicksort
	public static void trierFreq(List list){

		Noeud n = list.head;

		while (  n != null  ){

			Object[] temp = toArr(  n.getObject().getList()  );

			sort(  temp, 0, temp.length - 1  );

			n.getObject().setList( toSortedList(  temp )  );

			n = n.getProchainNoeud();

		}

	}



}
