import java.util.Random;

public class NuclearFusion {
	public static void main(String args[]) {
		Billiard billiard = new GraphicalBilliard();

		Random rng = new Random(0);

		// reaction en chaire rapide
		Atom.energyFusion = 0.0008;

		// reaction en chaine lente
		// Atom.energyFusion = 0.00055;

		// pas de réaction en chaine
		// Atom.energyFusion = 0.0;

		int N = 800;
		for (int i = 0; i < N; i++) {
			double x = rng.nextDouble(), y = rng.nextDouble();
			double dx = x - .5, dy = y - .5;
			double v = Math.sqrt(dx*dx+dy*dy)*120;
			double vx = -dx/v, vy = -dy/v;
			billiard.balls.add(Atom.Deuterium(x, y, vx, vy));
		}
		
		//billiard.eventQueue.add(new StopEvent(billiard, 400));

		long start = System.currentTimeMillis();
		billiard.run();
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		
		System.out.printf("Running time: %d ms", timeElapsed);

	}
}
