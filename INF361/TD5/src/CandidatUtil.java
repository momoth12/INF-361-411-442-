import tc.TC;

public class CandidatUtil {

	public static Candidat[] readCandidatsFromFile(String nomDuFichier) {
		TC.lectureDansFichier(nomDuFichier);
		int n=Integer.parseInt(TC.lireLigne());
		Candidat[] c=new Candidat[n];
		for(int i=0;i<n;i++) {
			c[i]=new Candidat(TC.lireLigne());
		}
		TC.lectureEntreeStandard();
		return c;
		
	}

	public static void printCandidatsTable(Candidat[] data) {
		TC.println(data.length);

		for (int i = 0; i < data.length; i++) {
			TC.println(data[i]);
		}
	}

}
