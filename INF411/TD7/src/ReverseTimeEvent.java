
class ReverseTimeEvent extends Event {

	ReverseTimeEvent(Billiard billiard, double time) {
		super(billiard, time);
	}

	@Override
	void process() {
		for (Ball b : billiard.balls) {
			b.reverseVelocity();
			billiard.predictCollisions(b);
		}
	}

}
