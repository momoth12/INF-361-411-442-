import java.awt.Color;

// C'est le code pour générer l'exemple de l'énoncé

class ThreeBallBilliard extends Billiard {
	
	@Override
	void eventLoop() {
		while (!eventQueue.isEmpty()) {
			Event event = eventQueue.poll();
			System.out.printf("Event at t=%f", event.time);
			
			if (!event.isValid()) {
				System.out.printf("  ... invalid\n");
				continue;
			}
			
			System.out.printf("  ... valid\n");

			double dt = event.time - currentTime;
			for (Ball b : balls)
				b.forward(dt);

			currentTime = event.time;
			event.printPositions();
			event.printBefore();
			event.process();
			event.printAfter();
			
			event.printEQ();
		}
	}

	static public void main(String[] args) {
		Billiard b = new ThreeBallBilliard();
		double sp = 1.2;
		b.balls.add(new Ball(.2, .5, .1*sp, 0*sp, .1, 1, new Color(107, 122, 143)));
		b.balls.add(new Ball(.7, .7, -0.05*sp, -.12*sp, .1, 1, new Color(247, 136, 47)));
		b.balls.add(new Ball(.75, .3, -0.05*sp, .1*sp, .1, 1, new Color(247, 195, 49)));


		b.eventQueue.add(new Event(b, 0.0));

		b.eventQueue.add(new StopEvent(b, 10.0/sp));
		b.run();
	}
}
