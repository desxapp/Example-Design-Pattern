package designpattern.behavioral;

import java.util.Iterator;
import designpattern.util.BasedPattern;

public class Iterator_ implements BasedPattern {
	@Override
	public void TestPattern() {
		foreach(new IterableString("Character"));
		
		// Can use foreach method after JDK5
		// for(Character c : new IterableString("Character")) {
		// System.out.println(c);
		// }
	}

	public static void foreach(Iterable<Character> iterable) {
		Iterator<Character> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	class IterableString implements Iterable<Character> {
		private String original;

		public IterableString(String original) {
			this.original = original;
		}

		public Iterator<Character> iterator() {
			return new InnerIterator();
		}

		private class InnerIterator implements Iterator<Character> {
			private int index;

			public boolean hasNext() {
				return index < original.length();
			}

			public Character next() {
				Character c = original.charAt(index);
				index++;
				return c;
			}

			public void remove() {
			}
		}
	}
}
