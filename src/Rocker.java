import java.util.Scanner;

public class Rocker extends Player {

	public Rocker() {
		super.setName("Rocky");
		super.setScore(0);
	}
	
	@Override
	public Roshambo generateRoshambo(Scanner scan) {
		return Roshambo.ROCK;
	}
	
}
