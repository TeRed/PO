package lab1.e1;

public class HelloWorld {
    public static void main(String [] argv){
        System.out.print("Type your name: ");
        String name = JIn.getString();
        System.out.println("Hello World");
        System.out.println("And hello "+name);
    }
}