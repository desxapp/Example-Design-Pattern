package designpattern.behavioral;

import designpattern.util.BasedPattern;
import java.util.*;

public class Memento implements BasedPattern {
	@Override
	public void TestPattern() {
		Application application = new Application();
		Recovery recovery = new Recovery();

		System.out.println(application.getState());

		Backup backup = application.backup();
		recovery.add(backup);

		application.setState("customer setting");
		System.out.println(application.getState());

		Date date = backup.date;
		application.recover(recovery.retrieve(date));
		System.out.println(application.getState());
	}

	class Backup {
		final String state;
		final Date date;

		Backup(String state) {
			this.state = state;
			this.date = new Date();
		}
	}

	class Application {
		private String state = "default setting";

		Backup backup() {
			return new Backup(state);
		}

		void recover(Backup backup) {
			this.state = backup.state;
		}

		void setState(String state) {
			this.state = state;
		}

		String getState() {
			return state;
		}
	}

	class Recovery {
		private List<Backup> backups = new ArrayList<Backup>();

		void add(Backup backup) {
			backups.add(backup);
		}

		Backup retrieve(Date date) {
			for (Backup backup : backups) {
				if (backup.date.equals(date)) {
					backups.remove(backup);
					return backup;
				}
			}
			return null;
		}
	}
}
