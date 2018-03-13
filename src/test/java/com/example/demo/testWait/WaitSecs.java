package com.example.demo.testWait;

public class WaitSecs {

	public static final Object o = new Object();

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (o) {
					System.err.println("gain o in thread 1 begin...." + System.currentTimeMillis());
					try {
						o.wait(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.err.println("gain o in thread 1 end....." + System.currentTimeMillis());
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (o) {
					System.err.println("gain o in thread 2 begin...." + System.currentTimeMillis());
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.err.println("gain o in thread 2 end....." + System.currentTimeMillis());
				}
			}
		}).start();
	}

}
