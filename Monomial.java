public class Monomial {
    private int exponent;
    private Scalar coefficient;
    public Monomial(int exponent, Scalar coefficient){
        this.exponent=exponent;
        this.coefficient=coefficient;
    }
    private boolean isInteger(Scalar s){
        return (int)s.getValue() == s.getValue();
    }
    public Monomial add(Monomial m){
        if(m.exponent!=this.exponent){
            return null;
        }
        else{
            return new Monomial(this.exponent,coefficient.add(m.coefficient));
        }
    }
    public Monomial mul(Monomial m){
        return new Monomial(this.exponent+m.exponent, this.coefficient.mul(m.coefficient));
    }
    public Scalar evaluate(Scalar s){
            return s.power(this.exponent).mul(this.coefficient);
    }
    public Monomial derivative(){
        return new Monomial(this.exponent-1,this.coefficient.mul(new IntegerScalar(this.exponent)));
    }
    public int sign(){
        return this.coefficient.sign();
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Monomial){
            return this.coefficient == ((Monomial) o).coefficient & this.exponent == ((Monomial) o).exponent;
        }
        else{
            return false;
        }
    }
}
