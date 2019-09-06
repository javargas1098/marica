package model;

public class ComplexMatrix {
	
	private Complex[][] matrix;
	private int n, m;

	public int getN() {
		return n;
	}

	public int getM() {
		return m;
	}

	public ComplexMatrix(int n, int m) {
		matrix = new Complex[n][m];
		this.n = n;
		this.m = m;
	}
	
	public Complex getElement(int n, int m) {
		return matrix[n][m];
	}
	
	public void addToMatrix(int n, int m, Complex c) {
		matrix[n][m] = c;
	}

	public boolean isSquare (){
		if (n == m) return true;
		else return false;
	}
	
	@Override
	public String toString() {
		String matrix = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix += "  "+this.matrix[i][j]; 
			}
			matrix += "\n";
		}
		return matrix;
	}

}
