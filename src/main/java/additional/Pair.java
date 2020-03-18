package additional;

public class Pair<T,K> {
    private T value0;
    private K value1;

    public Pair(T value0, K value1){
        this.value0 = value0;
        this.value1 = value1;
    }

    public T getValue0(){
        return value0;
    }

    public K getValue1(){
        return value1;
    }
}
