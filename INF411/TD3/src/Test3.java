
public class Test3 {
	
	static final int president = 524287;
	static final int prime_minister = 359283;
	
	static void test31() {
		System.out.print("Test de la méthode runUntilConnected()... ");

		Network network = new Network(1000000);
		
		network.runUntilConnected(president, president);
		assert (network.getCallCount() == 0);
		
		network.runUntilConnected(5079, 106973);
		assert (network.getCallCount() == 5);
		assert (network.getLastCaller() == 5079);
		assert (network.getLastCallee() == 106973);
		
		network.runUntilConnected(president, prime_minister);
		assert (network.getCallCount() == 1842274);
		assert (network.getLastCaller() == 359283);
		assert (network.getLastCallee() == 792458);

		network.runUntilConnected(president, prime_minister);
		assert (network.getCallCount() == 1842274);
		assert (network.getLastCaller() == 359283);
		assert (network.getLastCallee() == 792458);
		
		System.out.println("[OK]");
	}
	
	static void test32() {
		System.out.print("Test de la méthode getContactCount()... ");

		Network network = new Network(1000000);
		network.runUntilCall(president);
		assert (network.getCallCount() == 1840579);
		assert (network.getContactCount(president) == 972133);
		
		network.runUntilCall(president);
		assert (network.getContactCount(president) == 984309);
		System.out.println("[OK]");
	}

	public static void main(String[] args) {

		// vérifie que les asserts sont activés
		if (!Test2.class.desiredAssertionStatus()) {
			System.err.println("Vous devez activer l'option -ea de la JVM");
			System.err.println("(Run As -> Run configurations -> Arguments -> VM Arguments)");
			System.exit(1);
		}
		
		test31();
		
		// à décommenter pour la question 3.2
		// (sans commenter la ligne précédente)
		//test32();

	}

}
