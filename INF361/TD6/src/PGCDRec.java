public class PGCDRec {
	public static int pgcd(int a, int b) {
		if(b==0)
			return a;
		else if(a>=b)
			return pgcd(b,a%b);
		else 
			return  pgcd (b,a);
		
		
	}
}
