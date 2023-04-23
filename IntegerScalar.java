public class IntegerScalar implements Scalar{
    private int number;
    
    public IntegerScalar(int number){
        this.number = number;
    }
    private boolean isInteger(Scalar s){
       return (int)s.getValue() == s.getValue();
    }
    @Override
    public Scalar add(Scalar s) {
        if(isInteger(s)){
            return new IntegerScalar(this.number + (int)s.getValue());
        }
        else{
            return s.add(this);
        }
    }
    
    @Override
    public Scalar mul(Scalar s) {
        if(isInteger(s)){
            return new IntegerScalar(this.number*(int)s.getValue());
        }
        else{
            return s.mul(this);
        }
    }

    @Override
    public Scalar neg() {
        return new IntegerScalar(this.number*-1);
    }

    @Override
    public Scalar power(int exponent) {
        return new IntegerScalar((int)Math.pow(this.number, exponent));
    }

    @Override
    public int sign() {
        if(this.number > 0) {
            return 1;
        }
        else if (this.number == 0) {
            return 0;
        }
        else{
            return -1;
        }
    }
    @Override
    public double getValue(){
        return this.number;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Scalar){
            return ((Scalar) o).getValue() == this.number;
        }
        else{
            return false;
        }
    }
    @Override
    public String toString(){
        return String.valueOf(number);
    }

}
