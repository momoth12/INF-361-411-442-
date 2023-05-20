import tc.TC;

public class Maillon {
    public final Candidat contenu;
    private Maillon suivant;

    public Maillon(Candidat c) {
        this.contenu = c;
        this.suivant = null;
    }

    public Maillon(Candidat c, Maillon reste) {
        this.contenu = c;
        this.suivant = reste;
    }

    public static void afficher(Maillon m) {
        Maillon courant = m;
        while (courant != null) {
            TC.println(courant.contenu);
            courant = courant.suivant;
        }
    }

    public Maillon suivant() {
        return this.suivant;
    }

    // Les methodes ci-dessous sont a completer au cours des exercices du TP

    public static Maillon dernier(Maillon m) {
    	if(m==null)
    		return null;
        if(m.suivant==null)
        	return m;
        else {
        	return dernier(m.suivant);
        }
    }

    public static int longueur(Maillon m) {
    	if(m==null)
    		return 0;
        int l=1;
        while(m.suivant!=null) {
        	l++;
        	m=m.suivant;
        }
        return l;
    }

    public Maillon ajouterApres(Candidat c) {
        return null;
    }

    public static void enleverSuivant(Maillon m) {
    }

}
