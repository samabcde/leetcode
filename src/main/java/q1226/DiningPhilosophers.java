package q1226;

class DiningPhilosophers {
	private boolean[] forkLocked = new boolean[5];
	private int[][] forkNeeded = new int[][] { new int[] { 4, 0 }, new int[] { 0, 1 }, new int[] { 1, 2 },
			new int[] { 2, 3 }, new int[] { 3, 4 } };

	public DiningPhilosophers() {
	}

	// call the run() method of any runnable to execute its code
	public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
			Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
		waitAndLockForks(philosopher);
		pickLeftFork.run();
		pickRightFork.run();
		eat.run();

		putLeftFork.run();
		putRightFork.run();
		unlockForks(philosopher);
	}

	private void waitAndLockForks(int philosopher) throws InterruptedException {
		while (true) {
			int leftFork = forkNeeded[philosopher][0];
			int rightFork = forkNeeded[philosopher][1];
			synchronized (forkLocked) {
				if (!forkLocked[leftFork] && !forkLocked[rightFork]) {
					forkLocked[leftFork] = true;
					forkLocked[rightFork] = true;
					return;
				}
			}
			Thread.sleep(0);
		}
	}

	private void unlockForks(int philosopher) {
		int leftFork = forkNeeded[philosopher][0];
		int rightFork = forkNeeded[philosopher][1];
		synchronized (forkLocked) {
			forkLocked[leftFork] = false;
			forkLocked[rightFork] = false;
		}
		return;
	}
}