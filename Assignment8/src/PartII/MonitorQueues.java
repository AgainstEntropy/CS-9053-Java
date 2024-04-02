package PartII;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MonitorQueues implements Runnable {

	Queue<String> stringQueue;
	Map<Character, Integer> letterCount;

	private Consumer c1;
	private Consumer c2;
	private Producer p;
	private static final int DELAY = 10;

	public MonitorQueues() {
		// stringQueue = new LinkedList<String>();
		stringQueue = new ConcurrentLinkedQueue<String>();
		letterCount = new HashMap<Character, Integer>();
		p = new Producer(stringQueue);
		// m1 = new StringMiddleMan(stringQueue, stringQueue);
		// m2 = new StringMiddleMan(generalPurposeQueue, stringQueue);
		c1 = new Consumer(stringQueue, letterCount);
		c2 = new Consumer(stringQueue, letterCount);

	}

	@Override
	public void run() {
		Thread producerThread = new Thread(p);
		producerThread.start();
		Thread consumerThread1 = new Thread(c1);
		consumerThread1.start();
		Thread consumerThread2 = new Thread(c2);
		consumerThread2.start();

		while (producerThread.isAlive()) {

			if (stringQueue.size() > Producer.MAX_QUEUE_SIZE) {
				System.out.println("Alert. Input Queue > " + Producer.MAX_QUEUE_SIZE + ". Shouldn't happen");
			}

			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		while (stringQueue.size() > 0) {
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("complete");
		int sum = 0;
		for (Character c : letterCount.keySet()) {
			System.out.println(c + ": " + letterCount.get(c));
			sum += letterCount.get(c);
		}
		System.out.println("count is " + sum);
		if (stringQueue.size() == 0) {
			System.out.println("stopping consumers");
			consumerThread1.interrupt();
			consumerThread2.interrupt();
		} else {
			System.out.println("consumers still running");
		}

	}

	public static void main(String[] args) {
		MonitorQueues mq = new MonitorQueues();
		Thread t = new Thread(mq);
		t.start();
	}
}
