public class Test5 {

	// teste la méthode count de CountConfigurationsHashMap
	static void testCount(int n, long o) {
		System.out.print("    Calcul du nombre de grilles de taille " + n + "x" + n + " ... ");
		long startTime = System.nanoTime();
		long res = CountConfigurationsHashMap.count(n);
		long endTime = System.nanoTime();
		System.out.println(
				res + " (temps de calcul : " + String.format("%.2f", (endTime - startTime) / 1000000.0) + " ms)");
		assert (res == o) : "\nIl y a " + o + " configurations stable de taille " + n + "x" + n + ".";
		assert (n <= 2 || CountConfigurationsHashMap.memo.size() > 0) : "\nLa HashMap est vide, ce n'est pas normal.";
	}

	public static void main(String[] args) {

		// vérifie que les asserts sont activés
		if (!Test5.class.desiredAssertionStatus()) {
			System.err.println("Vous devez activer l'option -ea de la JVM");
			System.err.println("(Run As -> Run configurations -> Arguments -> VM Arguments)");
			System.exit(1);
		}

		// tests de la méthode count de CountConfigurationsHashMap
		System.out.println("Test de la méthode count(int n) de CountConfigurationsHashMap ... ");
		long[] nums = new long[] { 1L, 2L, 16L, 102L, 2030L, 60232L, 3858082L, 446672706L, 101578277384L,
				43680343039806L, 36133311325799774L };
		for (int n = 0; n <= 10; ++n) {
			testCount(n, nums[n]);
		}
		System.out.println("[OK]");
	}
}
