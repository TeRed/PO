package lab1.e5;

import lab1.e1.JIn;

public class Main {
    public static void main(String[] args) {
        String limitString = JIn.getString();
        int limit;
        try {
            limit = Integer.parseInt(limitString);
        } catch(NumberFormatException e) {
            System.out.println("Wrong argument. Should be int number!");
            e.printStackTrace();
            return;
        }
        LiczbyPierwsze.allBelow(limit);
    }
}
