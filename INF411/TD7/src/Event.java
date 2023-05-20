// @OFF
import java.awt.Color;
import java.util.Arrays;
// @ON

class Event implements Comparable<Event> {
	Billiard billiard;
	final double time;

	Event(Billiard billiard, double time) {
		this.billiard = billiard;
		this.time = time;
	}

	public int compareTo(Event e) {
		return Double.compare(this.time, e.time);
	}

	boolean isValid() {
		// Par défaut, un évènement n'est pas caduc
		return true;
	}

	void process() {
		// ne fait rien
	}
	// @OFF
	// Impression latex pour l'exemple de l'énoncé
	// cf ThreeBallBilliard.java
	String tikzColor(Color color) {
		return String.format("{rgb,255:red,%d;green,%d;blue,%d}", color.getRed(), color.getGreen(), color.getBlue());
	}

	void printPositions() {
		for (Ball b : billiard.balls)
			System.out.printf("\\path[fill=%s] (%f, %f) circle (%f);\n", tikzColor(b.getColor()), b.x, b.y, b.radius);
	}

	void printBefore() {
		for (Ball b : billiard.balls)
			System.out.printf("\\draw[->, very thick, dashed] (%f, %f) -- +(%f, %f);\n", b.x, b.y, b.vx, b.vy);
	}

	void printAfter() {
		for (Ball b : billiard.balls) {
			System.out.printf("\\draw[->, very thick] (%f, %f) -- +(%f, %f);\n", b.x, b.y, b.vx, b.vy);
		}
	}

	void print() {
	}
	
	void printTime() {
		System.out.print(String.format("%.5f", time).replace('.', '&') + " & ");
	}
	
	void printEQ() {
		Event[] ar = billiard.eventQueue.toArray(new Event[billiard.eventQueue.size()]);
		Arrays.sort(ar);
		for (int i = ar.length-1; i >= 0; i--)
			ar[i].print();
	}
	// @ON
}
