public class InsertionSort implements SortingAlgorithm {

	private Candidat[] table; // tableau a trier
	private CandidatComparator comparator; // definit la relation d'ordre

	public InsertionSort(Candidat[] table, CandidatComparator comparator) {
		this.table = table;
		this.comparator = comparator;
	}

	public void run() {
		for(int i=0;i<this.table.length-1;i++) {
			for(int j=i+1;j<this.table.length;j++) {
				if(comparator.compare(this.table[i], this.table[j])<0) {
					Candidat p;
					p=this.table[j];
					this.table[j]=this.table[i];
					this.table[i]=p;
				}
					
					
			}
		}
	}

}
