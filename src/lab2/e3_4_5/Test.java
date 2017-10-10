package lab2.e3_4_5;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        List<Punkt3D> lista = new LinkedList<Punkt3D>();
        char key = '0';
        Scanner s = new Scanner(System.in);
        while(key != '4') {
            key = s.next().charAt(0);
            switch (key) {
                case '1':
                    System.out.println("Podaj punkt 3D:");
                    lista.add(new Punkt3D(s.nextDouble(), s.nextDouble(), s.nextDouble()));
                    break;
                case '2':
                    for (Punkt3D p : lista) {
                        System.out.println(p.x + " " + p.y + " " + p.z);
                    }
                    break;
                case '3':
                    for (Punkt3D p : lista) {
                        System.out.println(p.distance(new Punkt3D(0,0,0)));
                    }
                    break;
                case '4':
                    break;
            }
        }
    }


}
