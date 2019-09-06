import calculator.MatrixCalculator;
import model.Complex;
import model.ComplexMatrix;
import model.ComplexVector;

public class Test {
	
	public static void main(String[] args) {
//		ComplexMatrix m1 = new ComplexMatrix(2, 3);
//		ComplexMatrix m2 = new ComplexMatrix(3, 2);
//
//		Complex c1 = new Complex(2, 2);
//		Complex c2 = new Complex(2, 0);
//		Complex c3 = new Complex(1, -4);
//		Complex c4 = new Complex(0, 0);
//		Complex c5 = new Complex(2, 3);
//		Complex c6 = new Complex(6, 0);
//
//
//		Complex c7 = new Complex(3, 0);
//		Complex c8 = new Complex(1, 4);
//		Complex c9 = new Complex(2, 2);
//		Complex c10 = new Complex(5, 0);
//		Complex c11 = new Complex(0, 0);
//		Complex c12 = new Complex(3, 9);
//
//		m1.addToMatrix(0, 0, c1);
//		m1.addToMatrix(0, 1, c2);
//		m1.addToMatrix(0, 2, c3);
//		m1.addToMatrix(1, 0, c4);
//		m1.addToMatrix(1, 1, c5);
//		m1.addToMatrix(1, 2, c6);
//
//		m2.addToMatrix(0, 0, c7);
//		m2.addToMatrix(0, 1, c8);
//		m2.addToMatrix(1, 0, c9);
//		m2.addToMatrix(1, 1, c10);
//		m2.addToMatrix(2, 0, c11);
//		m2.addToMatrix(2, 1, c12);

		ComplexMatrix m1 = new ComplexMatrix(3, 3);
		ComplexVector v1 = new ComplexVector(3);
		ComplexVector v2 = new ComplexVector(3);

		Complex c1 = new Complex(1/2, 1/2);
		Complex c2 = new Complex(0, 1/Math.sqrt(3));
		Complex c3 = new Complex(3/(2*Math.sqrt(15)), 1/(2*Math.sqrt(15)));
		Complex c4 = new Complex(-1/2, 0);
		Complex c5 = new Complex(1/Math.sqrt(3), 0);
		Complex c6 = new Complex(4/(2*Math.sqrt(15)), 3/(2*Math.sqrt(15)));
		Complex c7 = new Complex(1/2, 0);
		Complex c8 = new Complex(0, -1/3);
		Complex c9 = new Complex(0, 5/(2*Math.sqrt(15)));

		m1.addToMatrix(0, 0, c1);
		m1.addToMatrix(0, 1, c2);
		m1.addToMatrix(0, 2, c3);
		m1.addToMatrix(1, 0, c4);
		m1.addToMatrix(1, 1, c5);
		m1.addToMatrix(1, 2, c6);
		m1.addToMatrix(2, 0, c7);
		m1.addToMatrix(2, 1, c8);
		m1.addToMatrix(2, 2, c9);

		v1.addToMatrix(0, c1);
		v1.addToMatrix(1, c2);
		v1.addToMatrix(2, c3);

		v2.addToMatrix(0, c7);
		v2.addToMatrix(1, c8);
		v2.addToMatrix(2, c9);

		System.out.println(MatrixCalculator.isUnitary(m1));
	}
}
