import java.util.Arrays;

class Fenwick {
	Fenwick left;
	Fenwick right;
	final int lo;
	final int hi;
	int acc;

	// Question 2.1

	// Constructeur
	Fenwick(int lo, int hi) {
		this.lo=lo;
		this.hi=hi;
		if(hi-lo==1) {
			
			this.right=null;
			this.left=null;
			this.acc=0;
		
		}
		else {
			int mid=(lo+hi)/2;
			this.left= new Fenwick(lo, mid);
			this.right=new Fenwick(mid, hi);
			this.acc=0;
		}
		
		
		
	}

	// Question 2.2

	// renvoie la feuille associée à l'intervalle [i,i+1[ si elle existe et null
	// sinon.
	Fenwick get(int i) {
		if(this.lo==i&&this.hi==i+1)
			return this;
		else {
			int a=(lo+hi)/2;
			if(a>i) {
				if(this.left!=null)
					return this.left.get(i);
			}
				
			else {
				if(this.right!=null)
					return this.right.get(i);
			}
			return null;
				
		}
	}

	// Question 2.3

	// augmente la valeur stockée dans la case d'indice i du tableau
	// et actualise l'arbre pour maintenir les propriétés d'un arbre de Fenwick.
	void inc(int i) {
		if(this.lo<=i && this.hi>i) {
			this.acc++;
			int a =(this.lo+this.hi)/2;
			if(this.hi-this.lo>1) {
				if(i<a)
					this.left.inc(i);
				else
					this.right.inc(i);
			}
		}
			
		
	}

	// Question 2.4

	// renvoie la somme des valeurs des cases d'indice < i
	int cumulative(int i) {
		if(i>=hi)
			return this.acc;
		if(i<=this.lo)
			return 0;
		else {
			return this.left.cumulative(i)+this.right.cumulative(i);
		}
		
		
	}

}

class CountInversions {

	// Question 3.1 :

	// implémentation naive, quadratique pour calculer le nombre d'inversions
	static int countInversionsNaive(int[] a) {
		int cpt=0;
		int i,j;
		for( i=0;i<a.length;i++) {
			for( j=0;j<a.length;j++) {
				if(i<j&&a[i]>a[j])
					cpt++;
			}
		}
		return(cpt);
	}

	// Question 3.2 :

	// une implémentation moins naive, mais supposant une plage d'éléments pas trop
	// grande espace O(max-min)

	static int countInversionsFen(int[] a) {
		if (a.length == 0||a.length==1)
			return 0;
		int min = a[0], max = a[0];
		int res=0;
		for (int x : a) {
			if (x > max)
				max = x;
			if (x < min)
				min = x;
		}
		Fenwick f=new Fenwick(min, max+1);
		int i =a.length-1;
		while(i>=0) {
			f.inc(a[i]);
			res+=f.cumulative(a[i]);
			i--;
		}
		return res;
	
	}

	// Question 3.3

	// une implémentation encore meilleure, sans rien supposer sur les éléments
	// cette fois
	static int countInversionsBest(int[] a) {
		int n = a.length;
		int[] copy = Arrays.copyOf(a, n);
		Arrays.sort(copy);
		int[] b = new int[n];
		for (int i = 0; i < n; i++)
			b[i] = Arrays.binarySearch(copy, a[i]);
		return countInversionsFen(b);
	}

}
