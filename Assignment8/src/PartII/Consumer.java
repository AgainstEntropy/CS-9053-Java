package PartII;

import java.util.Map;
// import java.util.NoSuchElementException;
import java.util.Queue;

public class Consumer implements Runnable {

	public static final int DELAY = 2;
	private static int nextID = 1;
	private int id = nextID++;

	Queue<String> in;
	Map<Character, Integer> out;

	public Consumer(Queue<String> in, Map<Character, Integer> out) {
		this.in = in;
		this.out = out;
	}

	@Override
	public void run() {
		while (true) {
			// remove element from the queue
			// get the first character of the String you
			// got from the queue, and update the count in the map
			try {
				String obj;
				synchronized (in) {
					while (in.isEmpty()) {
						in.wait();
					}

					obj = in.remove();
					in.notifyAll();
				}

				char firstLetter = obj.charAt(0);
				synchronized (out) {
					out.put(firstLetter, out.getOrDefault(firstLetter, 0) + 1);
				}

				Thread.sleep((long) (Math.random() * DELAY));
			} catch (InterruptedException e) {
				// e.printStackTrace();
				System.out.println("ending consumer " + id);
				break;
			}
		}

	}

}
