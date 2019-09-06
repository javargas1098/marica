package calculator;

import model.Complex;
import model.ComplexMatrix;
import model.ComplexVector;

import java.awt.geom.Arc2D;

public class MatrixCalculator {

    public static ComplexMatrix matrixSum(ComplexMatrix m1, ComplexMatrix m2) {
        if (m1.getN() == m2.getN() && m1.getM() == m2.getM()) {
            ComplexMatrix m3 = new ComplexMatrix(m1.getN(), m1.getM());
            for (int n = 0; n < m1.getN(); n++)
                for (int m = 0; m < m1.getM(); m++) {
                    m3.addToMatrix(n, m, Functions.CSum(m1.getElement(n, m), m2.getElement(n, m)));

                }
            return m3;
        } else {
            return null;
        }
    }

    public static ComplexMatrix matrixSubtraction(ComplexMatrix m1, ComplexMatrix m2) {
        return matrixSum(m1, negation(m2));
    }

    public static ComplexMatrix negation(ComplexMatrix m1) {
        ComplexMatrix m3 = new ComplexMatrix(m1.getN(), m1.getM());
        for (int n = 0; n < m1.getN(); n++)
            for (int m = 0; m < m1.getM(); m++) {
                m3.addToMatrix(n, m, Functions.CProduct(m1.getElement(n, m), new Complex(-1, 0)));
            }
        return m3;
    }

    public static ComplexMatrix scalarMultiplication(Complex c1, ComplexMatrix m1) {
        ComplexMatrix m3 = new ComplexMatrix(m1.getN(), m1.getM());
        for (int n = 0; n < m1.getN(); n++) {
            for (int m = 0; m < m1.getM(); m++) {
                m3.addToMatrix(n, m, Functions.CProduct(m1.getElement(n, m), c1));
            }
        }
        return m3;
    }

    public static ComplexMatrix transposedMatrix(ComplexMatrix m1) {
        ComplexMatrix m3 = new ComplexMatrix(m1.getM(), m1.getN());
        for (int n = 0; n < m1.getN(); n++) {
            for (int m = 0; m < m1.getM(); m++) {
                m3.addToMatrix(m, n, m1.getElement(n, m));
            }
        }
        return m3;
    }

    public static ComplexMatrix conjugatedMatrix(ComplexMatrix m1) {
        ComplexMatrix m3 = new ComplexMatrix(m1.getN(), m1.getM());
        for (int n = 0; n < m1.getN(); n++) {
            for (int m = 0; m < m1.getM(); m++) {
                m3.addToMatrix(n, m, Functions.Conjugate(m1.getElement(n, m)));
            }
        }
        return m3;
    }

    public static ComplexMatrix adjointMatrix(ComplexMatrix m1) {
        ComplexMatrix m3 = new ComplexMatrix(m1.getM(), m1.getN());
        for (int n = 0; n < m1.getN(); n++) {
            for (int m = 0; m < m1.getM(); m++) {
                m3.addToMatrix(m, n, Functions.Conjugate(m1.getElement(n, m)));
            }
        }
        return m3;
    }

    public static ComplexMatrix matrixMultiplication(ComplexMatrix m1, ComplexMatrix m2) {
        if (m1.getM() == m2.getN()) {
            ComplexMatrix m3 = new ComplexMatrix(m1.getN(), m2.getM());
            for (int n = 0; n < m1.getN(); n++) {
                for (int m = 0; m < m2.getM(); m++) {
                    Complex sum = new Complex(0, 0);
                    for (int k = 0; k < m1.getM(); k++) {
                        sum = Functions.CSum(sum, Functions.CProduct(m1.getElement(n, k), m2.getElement(k, m)));
                    }
                    m3.addToMatrix(n, m, sum);
                }
            }
            return m3;
        } else {
            System.out.println("Matrices de dimensiones no compatibles");
            return null;
        }
    }

    public static ComplexMatrix actionOverVector(ComplexMatrix m1, ComplexVector v1) {
        if (m1.getN() == m1.getM())
            return matrixMultiplication(m1, v1);
        else {
            System.out.println("La matriz debe ser cuadrada");
            return null;
        }
    }

    public static Complex innerProduct(ComplexMatrix m1, ComplexMatrix m2) {
        return trace(matrixMultiplication(adjointMatrix(m1), m2));
    }

    public static Complex trace(ComplexMatrix m1) {
        if (m1.isSquare()) {
            Complex sum = new Complex(0, 0);
            for (int i = 0; i < m1.getN(); i++) {
                sum = Functions.CSum(sum, m1.getElement(i, i));
            }
            return sum;
        } else {
            System.out.println("La matriz debe ser cuadrada");
            return null;
        }
    }

    public static double norm(ComplexMatrix m1) {
        return Math.sqrt(innerProduct(m1, m1).getpReal());
    }

    public static double distance(ComplexMatrix m1, ComplexMatrix m2) {
        return norm(matrixSubtraction(m1, m2));
    }

    public static boolean isHermitian(ComplexMatrix m1) {
        for (int n = 0; n < m1.getN(); n++) {
            for (int m = 0; m < m1.getM(); m++) {
                if (!m1.getElement(n, m).equals(Functions.Conjugate(m1.getElement(m, n)))) {
                   return false;
                }
            }
        }
        return true;
    }

    public static boolean isUnitary(ComplexMatrix m1){
        if (m1.isSquare()) {
            for (int n = 0; n < m1.getN(); n++) {
                for (int m = 0; m < m1.getM(); m++) {
                    Complex sum = new Complex(0, 0);
                    for (int k = 0; k < m1.getM(); k++) {
//                        System.out.println(Functions.CProduct(m1.getElement(n, k), m1.getElement(k, n)));
                        sum = Functions.CSum(sum, Functions.CProduct(m1.getElement(n, k), m1.getElement(m, k)));
                    }
                    if (sum.getpImg() == 0){
                        if (n == m) {
                            if (sum.getpReal()!=1){
                                return false;
                            }
                        }
                        else if (sum.getpReal()!=0) {
                            return false;
                        }
                    }
                    else return false;
                }
            }
            return true;
        } else {
            System.out.println("La matriz debe ser cuadrada");
            return false;
        }
    }

}
