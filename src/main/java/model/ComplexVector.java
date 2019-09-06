package model;

public class ComplexVector extends ComplexMatrix {

    public ComplexVector(int n) {
        super(n, 1);
    }

    public void addToMatrix(int n, Complex c) {
        super.addToMatrix(n, 0, c);
    }

}
