import tc.TC;

public class Test1 {
  public static void main(String[] args) {
    TC.lectureDansFichier("inputa.txt");
    TC.ecritureDansNouveauFichier("outputa1.txt");
    Salt1.traiter();
    TC.lectureDansFichier("inputb.txt");
    TC.ecritureDansNouveauFichier("outputb1.txt");
    Salt1.traiter();
  }
}
