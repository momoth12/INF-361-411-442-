import java.util.LinkedList;

import tc.TC;

public class Noeud {

  private final Entree contenu;
  public Noeud gauche;
  public Noeud droit;

  public Noeud(Entree e) {
    this.gauche = null;
    this.droit = null;
    this.contenu = e;
  }

  public Noeud(Noeud g, Noeud d, Entree e) {
    this.gauche = g;
    this.droit = d;
    this.contenu = e;
  }

  public Entree contenu() {
    return this.contenu;
  }

  public String toString() {
    String str = "";
    if (this.gauche != null)
      str += "(" + this.gauche + ")";
    else
      str += "*";
    str += " <- " + this.contenu + " -> ";
    if (this.droit != null)
      str += "(" + this.droit + ")";
    else
      str += "*";
    return str;
  }

  // Les methodes ci-dessus sont données, vous ne devez pas les modifier.

  // Exercice 1
  public int hauteur() {
	  
  
	  if(this.gauche==null&&this.droit==null)
	   return 1;
   if(this.gauche==null)
	   return(1+this.droit.hauteur());
   if(this.droit==null)
	   return(1+this.gauche.hauteur());
   int a=this.gauche.hauteur();
   int b=this.droit.hauteur();
   if(a>b)
	   return(1+a);
   else
	   return(1+b);
  }

  // Exercice 2
  public ListeEntiers chercher(String w) {
	  int b=this.contenu().comparer(w);
	  if(b==0)
		  return this.contenu.occurrences;
	  if(b>0) {
		  if(this.gauche==null) {
			  ListeEntiers o=new ListeEntiers();
			  return o;
		  }
			return this.gauche.chercher(w)  ;
		  
	  }
	  if(b<0) {
		  if(this.droit==null) {
			  ListeEntiers o=new ListeEntiers();
			  return o;
		  }
			return this.droit.chercher(w)  ;
		  
	  }
   
    	
    	
    
  }

  // Exercice 3
  public boolean estValide(String min, String max) {
    throw new Error("classe Noeud : completer la methode estValide");
  }

  // Exercice 4
  public void ajouterOccurrence(String w, int n) {
    throw new Error("classe Noeud : completer la methode ajouterOccurrence");
  }

  // Exercice 5
  public void imprimer() {
    throw new Error("classe Noeud : compléter la methode imprimer");
  }

  // Exercice 6
  public ListeEntrees liste() {
    throw new Error("classe Noeud : compléter la methode liste");
  }

  // Exercice 7
  public static Noeud indexerTableauTrie(Entree[] entrees, int min, int max) {
    throw new Error("classe Noeud : compléter la methode indexerTableauTrie");
  }

}
