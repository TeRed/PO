package lab3.e1;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Reference(new LinkedList<Double>());
    }

    public static void Simple(final double var) {
//        var += 17;
    }

    public static void Reference(final List<Double> list) {
        list.add(15.6);
        list.add(4.79);
        list.remove(0);
    }
}
