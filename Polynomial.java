import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer,Monomial> monomials;

    public Polynomial(Collection<Monomial> monos){
        createTreeMap(monos);
    }
    public Polynomial(Collection<Monomial> monos1, Collection<Monomial> monos2){
        monos1.addAll(monos2);
        createTreeMap(monos1);
        
    }
    private void createTreeMap(Collection<Monomial> monos){
        TreeMap<Integer, Monomial> monoMap = new TreeMap<Integer, Monomial>();
        this.monomials = monoMap;
        for(Monomial node: monos){
            Integer exp = node.getExponent(); 
            Monomial mono = node;
            if(!monomials.containsKey(exp)){
                monoMap.put(exp, mono);
            }
            else{
                monomials.put(exp, monomials.get(exp).add(mono));
            }
        }

    }
    
    public static Polynomial build(String input){
        String[] ms = input.split(" ");
        Set<Monomial> monos = new HashSet<Monomial>();
        Scalar currentScalar;
        for(int i=0; i<ms.length; i++){
            if(ms[i].indexOf('/') != -1){
                String[] divided = ms[i].split("/");
                int numerator = Integer.parseInt(divided[0]);
                int denomerator = Integer.parseInt(divided[1]);
                currentScalar = new Rational(numerator, denomerator);
                monos.add(new Monomial(i, currentScalar));
            }
            else{
                currentScalar = new IntegerScalar(Integer.parseInt(ms[i]));
                monos.add(new Monomial(i, currentScalar));
            }
        }
        return new Polynomial(monos);
    }
    
    public Polynomial add(Polynomial p){
        Collection<Monomial> nodes = p.getCollection();
        return new Polynomial(nodes, getCollection());
    
    }

    public Polynomial mul(Polynomial p){
        Collection<Monomial> nodes = p.getCollection();
        for (Monomial node : nodes) {
            Monomial mono;
            if(monomials.containsKey(node.getExponent())){

                mono = monomials.remove(node.getExponent()).mul(node);

            }
            else{
                mono = node;
            }
            monomials.put(mono.getExponent(), mono);
        }
        return this;
    }

    public Scalar evaluate(Scalar s){
        double sum = 0;
        for (Map.Entry<Integer,Monomial> node : monomials.entrySet()) {
            sum += node.getValue().evaluate(s).getValue();
        }
        if((int)s.getValue() == s.getValue()){
            return new IntegerScalar((int)sum);
        }
        return new Rational(sum);
    } 

    public Polynomial derivative(){
        Collection<Monomial> nodes = getCollection();
        Collection<Monomial> newSet = new HashSet<Monomial> ();
        for (Monomial node : nodes) {
            if(node.getExponent() == 0){
                continue;
            }
            newSet.add(node.derivative());
        }
        return new Polynomial(newSet); 
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Polynomial){
            return((Polynomial)o).monomials.equals(this.monomials);
        }
        return false;
    }

    @Override
    public String toString(){
        String result = "";
        for(Monomial mono: monomials.values()){
            result += mono.toString()+"+";
        }
        result = result.replace("-+", "-");
        result = result.replace("+-", "-");
        result = result.replace("++", "");
        if(result.charAt(0) == '+')
            result = result.substring(1);
        if(result.charAt(result.length()-1) == '+')
            result = result.substring(0, result.length()-1);
        return result;
    }

    public Collection<Monomial> getCollection(){
        Set<Monomial> hSet = new HashSet<Monomial>();
        for (Map.Entry<Integer, Monomial> mono : monomials.entrySet()) {
            hSet.add(mono.getValue());
            
        }
        return hSet;
    }

    
}
