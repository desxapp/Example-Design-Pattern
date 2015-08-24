package designpattern.structural;

import designpattern.util.BasedPattern;

public class Bridge implements BasedPattern {
	@Override
	public void TestPattern() {
		Turtle turtle = new Duke(new JavaDrawing());
		turtle.move();
		turtle.turn();
	}

	interface Turtle {
		void move();

		void turn();
	}

	interface Drawing {
		void drawImage(String image);

		void drawLine();

		void turnImage(String image);

		void rotateImage(String image);
	}

	class JavaDrawing implements Drawing {
		public void drawImage(String image) {
			System.out.println("Java 2D draw " + image);
		}

		public void drawLine() {
			System.out.println("Java 2D draw line");
		}

		public void turnImage(String image) {
			System.out.println("Java 2D turn " + image);
		}

		public void rotateImage(String image) {
			System.out.println("Java 2D rotate " + image);
		}
	}

	class Duke implements Turtle {
		private String image = "Duke";
		private Drawing drawing;

		Duke(Drawing drawing) {
			this.drawing = drawing;
		}

		public void move() {
			System.out.println("Compute the target location.");
			drawing.drawImage(image);
			drawing.drawLine();
		}

		public void turn() {
			drawing.rotateImage(image);
			drawing.drawImage(image);
		}
	}
}
