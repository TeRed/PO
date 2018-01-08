package lab1.e7;

public class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(2,2, 2);
        Matrix b = new Matrix(2,2, 3);

        try {
            System.out.println(a.add(b).toString());
            System.out.println(a.sub(b).toString());
            System.out.println(b.mul(a).toString());
        } catch(WrongMatrixesDimensions e) {
            e.printStackTrace();
        }
    }
}
