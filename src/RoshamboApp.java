import java.util.Scanner;

public class RoshamboApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		RandomPlayer rando = new RandomPlayer();
		Rocker rocky = new Rocker();
		System.out.println("What is you name?");
		String userName = scan.nextLine();
		HumanPlayer you = new HumanPlayer(userName);
		boolean keepGoing = true;
		
		while(keepGoing) {
			Player currentOpponent = getOpponent(scan, rando, rocky);
			int winner = throwHands(scan, currentOpponent, you);
			if (winner == 1) {
				you.setScore(you.getScore() + 1);
				System.out.println("You won!");
			}
			else if (winner == 2) {
				currentOpponent.setScore(currentOpponent.getScore() + 1);
				System.out.println(currentOpponent.getName() + " won.");
			}
			else {
				System.out.println("Tie!");
			}
			keepGoing = getCont(scan);
		}
		
		System.out.println("Your score: " + you.getScore());
		System.out.println("Rocky's score: " + rocky.getScore());
		System.out.println("Rando's score: " + rando.getScore());
	
	}
	
	public static Player getOpponent(Scanner scan, RandomPlayer rando, Rocker rocky) {
		String opponent = Validator.getString(scan, "Will you play against Rocky, or Rando?");
		if (opponent.equalsIgnoreCase("rocky")) {
			return rocky;
		}
		else if (opponent.equalsIgnoreCase("rando")) {
			return rando;
		}
		else {
			System.out.println("I didn't understand you, try again.");
			return getOpponent(scan, rando, rocky);
		}
	}
	
	public static boolean getCont(Scanner scan) {
		String answer = Validator.getString(scan, "Play again? (y/n) ");
		if (answer.equalsIgnoreCase("y")){
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int throwHands(Scanner scan, Player opponent, HumanPlayer player) {
		Roshambo opponentChoice = opponent.generateRoshambo(scan);
		Roshambo userChoice = player.generateRoshambo(scan);
		int winner; //0 is a tie, 1 is the user, 2 is the computer
		if(opponentChoice == Roshambo.ROCK) {
			if (userChoice == Roshambo.ROCK) {
				winner = 0;
			}
			else if (userChoice == Roshambo.PAPER) {
				winner = 1;
			}
			else {
				winner = 2;
			}
		}
		else if (opponentChoice == Roshambo.PAPER) {
			if (userChoice == Roshambo.ROCK) {
				winner = 2;
			}
			else if (userChoice == Roshambo.PAPER) {
				winner = 0;
			}
			else {
				winner = 1;
			}
		}
		else {
			if (userChoice == Roshambo.ROCK) {
				winner = 1;
			}
			else if (userChoice == Roshambo.PAPER) {
				winner = 2;
			}
			else {
				winner = 0;
			}
		}
		return winner;
	}

}
