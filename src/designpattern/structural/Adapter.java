package designpattern.structural;

import java.util.*;
import designpattern.util.BasedPattern;

public class Adapter implements BasedPattern {

	// Object Adapter
	static class IterableString implements Iterable<Character> {
		private String str;

		IterableString(String str) {
			this.str = str;
		}

		public Iterator<Character> iterator() {
			return new Iterator<Character>() {
				private int index;

				public boolean hasNext() {
					return index < str.length();
				}

				public Character next() {
					return str.charAt(index++);
				}

				public void remove() {
					throw new RuntimeException("Not supported");
				}
			};
		}
	}
	
	@Override
	public void TestPattern() {
		String original = new String("Test foreach.");
		for (char c : new IterableString(original)) {
			System.out.println(c);
		}
	}

}
