package designpattern.behavioral;

import java.util.*;

import designpattern.util.BasedPattern;

public class Command implements BasedPattern {
	@Override
	public void TestPattern() {
		ImageService service = new ImageService();
		service.addCommand("AEffect", new AEffectCommand());
		service.addCommand("BEffect", new BEffectCommand());
		service.addCommand("CEffect", new CEffectCommand());

		service.doEffect("AEffect");
		service.doEffect("BEffect");
		service.doEffect("CEffect");
	}

	interface Drawing {
		void processSome();

		void processOther();

		void processAnother();
	}

	class DrawingImpl implements Drawing {
		public void processSome() {
			System.out.println("Process some");
		}

		public void processOther() {
			System.out.println("Process other");
		}

		public void processAnother() {
			System.out.println("Process another");
		}
	}

	interface ICommand {
		void execute(Drawing drawing);
	}

	class ImageService {
		private Map<String, ICommand> commands = new HashMap<String, ICommand>();
		private Drawing drawing = new DrawingImpl();

		void addCommand(String effect, ICommand command) {
			commands.put(effect, command);
		}

		void doEffect(String effect) {
			commands.get(effect).execute(drawing);
		}
	}

	class AEffectCommand implements ICommand {
		public void execute(Drawing drawing) {
			System.out.println("Do A effect");
			drawing.processSome();
			drawing.processOther();
		}
	}

	class BEffectCommand implements ICommand {
		public void execute(Drawing drawing) {
			System.out.println("Do B effect");
			drawing.processOther();
			drawing.processAnother();
		}
	}

	class CEffectCommand implements ICommand {
		public void execute(Drawing drawing) {
			System.out.println("Do C effect");
			drawing.processOther();
			drawing.processSome();
			drawing.processAnother();
		}
	}
}
