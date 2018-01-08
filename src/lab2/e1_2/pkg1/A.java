package lab2.e1_2.pkg1;

public class A {
    protected int number;
    String name;

    public A(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public void callDecrement() {
        increment();
    }
    public void callChangeName() { changeName(); }
    public void callIncrement() {
        increment();
    }
    private void increment() { number++; }
    protected void decrement() { number--; }
    void changeName() { name += "A"; }
}
