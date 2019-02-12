/* Auteurs: Mohamed El Ayat
		  : Loubar Youghourta */


//classe contenant les variables et les getters setters du noeuc
public class Noeud {

	private Object element;
	private Noeud next;

	public Noeud(Object element, Noeud next) {

		this.element = element;
		this.next = next;

	}

	public Object getObject() {

		return this.element;

	}

	public void setObject(Object element) {
		this.element = element;
	}

	public Noeud getProchainNoeud() {

		return this.next;
	}

	public void setProchainNoeud(Noeud next) {

		this.next = next;

	}

}
