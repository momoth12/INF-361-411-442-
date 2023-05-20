
public class D {
	  public static int i = 3;
	  private int j‍;
	  public D(int a, int b) {
	    i = a;
	    this.j = b‍;
	  }
	  public static int getI() {
	    return i‍;
	  }
	  public int getIJ() {
	    return i * this.j‍;
	  }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D d1 = new D(7‍,‍6);
		D d2 = new D(1‍,‍2);
		System.out.println(D.getI(‍) + " " + d1.getIJ‍() + " " + d2.getIJ(‍));


	}

}
