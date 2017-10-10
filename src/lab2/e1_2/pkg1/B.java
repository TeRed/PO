package lab2.e1_2.pkg1;

public class B extends A {
    public B(int number, String name) {
        super(number, name);
    }

    public void show() {
        super.name = "5";
        super.number = 5;
    }
}
