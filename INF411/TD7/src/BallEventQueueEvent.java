import java.util.PriorityQueue;

public class BallEventQueueEvent extends Event {
	Ball ball;
	int nbCollisions;
	PriorityQueue<Event> eventQueue;

	public BallEventQueueEvent(Billiard billiard, Ball ball, PriorityQueue<Event> eventQueue) {
		super(billiard, eventQueue.peek().time);
		this.ball = ball;
		this.nbCollisions = ball.nbCollisions();
		this.eventQueue = eventQueue;
	}

	@Override
	boolean isValid() {
		// @OFF
		if (nbCollisions != ball.nbCollisions())
			return false;

		boolean discarded = false;
		while(!eventQueue.isEmpty()) {
			Event e = eventQueue.peek();
			if(e.isValid()) {
				if(discarded) {
					billiard.eventQueue.add(new BallEventQueueEvent(billiard, ball, eventQueue));
				}
				break;
			}
			discarded = true;
			eventQueue.poll();
		}
		return !discarded;
		// @ON
		// TODO
		// @@ return true;
	}

	@Override
	void process() {
		// @OFF
		while (!eventQueue.isEmpty()) {
			Event e = eventQueue.poll();
			if (!e.isValid())
				continue;
			e.process();
		}
		// @ON
		// TODO
	}

}
