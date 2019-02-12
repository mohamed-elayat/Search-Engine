/* Auteurs: Mohamed El Ayat
		  : Loubar Youghourta */


//classe contenant toutes les propriétés et les méthodes d'un objet
//Une classe suffit, puisque tous les noeuds contiennent les mêmes propriétés,
//mais avec des sens différents
public class Object {

	private String mot;
	private int frequence;
	private List listeHorizontale;

	public Object(String mot, int frequence) {

		this.mot = mot;
		this.frequence = frequence;

	}

	public Object(String mot, List list) {

		this.mot = mot;
		this.listeHorizontale = list;

	}

	public void setMot(String mot) {

		this.mot = mot;

	}

	public String getMot() {

		return mot;

	}

	public void setFrequence(int frequence) {

		this.frequence = frequence;

	}

	public int getFrequence() {

		return this.frequence;

	}

	public List getList() {

		return listeHorizontale;

	}

	public void setList(List list){

		this.listeHorizontale = list;

	}

}
