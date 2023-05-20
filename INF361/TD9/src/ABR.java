import tc.TC;

public class ABR {
  private Noeud racine;

  // construit un arbre vide
  public ABR() {
    this.racine = null;
  }

  // construit un arbre avec cette racine (pour les tests seulement)
  public ABR(Noeud _racine) {
    this.racine = _racine;
  }

  // construit un ABR équilibré à partir d'une liste d'entrées
  // que l'on suppose triée.
  public ABR(ListeEntrees liste) {
    Entree[] entrees = liste.toArray();
    int n = entrees.length;
    if (n == 0) // arbre vide
      racine = null;
    else // arbre non vide
      this.racine = Noeud.indexerTableauTrie(entrees, 0, n - 1);
  }

  public String toString() {
    return "Index de : " + racine;
  }

  public void dessiner() {
    new Fenetre(this.racine);
  }

  // Ajouter toutes les occurrences de mots d'un texte.
  // La lecture se fait via la classe TC qui ignore la ponctuation.
  public void indexerTexte() {
    int nligne = 1;
    while (!TC.finEntree()) {
      for (String mot : TC.lireLigne().split("[ .,:;!?()\\[\\]\"]+"))
        ajouterOccurrence(mot, nligne);
      nligne++;
    }
  }

  // Les méthodes ci-dessus sont données, vous ne devez pas les modifier.

  // Exercice 1

  public int hauteur() {
    if(this.racine==null)
    	return 0;
    else
    	return this.racine.hauteur();
    
  }

  // Exercice 2

  public ListeEntiers chercher(String w) {
    throw new Error("classe ABR : completer la methode chercher");
  }

  // Exercice 3

  public boolean estValide() {
    throw new Error("classe ABR : completer la methode estValide");
  }

  // Exercice 4

  public void ajouterOccurrence(String w, int n) {
    throw new Error("classe ABR : completer la methode ajouterOccurrence");
  }

  // Exercice 5

  public void imprimer(String nom) {
    // La ligne qui suit indique dans quel fichier écrire.
    TC.ecritureDansNouveauFichier(nom + ".index");
    //
    // completer ici
    //
    // Une fois les écritures dans le fichier terminées,
    // on revient à la sortie standard, c'est-à-dire l'écran.
    TC.ecritureSortieStandard();
    throw new Error("classe ABR : completer ci-dessus la methode imprimer");
  }

  // Exercice 6

  public ListeEntrees liste() {
    throw new Error("classe ABR: Ecrire la methode d'objet liste.");
  }
}
