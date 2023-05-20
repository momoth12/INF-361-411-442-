public class Homophones{

    private final PaireMH[] p;

    public Homophones(String[] homophones){
	this.p = new PaireMH[homophones.length];
	for(int i = 0; i < homophones.length; i++)
	    this.p[i] = new PaireMH(homophones[i]);
    }

    public String toString(){
	String s = "";
	for(int i = 0; i < this.p.length; i++){
	    s += this.p[i] + "\n";
	}
	return s;
    }


}
