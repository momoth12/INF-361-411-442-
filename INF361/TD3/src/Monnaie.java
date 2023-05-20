import tc.TC;

public class Monnaie {
	public final String nom;
	private double taux;
	public Monnaie(String nom,double taux) {
		this.nom=nom;
		this.taux=taux;
	}
	public double getTaux() {
		return this.taux;
	}
	public void setTaux(double autreTaux) {
		this.taux=autreTaux;
	}
	public boolean estEgalA(Monnaie m) {
		if((m!=null)&&(this.nom==m.nom)&&(this.taux==m.taux))
			return true;
		else
			return false;
	}

}
