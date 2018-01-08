package lab2.e1_2.pkg1;

public class B extends A {
    public B(int number, String name) {
        super(number, name);
    }

    private void increment() { number += 2; }
    protected void decrement() { number -= 2; }
    void changeName() { name += "B"; }
}
