import java.util.*;

class MatrixMultiplication {
	
	public static double[][] multiply(double[][] m1, double[][] m2) {

		int N = m1.length;
		int M = m1[0].length;

		double result[][] = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		
		return result;
	}

	public static void printMatrix(double[][] matrix, String name) {
		System.out.println(name);
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println();
	}
    
    public static void main(String[] args) {
    	
    	/* just to show you what will happen:  
    	 
    	double[][] matrix = new double[4][5];
    	for (int i = 0; i< 4; i++) {
    		System.out.println(Arrays.toString(matrix[i]));
    	}
    	
    	*/
    	
    	@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
    	System.out.print("Enter two integers spearated by a space for rows and columns: ");
    	int N = input.nextInt();
		int M = input.nextInt();
		
		double[][] m1 = new double[N][M];
		double[][] m2 = new double[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				m1[i][j] = 10.0 * Math.random();
				m2[j][i] = 10.0 * Math.random();
			}
		}

		printMatrix(m1, "M1");
		printMatrix(m2, "M2");

		double[][] result = multiply(m1, m2);

		printMatrix(result, "M3");
    }
}
