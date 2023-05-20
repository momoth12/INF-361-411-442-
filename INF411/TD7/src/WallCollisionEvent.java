
// 3.1 COLLISION AVEC UNE BANDE

public class WallCollisionEvent extends Event {
	// Les champs suivants sont hérités de Event:
	// Billiard billiard;
	// final double time;

	Direction direction;
	Ball ball;
	int nbCollisions;

	WallCollisionEvent(Billiard billiard, double time, Ball ball, Direction direction) {
		super(billiard, time);
		this.ball = ball;
		this.direction = direction;
		this.nbCollisions = ball.nbCollisions();
	}

	@Override
	boolean isValid() {
		// @OFF
		return nbCollisions == ball.nbCollisions();
		// @ON
		// TODO (1 ligne)
		// @@ return true;
	}

	@Override
	void process() {
		// @OFF
		ball.collideWall(direction);
		billiard.predictCollisions(ball);
		// @ON
		// TODO (2 lignes)
	}

	// @OFF
	@Override
	void print() {
		printTime();
		System.out.printf("%s{collision {\\color%s $\\bullet$} %s}\\\\\n", (isValid() ? "" : "\\sout"),
				tikzColor(ball.getColor()), (direction == Direction.Horizontal ? "---" : "$\\vert$"));
	}
	// @ON
}