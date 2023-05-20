public class MergeSort implements SortingAlgorithm {

	private Candidat[] table; // tableau a trier
	private CandidatComparator comparator; // definit la relation d'ordre
	private Candidat[] tmp;

	public MergeSort(Candidat[] table, CandidatComparator comparator) {
		this.table = table;
		this.comparator = comparator;
		this.tmp = new Candidat[table.length];
	}

	public void run() {
		// a completer
	}

	public void merge(int left, int middle, int right) {
		// a completer
	}

}
