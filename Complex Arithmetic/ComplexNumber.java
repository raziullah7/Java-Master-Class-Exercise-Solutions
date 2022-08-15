public class ComplexNumber {
    private double real;
    private double imaginary;

    // constructor
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // getters
    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    // complex number add methods
    public void add(double real, double imaginary) {
        this.real += real;
        this.imaginary += imaginary;
    }

    public void add(ComplexNumber complex) {
        this.real += complex.real;
        this.imaginary += complex.imaginary;
    }

    // complex number subtract methods
    public void subtract(double real, double imaginary) {
        this.real -= real;
        this.imaginary -= imaginary;
    }

    public void subtract(ComplexNumber complex) {
        this.real -= complex.getReal();
        this.imaginary -= complex.getImaginary();
    }
}
