public class CandidatComparatorNom implements CandidatComparator {

	@Override
	public int compare(Candidat c1, Candidat c2) {
		int a=c1.nom.compareTo(c2.nom);
		if(a!=0)
			return a;
		else {
			int b=c1.prenom.compareTo(c2.prenom);
			return b;
		}
	}

}
