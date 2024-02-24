public class FlowRate {

	public static double calculateFlowRate(double r, double l, double eta, double deltaP) {

		double pi = Math.PI;
		double flowRate = (deltaP * pi * Math.pow(r, 4)) / (8 * eta * l);
		return flowRate;
	}
	
	public static void main(String[] args) {
		double radius = .0127;
		double length = 5;
		double eta = 8.9E-4;
		double pressureChange = 22000;
//		double dyanmicViscosity = 8.9E-4;
		
		
		double flowRate = calculateFlowRate(radius, length, eta, pressureChange);
		// convert from m^3/sec to liters/sec
		flowRate = flowRate * Math.pow(100, 3) / 1000;
		System.out.printf("The flow rate in liters/sec is: %f liters/sec\n", flowRate);

	}
}