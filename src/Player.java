import java.util.Scanner;

public abstract class Player {
	private String name;
	private int score;
	
	public abstract Roshambo generateRoshambo(Scanner scan);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
