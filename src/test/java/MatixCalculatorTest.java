import calculator.MatrixCalculator;
import model.Complex;
import model.ComplexMatrix;
import model.ComplexVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatixCalculatorTest {


    @Test
    void testSumVectors(){

        //TestCase
        ComplexVector v1 = new ComplexVector(2);
        ComplexVector v2 = new ComplexVector(2);

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(4, 2);
        Complex c3 = new Complex(7, 1);
        Complex c4 = new Complex(-1, 6);

        v1.addToMatrix(0, c1);
        v1.addToMatrix(1, c2);

        v2.addToMatrix(0, c3);
        v2.addToMatrix(1, c4);

        ComplexMatrix answer = MatrixCalculator.matrixSum(v1,v2);
        ComplexMatrix answerExpected = new ComplexMatrix(2, 1);
        answerExpected.addToMatrix(0, 0, new Complex(10,5));
        answerExpected.addToMatrix(1, 0, new Complex(3,8));

        assertEquals(answerExpected, answer);
    }

    @Test
    void inverseVector(){

        //TestCase
        ComplexVector v1 = new ComplexVector(2);

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(4, 2);

        v1.addToMatrix(0, c1);
        v1.addToMatrix(1, c2);

        ComplexMatrix answer = MatrixCalculator.negation(v1);
        ComplexMatrix answerExpected = new ComplexMatrix(2, 1);
        answerExpected.addToMatrix(0, 0, new Complex(-3,-4));
        answerExpected.addToMatrix(1, 0, new Complex(-4,-2));

        assertEquals(answerExpected, answer);

    }


}
