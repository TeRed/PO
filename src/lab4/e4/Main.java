package lab4.e4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            if(args.length != 2) {
                System.out.println("Too much or not wenough arguments!");
                return;
            }
            File in = new File(args[0]);
            File out = new File(args[1]);

            Scanner scanner = new Scanner(System.in);

            char cipherOrDecipher = '0';
            char polibiuszOrROT11 = '0';

            while(cipherOrDecipher != 'c' && cipherOrDecipher != 'd') {
                System.out.println("What you want? Cipher or Decipher? [c/d]:");
                cipherOrDecipher = scanner.next().charAt(0);
            }
            while(polibiuszOrROT11 != 'p' && polibiuszOrROT11 != 'r') {
                System.out.println("What you want? Polibiusz or ROT11? [p/r]:");
                polibiuszOrROT11 = scanner.next().charAt(0);
            }

            if(cipherOrDecipher == 'c') {
                if(polibiuszOrROT11 == 'p') Cryptographer.cryptfile(in, out, new Polibiusz());
                else Cryptographer.cryptfile(in, out, new ROT11());
            }
            else {
                if(polibiuszOrROT11 == 'p') Cryptographer.decryptfile(in, out, new Polibiusz());
                else Cryptographer.decryptfile(in, out, new ROT11());
            }

        } catch(FileNotFoundException e) {
            System.out.println("File has not been found!");
        } catch(IOException e) {
            System.out.println("IOException");
        }
    }
}
