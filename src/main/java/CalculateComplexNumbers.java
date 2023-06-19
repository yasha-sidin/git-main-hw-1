import Model.ComplexNumber;
import Math;

public CalculateComplexNumbers implements iCalculate<ComplexNumber> {
  ComplexNumber firstNum;
  ComplexNumber secondNum;

  public Calculate(ComplexNumber numFirst, ComplexNumber numSecond) {
    firstNum = this.numFirst;
    secondNum = this.numSecond;
  }

  @Override
  public ComplexNumber multiplication() {
    Double real = (firstNum.getReal() * secondNum.getReal()) - 
      (firstNum.getImaginary() * secondNum.getImaginary());
    Double imaginary = (firstNum.getReal() * secondNum.getImaginary()) + 
      (firstNum.getImaginary() * secondNum.getReal());
    return new ComplexNumber(real, imaginary)
  }

  @Override
  public ComplexNumber division() {
    Double a = firstNum.getReal();
    Double b = secondNum.getImaginary();
    Double c = firstNum.getReal();
    Double d = secondNum.getImaginary();
    Double real = ((a * c) + (b * d)) / (Math.pow(c, 2) + Math.pow(d, 2));
    Double imaginary =  ((b * c) - (a * d)) / (Math.pow(c, 2) + Math.pow(d, 2));
    return new ComplexNumber(real, imaginary);
  }

  @Override
  public ComplexNumber sum() {
    Double real = firstNum.getReal() + secondNum.getReal();
    Double imaginary = firstNum.getImaginary() + secondNum.getImaginary();
    return new ComplexNumber(real, imaginary);
  }
}
