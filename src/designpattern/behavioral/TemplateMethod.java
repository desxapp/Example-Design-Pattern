package designpattern.behavioral;

import designpattern.util.BasedPattern;
import java.util.Scanner;

public class TemplateMethod implements BasedPattern {
	@Override
	public void TestPattern() {
		GuessGame game = new ConsoleGame();
		game.go();
	}

	abstract class GuessGame {
		protected String welcome;
		protected String prompt;
		protected String correct;
		protected String bigger;
		protected String smaller;

		void go() {
			message(welcome);

			int number = (int) (Math.random() * 10);
			int guess = 0;
			do {
				message(prompt);
				guess = guess();
				if (guess > number) {
					message(bigger);
				} else if (guess < number) {
					message(smaller);
				}
			} while (guess != number);

			message(correct);
		}

		protected abstract void message(String message);

		protected abstract int guess();
	}

	class ConsoleGame extends GuessGame {
		private Scanner scanner;

		ConsoleGame() {
			welcome = "welcome";
			prompt = "prompt";
			correct = "correct";
			bigger = "bigger";
			smaller = "smaller";
			scanner = new Scanner(System.in);
		}

		protected void message(String msg) {
			System.out.println(msg);
		}

		protected int guess() {
			return scanner.nextInt();
		}
	}

}