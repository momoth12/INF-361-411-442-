import java.math.BigInteger;

/**
 * @author Luca Castelli Aleardi (INF311, 2015)
 *
 * Calcul iteratif (lent) de la suite de Fibonacci
 *
 */
public class FibonacciIteratif implements Fibonacci {

	/** Compteur d'opérations */
	private long opCount;

	/**
	 * Calcul iteratif,
	 * F(n):=F(n-1)+F(n-2), pour n>1
	 *
	 *  @param n le rang du nombre à calculer
	 *  @return F(n)
	 */
	public BigInteger fibo(int n) {
		opCount=0;
		BigInteger a=BigInteger.ZERO;
		BigInteger b=BigInteger.ONE;
		BigInteger c=BigInteger.ZERO;
		if(n==0)
			return(BigInteger.ZERO);
		if(n==1)
			return(BigInteger.ONE);
		else {
			for(int i=0;i<n;i++) {
				
			}
			
		}
		
		
	}

	/**
	 * Renvoie le type d'algorithme implanté pour calculer F(n)
	 *
	 *  @return le nom de l'algorithme implanté
	 */
	public String name() {
		return "Fibonacci iteratif";
	}

	/**
	 * Renvoie le nombre d'additions et multiplications de grands
	 * entiers effectuées par le dernier appel à la méthode fibo.
	 *
	 *   @return le nombre d'additions/multiplications
	 */
	public long operations() {
		return opCount;
	}

}
