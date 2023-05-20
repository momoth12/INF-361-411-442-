import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

//2 PROGRAMMATION DU BILLARD

public class Billiard {

	Vector<Ball> balls;
	double currentTime;
	PriorityQueue<Event> eventQueue;

	Billiard() {
		eventQueue = new PriorityQueue<Event>();
		balls = new Vector<Ball>();
	}

	// 2.1 LA BOUCLE DES ÉVÈNEMENTS

	void eventLoop() {
		// @OFF
		while (!eventQueue.isEmpty()) {
			Event event = eventQueue.poll();

			if (event.isValid()) {
				for (Ball b : balls)
					b.forward(event.time - currentTime);

				currentTime = event.time;
				event.process();
			}
		}
		// @ON
		// TODO (7-10 lignes)
	}

	// 2.2 PRÉDICTION DES COLLISIONS

	void predictCollisions(Ball b) {
		// @OFF
		// collisions bille-bille		
		for (Ball other : balls) {
			double time = b.nextBallCollision(other);
			if (time >= 0)
				eventQueue.add(new BallCollisionEvent(this, currentTime + time, b, other));
		}

		// collisions avec les murs
		for (Direction dir : Direction.values()) {
			double time = b.nextWallCollision(dir);
			if (time >= 0)
				eventQueue.add(new WallCollisionEvent(this, currentTime + time, b, dir));
		}
		// @ON
		// TODO (~10 lignes)
	}

	void initialize() {
		// @OFF
		for (Ball b : balls) {
			predictCollisions(b);
			// eventQueue.add(new SplitEvent(this, 0.0, b));
		}
		// @ON
		// TODO (2 lignes)
	}

	void run() {
		initialize();
		eventLoop();
	}

	// Lit une configuration initiale depuis un fichier
	Billiard(String path) throws FileNotFoundException {
		this();

		Scanner input = new Scanner(new File(path));
		input.useLocale(Locale.ENGLISH); // pour que java reconnaisse "1.2" plutôt que "1,2"

		input.nextInt(); // Le premier entier contient le nombre de lignes.
							// Mais comme on utilise un tableau redimensionnable, on l'ignore.
		while (input.hasNext()) {
			double x = input.nextDouble();
			double y = input.nextDouble();
			double vx = input.nextDouble();
			double vy = input.nextDouble();
			double radius = input.nextDouble();
			double mass = input.nextDouble();
			int r = input.nextInt();
			int g = input.nextInt();
			int b = input.nextInt();

			balls.add(new Ball(x, y, vx, vy, radius, mass, new Color(r, g, b)));
		}
	}

	// @OFF
	// Enregistre la position actuelle dans un fichier
	void dump(String path) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		writer.write(String.format("%d\n", balls.size()));
		for (Ball b : balls) {
			writer.write(String.format("%g %g %g %g %g %g %d %d %d\n", b.x, b.y, b.vx, b.vy, b.radius, b.mass,
					b.getColor().getRed(), b.getColor().getGreen(), b.getColor().getRed()));
		}
		writer.close();
	}
	// @ON
}
