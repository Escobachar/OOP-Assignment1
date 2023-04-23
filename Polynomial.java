import java.security.KeyStore.Entry;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer,Monomial> monomials;

    public Polynomial(Set<Monomial> monos){
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
    public Polynomial(Set<Monomial> monos1, Set<Monomial> monos2){
        TreeMap<Integer, Monomial> monoMap = new TreeMap<Integer, Monomial>();
        this.monomials = monoMap;
        for (Monomial i : monos1) {
            for(Monomial x : monos2){
                if(i.equals(x)){
                    i = i.add(x);
                }
            }
            monomials.put(i.getExponent(), i);
        }
        
    }
    
    public static Polynomial build(String input){
        return null;
    }
    
    public Polynomial add(Polynomial p){
        Set<Monomial> nodes = p.getSet();
        return new Polynomial(nodes, getSet());
    
    }

    public Polynomial mul(Polynomial p){
        Set<Monomial> nodes = p.getSet();
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
        Set<Monomial> nodes = getSet();
        Set<Monomial> newSet = new HashSet<Monomial> ();
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

        for(Monomial mono: monomials.descendingMap().values()){
            result += mono.toString()+"+";
        }
        result = result.replace("-+", "-");
        result = result.replace("+-", "-");

        if(result.charAt(0) == '+')
            result = result.substring(1);
        if(result.charAt(result.length()-1) == '+')
            result = result.substring(0, result.length()-1);
        return result;
    }

    public Set<Monomial> getSet(){
        Set<Monomial> hSet = new HashSet<Monomial>();
        for (Map.Entry<Integer, Monomial> mono : monomials.entrySet()) {
            hSet.add(mono.getValue());
            
        }
        return hSet;
    }

    
}
