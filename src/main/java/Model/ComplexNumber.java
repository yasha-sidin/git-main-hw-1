package Model;

public class ComplexNumber {
    private Double real;
    private Double imaginary;

    public ComplexNumber(Double real, Double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }


    public Double getReal() {
        return real;
    }

    public void setReal(Double real) {
        this.real = real;
    }

    public Double getImaginary() {
        return imaginary;
    }

    public void setImaginary(Double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        return real.toString() + imaginary.toString() + 'i';
    }
}
