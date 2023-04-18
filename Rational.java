public class Rational implements Scalar {
    private int numerator;
    private int denominator;

    public Rational(Double value){
        int numerator;
        int denominator;
        String strValue = value.toString();
        int pointLoc = strValue.indexOf(".");
        numerator = Integer.parseInt(strValue.substring(0, pointLoc));
        denominator = Integer.parseInt(strValue.substring(pointLoc+1));
        for(int i = pointLoc; i< strValue.length(); i++){
            numerator*=10;
            denominator*=10;
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
       return null;
	}

	@Override
	public Scalar neg() {
       return null;
	}

	@Override
	public Scalar power(int exponent) {
       return null;
	}

	@Override
	public int sign() {
       return -1;
	}

	@Override
	public double getValue() {
       return (this.numerator/this.denominator);
	}
    
}
