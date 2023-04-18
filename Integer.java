public class Integer implements Scalar{
     private int number;
    public Integer(int number){
        this.number = number;
    }
    @Override
    public Scalar add(Scalar s) {
        
        return new Integer();
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
}
