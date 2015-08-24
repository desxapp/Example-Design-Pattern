package designpattern.structural;

import java.util.*;
import designpattern.util.BasedPattern;

public class Composite implements BasedPattern {
	@Override
	public void TestPattern() {
		Frame logo = new Frame("The start logo.");

		Playlist playlist1 = new Playlist();
		playlist1.add(new Frame("Frame 1-1."));
		playlist1.add(new Frame("Frame 1-2."));

		Playlist playlist2 = new Playlist();
		playlist2.add(new Frame("Frame 2-1."));
		playlist2.add(new Frame("Frame 2-2."));

		Playlist all = new Playlist();
		all.add(logo);
		all.add(playlist1);
		all.add(playlist2);

		all.play();
	}

	interface Playable {
		public abstract void play();
	}

	class Frame implements Playable {
		private String image;

		Frame(String image) {
			this.image = image;
		}

		public void play() {
			System.out.println("Play " + image);
		}
	}

	class Playlist implements Playable {
		private List<Playable> list = new ArrayList<Playable>();

		public void add(Playable playable) {
			list.add(playable);
		}

		public void play() {
			for (Playable playable : list) {
				playable.play();
			}
		}
	}
}