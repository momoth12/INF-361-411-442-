import java.math.BigInteger;

/**
 * @author Luca Castelli Aleardi (INF311, 2015)
 *
 * Calcul rapide (avec multiplication matricielle) de la suite de Fibonacci
 *
 */
public class FibonacciMatrice implements Fibonacci {

	/** Choix de l'implantation pour le calcul de la puissance n-ième d'une matrice 2x2 */
	Puissance algoPuissance;

	/** Compteur d'opérations */
	private long opCount;

	public FibonacciMatrice(Puissance algo) {
		this.algoPuissance = algo;
	}

	/**
	 * Calcul rapide,
	 * [1 1]^n   [F(n+1) F(n)  ]
	 * [1 0]   = [F(n)   F(n-1)]
	 *
	 *  @param n le rang du nombre à calculer
	 *  @return F(n)
	 */
	public BigInteger fibo(int n) {
		throw new Error("A completer");
	}

	/**
	 * Renvoie le type d'algorithme implanté pour calculer F(n)
	 *
	 *  @return le nom de l'algorithme implanté
	 */
	public String name() {
		return "FibonacciMatrice "+algoPuissance.name();
	}

	/**
	 * Renvoie le nombre d'opérations effectuées par cet algorithme
	 * de calcul de la suite de Fibonacci depuis sa création. Chaque
	 * addition ou multiplication de grands entiers compte pour une
	 * opération ; on néglige le reste.
	 *
	 *   @return le nombre d'additions/multiplications
	 */
	public long operations() {
		return opCount;
	}

}
