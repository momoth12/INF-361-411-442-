public class Utilisateur {
    public final String nom;
    private final String hash;
    private final String[] guess;
    private int nGuess;

    public Utilisateur(String n, String h, int maxGuess){
	// a completer
    }

    public String toString(){
	String s = this.nom + " " + this.hash + " [";
	for(int i = 0; i < this.nGuess; i++){
	    s += this.guess[i];
	    if(i < this.nGuess-1)
		s += ", ";
	}
	return s + "]";
    }

    public void ajouterGuess(String g){
    }

    public String deviner_mdp(){
	// a completer
	return null;
    }

}
