package lab1.e5;

import java.util.Arrays;

public class LiczbyPierwsze {
    public static void allBelow(int lim) {
        boolean[] isPresent = new boolean[lim];
        Arrays.fill(isPresent, true);
        isPresent[0] = false;
        isPresent[1] = false;

        for (int i = 2; i <= Math.sqrt(lim); i++) {
            if(isPresent[i] == true) {
                for (int j = i*i; j < lim; j += i) isPresent[j] = false;
            }
        }

        for (int i = 0; i < lim; i++) {
            if(isPresent[i]) System.out.println(i);
        }
    }
}
