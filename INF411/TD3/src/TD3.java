class PRNG{
		int a;
		int b;
		int[] tab;
		public PRNG(int m) {
			 tab=new int[55];
			 a=-1;
			 this.b=m;
		 }
		public int getNext() {
			a++;
			if(a<55)
				tab[a]=((((((300007*a)%b+900021)*a)%b+700018)*a)%b+200007)%b;
			else
				tab[a%55]=(tab[(a-24)%55]+tab[a%55])%b;
			return(tab[a%55]);
				
		 }
		
	}
class  Network{
	PRNG prng;
	int caller;
	int callee;
	int callCount;
	public Network(int m) {
		this.caller=1;
		this.callee=m;
		this.callCount=-1;
	}
	public int getCallCount() {
		return callCount;
	}
	public int getLastCaller() {
		return caller;
	}
	public int getLastCallee() {
		return callee;
	}
	public void runUntilCall(int u) {
		do{
			caller=prng.getNext();
			callee=prng.getNext();
			if(caller!=callee)
				callCount++;
				
		}while(caller==callee||(caller!=u && callee!=u));
	}
}