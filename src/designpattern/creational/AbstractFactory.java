package designpattern.creational;

import designpattern.util.BasedPattern;

public class AbstractFactory implements BasedPattern {
	// Implement abstracts factory instance and test paint a rectangle.
	@Override
	public void TestPattern() {
		AbstractFactory rectangle_part = new AbstractFactory();

		// Implement a PointCornerFactory and implement these interfaces of
		// Point and Corner.
		AbstractFactory.PointCornerFactory factory = new AbstractFactory.PointCornerFactory() {
			public AbstractFactory.Point getPoint() {
				return new AbstractFactory.Point() {
					public void line(int width) {
						for (int i = 0; i < width; i++) {
							System.out.print("-");
						}
					}
				};
			}

			public AbstractFactory.Corner getCorner() {
				return new AbstractFactory.Corner() {
					public void leftUp() {
						System.out.print('+');
					}

					public void rightUp() {
						System.out.print('+');
					}

					public void leftDown() {
						System.out.print('+');
					}

					public void rightDown() {
						System.out.print('+');
					}
				};
			}
		};
		rectangle_part.getRectangle(20, 10).paint(factory);
	}

	// Like a simple factory.
	Rectangle getRectangle(int width, int height) {
		return new Rectangle(width, height);
	}

	interface PointCornerFactory {
		Point getPoint();

		Corner getCorner();
	}

	interface Point {
		void line(int width);
	}

	interface Corner {
		void leftUp();

		void rightUp();

		void leftDown();

		void rightDown();
	}

	// Paint a rectangle via these interfaces.
	class Rectangle {
		private int width;
		private int height;

		Rectangle(int width, int height) {
			this.width = width;
			this.height = height;
		}

		void paint(PointCornerFactory factory) {
			Point point = factory.getPoint();
			Corner corner = factory.getCorner();
			corner.leftUp();
			point.line(width - 2);
			corner.rightUp();
			System.out.println();
			for (int i = 0; i < height - 2; i++) {
				point.line(width);
				System.out.println();
			}
			corner.leftDown();
			point.line(width - 2);
			corner.rightDown();
			System.out.println();
		}
	}
}