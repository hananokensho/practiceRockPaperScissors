import java.util.*;

public class Pair {
    List<Integer> pairSignal = Arrays.asList(1,2,3);
    private int mySignal;

    public void setMySignal(){
        Collections.shuffle(pairSignal);
        this.mySignal = pairSignal.get(1);
    }

    public int getMySignal() {
        return mySignal;
    }

}
