package ViewController;

import Model.ComplexNumber;


public class CalculateComplexNumbers implements iCalculate<ComplexNumber> {
    private ComplexNumber firstNum;
    private ComplexNumber secondNum;

    public CalculateComplexNumbers(ComplexNumber fcn, ComplexNumber scn) {
        this.firstNum = fcn;
        this.secondNum = scn;
    }

    @Override
    public static ComplexNumber multiplication() {
        Double real = (firstNum.getReal() * secondNum.getReal()) -
                (firstNum.getImaginary() * secondNum.getImaginary());
        Double imaginary = (firstNum.getReal() * secondNum.getImaginary()) +
                (firstNum.getImaginary() * secondNum.getReal());
        ComplexNumber result = new ComplexNumber(real, imaginary);
        return result;
    }

    @Override
    public static ComplexNumber division() {
        Double a = firstNum.getReal();
        Double b = secondNum.getImaginary();
        Double c = firstNum.getReal();
        Double d = secondNum.getImaginary();
        double v = Math.pow(c, 2) + Math.pow(d, 2);
        Double real = ((a * c) + (b * d)) / v;
        Double imaginary = ((b * c) - (a * d)) / v;
        return new ComplexNumber(real, imaginary);
    }

    @Override
    public static ComplexNumber sum() {
        Double real = firstNum.getReal() + secondNum.getReal();
        Double imaginary = firstNum.getImaginary() + secondNum.getImaginary();
        return new ComplexNumber(real, imaginary);
    }

    public void setFirstNum(ComplexNumber firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(ComplexNumber secondNum) {
        this.secondNum = secondNum;
    }
}
