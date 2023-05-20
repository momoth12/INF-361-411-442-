public class PaireMH {
    public final String mot, hash;

    public PaireMH(String m, String h){
	this.mot  = m;
	this.hash = h;
    }

    public PaireMH(String m){
	this.mot  = m;
	this.hash = H.hasher(m);
    }

    public String toString(){
	return this.mot + " " + this.hash;
    }
}
