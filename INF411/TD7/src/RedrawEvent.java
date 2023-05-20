class RedrawEvent extends Event {

	static int frame = 0;
	static long lastFrameNanoTime = 0;

	RedrawEvent(Billiard billiard, double time) {
		super(billiard, time);
	}

	@Override
	void process() {
		frame++;
		System.out.printf("t=%f\t(%d pending events)\n", billiard.currentTime, billiard.eventQueue.size());

		StdDraw.clear();

		for (Ball b : billiard.balls)
			b.draw();

		long newNanotime = System.nanoTime();
		if(newNanotime - lastFrameNanoTime < 16666666)
			StdDraw.pause(Math.max(16, (int)((16666666 - newNanotime + lastFrameNanoTime)/1000000)));
		lastFrameNanoTime = newNanotime;
		
		StdDraw.show();

		billiard.eventQueue.add(new RedrawEvent(billiard, time + 2.));
	}
}
