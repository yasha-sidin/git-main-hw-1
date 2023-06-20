package ViewController;

import Model.ComplexNumber;

public class CalculateComplexNumbers implements iCalculate<ComplexNumber> {
    private ComplexNumber firstNum;
    private ComplexNumber secondNum;

    /**
     * Constructor of this Calculator which set default first and second numbers
     *
     */
    public CalculateComplexNumbers() {
        this.firstNum = new ComplexNumber(0.0, 0.0);
        this.secondNum = new ComplexNumber(0.0, 0.0);
    }

    @Override
    public ComplexNumber multiplication() {
        Double real = (firstNum.getReal() * secondNum.getReal()) -
                (firstNum.getImaginary() * secondNum.getImaginary());
        Double imaginary = (firstNum.getReal() * secondNum.getImaginary()) +
                (firstNum.getImaginary() * secondNum.getReal());
        ComplexNumber result = new ComplexNumber(real, imaginary);
        return result;
    }

    @Override
    public ComplexNumber division() {
        Double a = firstNum.getReal();
        Double b = firstNum.getImaginary();
        Double c = secondNum.getReal();
        Double d = secondNum.getImaginary();
        double v = Math.pow(c, 2) + Math.pow(d, 2);
        Double real = ((a * c) + (b * d)) / v;
        Double imaginary = ((b * c) - (a * d)) / v;
        return new ComplexNumber(real, imaginary);
    }

    @Override
    public ComplexNumber sum() {
        Double real = firstNum.getReal() + secondNum.getReal();
        Double imaginary = firstNum.getImaginary() + secondNum.getImaginary();
        return new ComplexNumber(real, imaginary);
    }

    /**
     * Set new firstNum to this Calculator
     *
     * @param firstNum new firstNum for calculator
     */
    public void setFirstNum(ComplexNumber firstNum) {
        this.firstNum = firstNum;
    }

    /**
     * Set new secondNum to this Calculator
     *
     * @param secondNum new secondNum for calculator
     */
    public void setSecondNum(ComplexNumber secondNum) {
        this.secondNum = secondNum;
    }
}
