package lab1.e3;

import java.io.*;

public class Reader{
    public static void main(String[] argv){
        InputStreamReader rd = new InputStreamReader(System.in);
        BufferedReader bfr = new BufferedReader(rd);
        String text = "";

        System.out.print("Wpisz jakis tekst: ");
        try {
            text = bfr.readLine();
        } catch(java.lang.Throwable e) {};
        System.out.println("Wpisales: " + text);
    }
}