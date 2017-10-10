package lab2.e1_2.pkg1;

public class B extends A {
    public B(int number, String name) {
        super(number, name);
    }

    private void Increment() {}
    protected void decrement() {}
    void changeName() {}

    public void checkAccess() {
        super.name = "5";
        super.number = 5;
    }
}
