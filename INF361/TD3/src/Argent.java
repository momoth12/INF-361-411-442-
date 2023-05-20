import tc.TC;
public class Argent {

	// répresentation interne de l'argent:
	// Champs d'objet
	private final int valeur;
	private final Monnaie monnaie;

	public Argent(int v) {
		this.valeur = v;
		this.monnaie = new Monnaie("Euro", 1.0);
	}

	public Argent(int v, Monnaie monnaie) {
		if (monnaie == null)
			throw new IllegalArgumentException("le parametre monnaie est null");
		this.valeur = v;
		this.monnaie = monnaie;
	}

	public Monnaie getMonnaie() {
		return this.monnaie;
	}
	
	public int getValeur() {
		return this.valeur;
	}

	public int valeurEntiere() {
		return this.valeur / 100;
	}

	public int valeurDecimale() {
		return this.valeur % 100;
	}
	
	public boolean estEgalA(Argent a) {
		return ((a!=null)&&(this.valeur==a.valeur)&&(this.monnaie.estEgalA(a.monnaie)));
		
	}

	public String toString() {
		String s;
		String v;
		if(this.valeur/100<2)
			s="";
		else
			s="s";
		if(this.valeur%100<10)
			v="0";
		else
			v="";
		
		return((this.valeur/100)+(".")+v+(this.valeur%100)+" "+(this.monnaie.nom)+s);
	}

	public Argent convertir(Monnaie autreMonnaie) {
		// a completer
		return null;
	}

	public Argent plus(Argent x) {
		// a completer
		return null;
	}

	public Argent moins(Argent x) {
		// a completer
		return null;
	}
}
