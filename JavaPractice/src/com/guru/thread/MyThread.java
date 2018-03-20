package com.guru.thread;

public class MyThread extends Thread {

	private String threadName;
	private final int DELAY = 1000;

	public MyThread() {
	}

	public MyThread(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			try {
				System.out.println(threadName);
				sleep(DELAY);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}

	}

}
