package PartII;

import java.io.BufferedReader;
// import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
// import java.util.Random;

public class Producer implements Runnable {

	public static final int DELAY = 2;
	public static final int MAX_QUEUE_SIZE = 50;

	Queue<String> out;
	ArrayList<String> words;

	public Producer(Queue<String> out) {
		this.out = out;
		words = new ArrayList<String>();
		try {
			FileReader f = new FileReader("Assignment8/wordlist.10000.txt");
			try (BufferedReader r = new BufferedReader(f)) {
				String inLine = r.readLine();
				while (inLine != null) {
					words.add(inLine);
					inLine = r.readLine();
				}
			}
			Collections.shuffle(words);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

	}

	@Override
	public void run() {
		for (int i = 0; i < words.size(); i++) {

			try {
				String obj = words.get(i);

				// put data on the queue and don't overflow
				// the queue size
				synchronized (out) {
					while (out.size() >= MAX_QUEUE_SIZE) {
						out.wait();
					}
					out.add(obj);
					out.notifyAll();
				}

				if ((i + 1) % 1000 == 0) {
					System.out.println("put " + (i + 1) + " elements on queue");
				}

				Thread.sleep((long) (Math.random() * DELAY));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
