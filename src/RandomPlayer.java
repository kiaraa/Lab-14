import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RandomPlayer extends Player {

	public RandomPlayer() {
		super.setName("Rando");
		super.setScore(0);
	}
	
	@Override
	public Roshambo generateRoshambo(Scanner scan) {
		int choice = ThreadLocalRandom.current().nextInt(3);
		switch(choice) {
		case 0:	return Roshambo.ROCK;
		case 1: return Roshambo.PAPER;
		case 2: return Roshambo.SCISSORS;
		default: return Roshambo.PAPER;
		}
	}

}
