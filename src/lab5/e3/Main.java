package lab5.e3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if(args.length != 4) {
            System.out.println("Too much or not enough arguments!");
            return;
        }
        try {
            MicroDvdDelay.delay(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        } /*catch(IOException e) {
            e.printStackTrace();
        }*/ catch(Exception e) {
            e.printStackTrace();
        }
    }
}
