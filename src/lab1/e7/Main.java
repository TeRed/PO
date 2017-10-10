package lab1.e7;

public class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(2,3);
        Matrix b = new Matrix(3,2);

//        Matrix c = new Matrix(2,2);
//        Matrix d = new Matrix(2,2);
//
//        System.out.println(c.sub(d).toString());
//        System.out.println(c.mul(d).toString());
        System.out.println(a.mul(b).toString());
    }
}
