import tc.TC;
public class Salt1 {
  public static void traiter() {
	  String ligne = TC.lireLigne();
	  int n = Integer.parseInt(ligne);
	  for(int i=0;i<n;i++) {
		  TC.lireLigne();
	  }
	  String l2=TC.lireLigne();
	  int s=Integer.parseInt(l2);
	  int r=0;
	  for(int j=0;j<s;j++) {
		  String u=TC.lireLigne();
		  String[] m=TC.motsDeChaine(u);
		  int k=Integer.parseInt(m[1]);
		  r=r+k;
		  if(k!=0) {
			  TC.lireLigne();}
	  }
	  String f=TC.lireLigne();
	  TC.println("Il y a "+n+" utilisateurs.");
	  TC.println("Il y a "+s+" mots de base dans le dictionnaire.");
	  TC.println("Il y a "+r+" variantes des mots de base.");
	  TC.println("Ligne finale : "+f);
	  
  }
}