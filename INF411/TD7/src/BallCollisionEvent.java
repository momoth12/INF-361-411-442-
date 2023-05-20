
// 3.2 COLLISION ENTRE DEUX BILLES 

public class BallCollisionEvent extends Event {
	Ball a, b;
	// @OFF
	int nbCollisionsA, nbCollisionsB;
	// @ON
	// ...
	
	BallCollisionEvent(Billiard billard, double time, Ball a, Ball b) {
		super(billard, time);
		
		this.a = a;
		this.b = b;
		// @OFF
		this.nbCollisionsA = a.nbCollisions();
		this.nbCollisionsB = b.nbCollisions();
		// @ON
		// TODO (2 lignes)
	}
	
	@Override
	boolean isValid() {
		// @OFF
		return a.nbCollisions() == nbCollisionsA && b.nbCollisions() == nbCollisionsB;
		// @ON
		// TODO (1 ligne)
		// @@ return true;
	}
	
	@Override
	void process() {
		// @OFF
		a.collideBall(b);
		billiard.predictCollisions(a);
		billiard.predictCollisions(b);
		// @ON
		// TODO (3 lignes)
	}
	// @OFF
	@Override
	void print() {
		printTime();
		System.out.printf("%s{collision {\\color%s $\\bullet$}{\\color%s $\\bullet$}}\\\\\n", (isValid()?"":"\\sout"), tikzColor(a.getColor()), tikzColor(b.getColor()));
	}
	// @ON

}

