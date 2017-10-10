package lab1.e5;

public class Main {
    public static void main(String[] args) {
        LiczbyPierwsze p = new LiczbyPierwsze();

        p.all(54);
        System.out.println(p.x);

        int n = 4;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= 2*i+1; j+=2) {
                for(int k = 0; k < n-j+1; k++) System.out.print(" ");
                for (int k = 0; k < j; k++){
                    System.out.print("x");
                }
                System.out.println("");
            }

        }
    }
}
