public class Rational implements Scalar {
    private int numerator;
    private int denominator;

    public Rational(Double value){
       String strValue = value.toString();
       int digitsDec = strValue.length() - 1 - strValue.indexOf('.');        


       int denominator = 1;
       for(int i = 0; i < digitsDec; i++){
           value *= 10;
           denominator *= 10;
       }
       int numerator = (int) Math.round(value);

       this.numerator = numerator;
       this.denominator = denominator;
    }
    public Rational(int numerator, int denominator){
       if(denominator == 0){
              throw new IllegalArgumentException("The denomitor can't be 0!");
       }
       this.numerator = numerator;
       this.denominator = denominator;
    }

	@Override
	public Scalar add(Scalar s) {
        
        double result = this.getValue() + s.getValue();
        return new Rational(result);
	}

	@Override
	public Scalar mul(Scalar s) {
              double result = this.getValue() * s.getValue();
              return new Rational(result);
	}

	@Override
	public Scalar neg() {
              int newNumerator = this.numerator *= -1;
              return new Rational(newNumerator, this.denominator);
	}

	@Override
	public Scalar power(int exponent) {
              int newNumerator = (int)Math.pow(numerator, exponent);
              int newDenomerator = (int)Math.pow(denominator, exponent);
              return new Rational(newNumerator, newDenomerator);
	}

	@Override
	public int sign() {
              if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
                     return -1;
              return 1;
	}

	@Override
	public double getValue() {
       return (this.numerator/(double)this.denominator);
	}
    
}
