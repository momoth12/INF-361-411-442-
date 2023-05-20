import java.awt.Color;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class CreateDecompressionTxt {

	// Ce programme sert à créer le fichier joule-expansion.txt
	static public void main(String[] args) throws IOException {
		Random rng = new Random(0);

		Billiard billiard = new Billiard();

		int N = 800;
		for (int i = 0; i < N; i++) {
			billiard.balls.add(new Ball(rng.nextDouble(), rng.nextDouble(), rng.nextDouble() / 100,
					rng.nextDouble() / 100, 0.005, 10., Color.BLACK));
		}

		billiard.eventQueue.add(new StopEvent(billiard, 300));
		billiard.run();

		Vector<Ball> allballs = billiard.balls, someballs = new Vector<Ball>();

		for (Ball b : allballs)
			if (b.x < .5) {
				someballs.add(b);
				b.setColor(new Color(Color.HSBtoRGB((float) b.y, 1.0f, .8f)));
			}

		billiard.balls = someballs;
		billiard.eventQueue.clear();

		billiard.dump("init/joule-expansion.txt");
	}
}
