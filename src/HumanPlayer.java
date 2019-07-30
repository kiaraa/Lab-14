import java.util.Scanner;

public class HumanPlayer extends Player {

	public HumanPlayer(String name) {
		super.setName(name);
		super.setScore(0);
	}
	
	@Override
	public Roshambo generateRoshambo(Scanner scan) {
		String userChoice = Validator.getString(scan, "Rock, paper, scissors, SHOOT!!!");
		
		if (userChoice.equalsIgnoreCase("rock")) {
			return Roshambo.ROCK;
		}
		else if (userChoice.equalsIgnoreCase("paper")) {
			return Roshambo.PAPER;
		}
		else if (userChoice.equalsIgnoreCase("scissors")) {
			return Roshambo.SCISSORS;
		}
		else {
			System.out.println("Don't you know how to play? Try again!");
			return generateRoshambo(scan);
		}
	}

}
