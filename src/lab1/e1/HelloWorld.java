package lab1.e1;

import java.io.IOException;

public class HelloWorld {
    public static void main(String [] argv){
        System.out.println(Integer.valueOf(128) == Integer.valueOf(128));
        System.out.print("Type your name: ");
        String name = JIn.getString();
        System.out.println("Hello World");
        System.out.println("And hello "+name);
    }
}