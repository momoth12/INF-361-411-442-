import java.awt.Color;
import java.util.Random;

class Atom extends Ball {

	final static double massNeutron = 1.0, radiusNeutron = 0.002;
	final static Color colorNeutron = new Color(247, 195, 49);
	final static double massDeuterium = 2.0, radiusDeuterium = 0.006;
	final static Color colorDeuterium = new Color(107, 122, 143);
	final static double massHelium = 3.0, radiusHelium = radiusDeuterium * 1.415;
	final static Color colorHelium = new Color(247, 136, 47);

	static double energyActivation = 0.001;
	static double energyFusion = 0.0005;

	final static Random rng = new Random(0);

	public Atom(double x, double y, double vx, double vy, double radius, double mass, Color color) {
		super(x, y, vx, vy, radius, mass, color);
	}

	public static Atom Neutron(double x, double y, double vx, double vy) {
		return new Atom(x, y, vx, vy, radiusNeutron, massNeutron, colorNeutron);
	}

	public static Atom Helium(double x, double y, double vx, double vy) {
		return new Atom(x, y, vx, vy, radiusHelium, massHelium, colorHelium);
	}

	public static Atom Deuterium(double x, double y, double vx, double vy) {
		return new Atom(x, y, vx, vy, radiusDeuterium, massDeuterium, colorDeuterium);
	}

	@Override
	void collideBall(Ball other) {
		super.collideBall(other);

		if (mass == massDeuterium && other.mass == massDeuterium) {
			// deux atomes de deutérium

			double energy = (mass * (vx * vx + vy * vy) + other.mass * (other.vx * other.vx + other.vy * other.vy)) / 2;
			if (energy > energyActivation) {
				// fusion
				// this devient un hélium
				// other devient un neutron
				// l'énergie cinétique totale augmente
				// le moment cinétique est conservé
				
				System.out.println("Fusion!");

				double px = mass * vx + other.mass * other.vx;
				double py = mass * vy + other.mass * other.vy;
				energy += energyFusion;

				mass = massHelium;
				other.mass = massNeutron;
				radius = radiusHelium;
				other.radius = radiusNeutron;
				setColor(colorHelium);
				other.setColor(colorNeutron);

				final double totmass = massHelium + massNeutron;

				// energie dans le référentiel de masse (moment nul)
				double E = energy - (px * px + py * py) / totmass / 2;
				double u = Math.sqrt(2 * mass * other.mass * E / totmass);
				u = rng.nextBoolean() ? u : -u;

				double wx = px / totmass;
				double wy = py / totmass;
				if (rng.nextBoolean()) {
					vx = wx + u / mass;
					vy = wy;
					other.vx = wx - u / other.mass;
					other.vy = wy;
				} else {
					vx = wx;
					vy = wy + u / mass;
					other.vx = wx;
					other.vy = wy - u / other.mass;
				}
			}
		}
	}

	static public void main(String[] args) {
		GraphicalBilliard billiard = new GraphicalBilliard();

		billiard.balls.add(Atom.Deuterium(.2, .5, .1, 0.0));
		billiard.balls.add(Atom.Deuterium(.8, .5, -.1, 0.0));

		billiard.eventQueue.add(new ReportKinematicEnergyEvent(billiard, 0.0));
		billiard.eventQueue.add(new StopEvent(billiard, 10));
		billiard.run();
	}
}
