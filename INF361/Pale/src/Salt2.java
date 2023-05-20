import tc.TC;
public class Salt2 {
  public static void traiter() {
	  String ligne = TC.lireLigne();
	  int n = Integer.parseInt(ligne);
	  for(int i=0;i<n;i++) {
		  TC.lireLigne();
	  }
	  TC.println("Il y a "+n+" utilisateurs.");
	  String l2=TC.lireLigne();
	  int s=Integer.parseInt(l2);
	  TC.println("Il y a "+s+" mots de base dans le dictionnaire.");
	  for(int j=0;j<s;j++) {
		  String z=TC.lireLigne();
		  String []S=TC.motsDeChaine(z);
		  PaireMH k=new PaireMH(S[0]);
		  k.toString();
		  int x=Integer.parseInt(S[1]);
		  if(x!=0) {
			  String li = TC.lireLigne();
			  String[] Li=TC.motsDeChaine(li);
	          for(int b=0;b<Li.length;b++) {
	        	  PaireMH u=new PaireMH(Li[b]);
	        	  TC.print(Li[b]);
	        	  u.toString();
	        	  
	        	  
	          }
		  }
		  
		  
		  
	  }
	  String e=TC.lireLigne();
	  TC.println("Ligne finale : "+e);
  }
}