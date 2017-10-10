package lab2.e1_2.pkg2;

import lab2.e1_2.pkg1.B;

public class C extends B {
    public C(int number, String name) {
        super(number, name);
    }

    public void show() {
        //super.name = "5";
        super.number = 5;
    }
}
