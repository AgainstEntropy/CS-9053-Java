package PartI;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.ArrayList;

public class LeibnizPi {

	double result;

	public LeibnizPi() {
		// TODO Auto-generated constructor stub
	}

	public void calculatePi(long steps) {
		result = 1;
		for (long i = 1; i < steps; i++) {
			result += Math.pow(-1, i) * (1.0 / ((2 * i) + 1));
		}
		result *= 4;
	}

	public double getResult() {
		return result;
	}

	private class PiCalculator implements Callable<Double> {
		long start;
		long end;
		double result;

		public PiCalculator(long start, long end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public Double call() {
			result = 0;
			for (long i = start; i < end; i++) {
				result += Math.pow(-1, i) * (1.0 / ((2 * i) + 1));
			}
			return result;
		}
	}

	public void calculatePi(long steps, int numThreads) {
		ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		ArrayList<Future<Double>> futures = new ArrayList<>();

		long stepsPerThread = steps / numThreads;

		for (int i = 0; i < numThreads; i++) {
			PiCalculator calculator = new PiCalculator(i * stepsPerThread, (i + 1) * stepsPerThread);
			futures.add(executor.submit(calculator));
		}

		result = 0;
		for (Future<Double> future : futures) {
			try {
				result += future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		result *= 4;
	}

	public static void main(String[] args) {
		LeibnizPi lpi = new LeibnizPi();
		System.out.println("Number of processors: " + Runtime.getRuntime().availableProcessors());
		int numThreads = 16;

		System.out.println("Calculating PI using Leibniz formula with " + numThreads + " threads");
		long startTime = System.currentTimeMillis();
		lpi.calculatePi(1_000_000_000, numThreads);
		long endTime = System.currentTimeMillis();

		System.out.println("The actual value of PI is " + Math.PI);
		System.out.println("result for 1,000,000,000 steps is " + lpi.getResult());
		System.out.println("error: " + Math.abs(Math.PI - lpi.getResult()));
		System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
		System.exit(0);
	}

}
