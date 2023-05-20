import tc.TC;
public class Test03 {

	public static void main(String[] args) {
		
		Monnaie dollar=new Monnaie("Dollar",0.93);

        	Argent a1 = new Argent(68);
		Argent a2 = new Argent(17401, dollar);

		
		TC.println("-- test toString : attend 0.68 Euro");
		TC.println(a1.toString());

		TC.println("-- test toString : attend 174.01 Dollars");
		TC.println(a2); // appel implicite de a2.toString()
	}

}
