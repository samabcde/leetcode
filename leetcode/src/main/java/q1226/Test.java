package q1226;

public class Test {
	static Runnable pickLeftFork;
	static Runnable pickRightFork;
	static Runnable eat;
	static Runnable putLeftFork;
	static Runnable putRightFork;

	public static void main(String[] args) {
		final DiningPhilosophers d = new DiningPhilosophers();
		for (int i = 0; i < 5; i++) {
			final int philosopher = i;
			Runnable run = new Runnable() {
				@Override
				public void run() {
					try {
						d.wantsToEat(philosopher, getPickLeftFork(philosopher), getPickRightFork(philosopher),
								getEat(philosopher), getPutLeftFork(philosopher), getPutRightFork(philosopher));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			Thread a = new Thread(run);
			a.start();
		}
	}

	private static Runnable getPickLeftFork(final int philosopher) {
		return new Runnable() {
			@Override
			public void run() {
				System.out.println("[" + philosopher + ", 1, 1]");
			}
		};
	}

	private static Runnable getPickRightFork(final int philosopher) {
		return new Runnable() {
			@Override
			public void run() {
				System.out.println("[" + philosopher + ", 2, 1]");
			}
		};
	}

	private static Runnable getEat(final int philosopher) {
		return new Runnable() {
			@Override
			public void run() {
				System.out.println("[" + philosopher + ", 0, 3]");
			}
		};
	}

	private static Runnable getPutLeftFork(final int philosopher) {
		return new Runnable() {
			@Override
			public void run() {
				System.out.println("[" + philosopher + ", 1, 2]");
			}
		};
	}

	private static Runnable getPutRightFork(final int philosopher) {
		return new Runnable() {
			@Override
			public void run() {
				System.out.println("[" + philosopher + ", 2, 2]");
			}
		};
	}
}