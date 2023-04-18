public class IntegerScalar implements Scalar{
    private int number;
    
    public IntegerScalar(int number){
        this.number = number;
    }
    @Override
    public Scalar add(Scalar s) {
        if((int)s.getValue() == s.getValue()){
            return new IntegerScalar(this.number + (int)s.getValue());
        }
        else{
            return s.add(this);
        }
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
        return 0;
    }
    @Override
    public double getValue(){
        return this.number;
    }
    

}
