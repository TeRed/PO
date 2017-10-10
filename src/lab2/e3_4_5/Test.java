package lab2.e3_4_5;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        List<Punkt3D> punkty = new LinkedList<Punkt3D>();

        char key = '0';
        Scanner s = new Scanner(System.in);

        while(key != '4') {
            System.out.println(
                    "1. Wczytaj punkt 3D\n"+
                    "2. Wyświetl wszystkie punkty\n"+
                    "3. Oblicz odległość\n"+
                    "4. Zakończ\n"+
                    "?"
            );
            key = s.next().charAt(0);
            switch (key) {
                case '1':
                    System.out.println("Podaj punkt 3D:");
                    punkty.add(new Punkt3D(s.nextDouble(), s.nextDouble(), s.nextDouble()));
                    break;
                case '2':
                    for (Punkt3D p : punkty) {
                        System.out.println(p.toString());
                    }
                    break;
                case '3':
                    for (int i = 0; i < punkty.size(); i++)
                        for (int j = i+1; j < punkty.size(); j++) {
                            System.out.println(punkty.get(i).toString() + " " + punkty.get(j).toString() + " : " +
                            punkty.get(i).distance(punkty.get(j)));
                        }
            }
        }
    }
}
