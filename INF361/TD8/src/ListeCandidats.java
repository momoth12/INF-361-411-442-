import tc.TC;

public class ListeCandidats implements CollectionCandidats {

    private Maillon tete;
    private Maillon queue;

    public ListeCandidats() {
        this.tete = null;
        this.queue = null;
    }

    public void afficher() {
        if (this.tete == null) TC.println("<liste vide>");
        else Maillon.afficher(this.tete);
    }

    public boolean estVide() {
        return this.tete == null && this.queue == null;
    }

    public void ajouterEnTete(Candidat c) {
        Maillon m = new Maillon(c,this.tete);
        this.tete = m;
        if (this.queue == null)
            /* on a ajoute un candidat a la liste vide: il est
             * a la fois le premier et le dernier.
             */
            this.queue = m;
    }

    // Les methodes ci-dessous sont a completer au cours des exercices du TP

    public int nombreCandidats() {
        if(this.tete==null&&this.queue==null)
        	return 0;
        int r=1;
        if(this.tete.suivant()!=null) {
        	this.tete=this.tete.suivant();
        	r=r+1;
        }
        return r;	
    }

    public boolean estCorrecte() {
        boolean r=false;
        if(this.tete==null&&this.queue==null)
        	r=true;
        if(this.tete.suivant()!=null&&this.queue.suivant()!=null) {
        	if(this.queue.suivant()==Maillon.dernier(this.tete)){
        		r=true;
        	}
        		
        }
        if(this.tete.suivant()==this.queue.suivant()) {
        	r=true;
        		
        }
      
      
        
        
        
        return r;
        
    }

    public void ajouterEnQueue(Candidat c) {
    }

    public void ajouterFichierEnQueue(String nomFichier) {
    }

    public void enleverSuivant(Maillon precedent) {
    }

    public void desistement(Candidat c, CandidatComparator cmp) {
    }

    public void desistementFichier(String nomFichier) {
        CandidatComparator cmp = new CandidatComparatorNom();
    
    }

    public void selection(CandidatComparator cmp) {
    }

    public void ajouterFichierTrie(String nomFichier) {
        CandidatComparator cmp = new CandidatComparatorNom();
    }

}
