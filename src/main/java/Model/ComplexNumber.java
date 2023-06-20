package Model;

public class ComplexNumber {
    private Double real;
    private Double imaginary;

    /**
     * ComplexNumber constructor
     * @param real      real part of ComplexNumber
     * @param imaginary imaginary part of ComplexNumber
     */
    public ComplexNumber(Double real, Double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     *
     * @return current real part of this ComplexNumber
     */
    public Double getReal() {
        return real;
    }

    /**
     * Set new real part to this ComplexNumber
     * @param real new real part of this ComplexNumber
     */
    public void setReal(Double real) {
        this.real = real;
    }

    /**
     *
     * @return current imaginary part of this ComplexNumber
     */
    public Double getImaginary() {
        return imaginary;
    }

    /**
     *
     * @param imaginary new imaginary part of ComplexNumber
     */
    public void setImaginary(Double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        if (imaginary < 0.0) {
            return "(" + real.toString() + " " + imaginary.toString() + 'i' + ")";
        }
        if (imaginary == 0.0) {
            return real.toString();
        }
        return "(" + real.toString() + "+" + imaginary.toString() + 'i' + ")";
    }
}
