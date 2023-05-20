import java.io.FileNotFoundException;

public class JouleGayLussac {

	public static void main(String[] args) throws FileNotFoundException {
		Billiard billiard = new GraphicalBilliard("init/joule-expansion.txt");

		// l'évolution est réversible pour les temps courts
		double t = 500;
		
		// pour les temps longs, l'évolution n'est plus réversible à cause des erreurs d'arrondis
		// double t = 200.;
		
		billiard.eventQueue.add(new ReverseTimeEvent(billiard, t));
		billiard.eventQueue.add(new StopEvent(billiard, 2*t));
		
		billiard.run();
	}
}
