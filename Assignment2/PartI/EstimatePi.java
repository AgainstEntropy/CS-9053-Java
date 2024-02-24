
public class EstimatePi {

	
	public static int estimatePi() {
		int iterations = 0;
		
		double tolerance = 0.0001;
		double pi = Math.PI;

		double sum = 0;
		double pi_estimate = Math.sqrt(6.0 * sum);
		while (Math.abs(pi_estimate - pi) > tolerance) {
			iterations++;
			sum += 1.0 / Math.pow(iterations, 2);
			pi_estimate = Math.sqrt(6.0 * sum);
		}

		System.out.printf("Pi is estimated as %f after %d iterations\n", pi_estimate, iterations);
		
		return iterations;
		
	}
	
	public static void main(String[] args) {	
		estimatePi();
	}
	
}
