
public class ReportKinematicEnergyEvent extends Event {

	ReportKinematicEnergyEvent(Billiard billiard, double time) {
		super(billiard, time);
	}

	void process() {
		
		double energy = 0;
		
		for(Ball b : billiard.balls) {
			energy += b.mass * (b.vx*b.vx + b.vy*b.vy) / 2;
		}
		
		System.out.printf("t=%f\tE=%f\n", billiard.currentTime, energy);

		billiard.eventQueue.add(new ReportKinematicEnergyEvent(billiard, time + 10.0));
	}
	
}
