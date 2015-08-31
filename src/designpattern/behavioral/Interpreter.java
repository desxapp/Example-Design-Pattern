package designpattern.behavioral;

import designpattern.util.BasedPattern;

import java.util.*;
import java.io.*;

public class Interpreter implements BasedPattern {
	@Override
	public void TestPattern() {
		Node node = new Program();
		try {
			node.parse(new Context("B:\\sample.txt"));
			// PROGRAM
			// REPEAT 2
			// LINEBREAK
			// PRINT dog
			// BREAK
			// END
			// END
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		node.execute();
	}

	interface Node {
		void parse(Context context);

		void execute();
	}

	// <program> ::= PROGRAM <command list>
	class Program implements Node {
		private Node commandList;

		public void parse(Context context) {
			context.skipToken("PROGRAM");
			commandList = new CommandList();
			commandList.parse(context);
		}

		public void execute() {
			commandList.execute();
		}
	}

	// <command list> ::= <command>* END
	class CommandList implements Node {
		private List<Node> commands = new ArrayList<Node>();

		public void parse(Context context) {
			while (true) {
				if (context.currentToken() == null) {
					System.err.println("Missing 'END'");
					break;
				} else if (context.currentToken().equals("END")) {
					context.skipToken("END");
					break;
				} else {
					Node command = new Command();
					command.parse(context);
					commands.add(command);
				}
			}
		}

		public void execute() {
			for (Node command : commands) {
				command.execute();
			}
		}
	}

	// <command> ::= <repeat> | <primitive>
	class Command implements Node {
		private Node node;

		public void parse(Context context) {
			if (context.currentToken().equals("REPEAT")) {
				node = new Repeat();
				node.parse(context);
			} else {
				node = new Primitive();
				node.parse(context);
			}
		}

		public void execute() {
			node.execute();
		}
	}

	// <primitive> ::= PRINT <string> | SPACE | BREAK | LINEBREAK
	class Primitive implements Node {
		private String name;
		private String text;

		public void parse(Context context) {
			name = context.currentToken();
			context.skipToken(name);
			if (!(name.equals("PRINT") || name.equals("BREAK")
					|| name.equals("LINEBREAK") || name.equals("SPACE"))) {
				System.err.println("Undefined Command");
			}
			if (name.equals("PRINT")) {
				text = context.currentToken();
				context.nextToken();
			}
		}

		public void execute() {
			if (name.equals("PRINT"))
				System.out.print(text);
			else if (name.equals("SPACE"))
				System.out.print(" ");
			else if (name.equals("BREAK"))
				System.out.println();
			else if (name.equals("LINEBREAK"))
				System.out.println("\n------------------------------");
		}
	}

	class Repeat implements Node {
		private int number;
		private Node commandList;

		public void parse(Context context) {
			context.skipToken("REPEAT");
			number = context.currentNumber();
			context.nextToken();
			commandList = new CommandList();
			commandList.parse(context);
		}

		public void execute() {
			for (int i = 0; i < number; i++) {
				commandList.execute();
			}
		}
	}

	class Context {
		private Iterator<String> tokens;
		private String currentToken;

		Context(String filename) throws IOException {
			List<String> tokenList = new ArrayList<String>();
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String input = null;
			while ((input = reader.readLine()) != null) {
				for (String token : input.trim().split("\\s+")) {
					tokenList.add(token);
				}
			}
			reader.close();
			tokens = tokenList.iterator();
			nextToken();
		}

		String nextToken() {
			currentToken = null;
			if (tokens.hasNext()) {
				currentToken = tokens.next();
			}
			return currentToken;
		}

		String currentToken() {
			return currentToken;
		}

		void skipToken(String token) {
			if (!token.equals(currentToken)) {
				System.err.println("Warning: " + token + " is expected, but "
						+ currentToken + " is found.");
			}
			nextToken();
		}

		int currentNumber() {
			return Integer.parseInt(currentToken);
		}
	}
}
