package lab1.e5;


public class LiczbyPierwsze {
    public int x = 4;
    public void all(int lim) {
        boolean[] array = new boolean[lim];
        for (int i = 0; i < lim; i++) {
            array[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(lim); i++) {
            if(array[i] == true)
                for (int j = i*i; j < lim; j += i) {
                    array[j] = false;
                }
        }

        for (int i = 2; i < lim; i++) {
            if(array[i]) System.out.println(i);
        }
    }
}
