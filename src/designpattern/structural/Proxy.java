package designpattern.structural;

import designpattern.util.BasedPattern;

public class Proxy implements BasedPattern {
	@Override
	public void TestPattern() {
		Document doc = new Document();
		doc.scroll();
	}

	interface Graphic {
		public abstract void draw();
	}

	// Real image class.
	class Image implements Graphic {
		private String filename;
		public Image(String filename) {
			this.filename = filename;
		}

		public void draw() {
			System.out.println("Real paint the image: " + filename);
		}
	}

	// Image Proxy class, provide user some interface with Image is the same. 
	class ImageProxy implements Graphic {
		private Graphic image;
		private String filename;

		public ImageProxy(String filename) {
			this.filename = filename;
		}

		public void draw() {
			if (image == null) {
				image = new Image(filename);
			}
			image.draw();
		}
	}

	class Document {
		private Graphic image;
		public Document() {
			// Doesn't load image yet, but it have identical interface with the Image class.
			image = new ImageProxy("doc://images//test.jpg");
			System.out.println("Implement a ImageProxy object.");
		}
		
		void scroll() {
			image.draw();
		}
	}
}
