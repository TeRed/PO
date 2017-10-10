package lab2.e1_2.pkg1;

public class A {
    public A(int number, String name) {
        this.number = number;
        this.name = name;
    }
    public void callDecrement() {
        number--;
    }
    public void callChangeName() {
        name += "A";
    }
    public void callIncrement() {
        number++;
    }
    private void Increment() {}
    protected void decrement() {}
    void changeName() {}

    protected int number;
    String name;
}
