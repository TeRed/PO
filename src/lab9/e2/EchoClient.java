package lab9.e2;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EchoClient {
    private static final int port = 3002;
    private static final String host = "glados.kis.agh.edu.pl";

    static Socket echoSocket = null;
    static PrintWriter out = null;
    static BufferedReader in = null;

    private static boolean passContains(List<String> passwordLetters, String value) {
        for(String s : passwordLetters){
            if(s.equals(value))
                return true;
        }
        return false;
    }
    public static void connect(){
        try {
            echoSocket = new Socket(host, port);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + host);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: " + host);
            System.exit(1);
        }
    }
    private static String capitalize(String s, int index) {
        return s.substring(0, index)+ s.substring(index+1, index+2).toUpperCase() + s.substring(index+2);
    }
    private static boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }
    public static void main(String[] args) throws IOException {

        List<String> list = null;
        try (BufferedReader br = new BufferedReader(new FileReader("/home/albert/PO/src/lab9/polish-dic.txt"))) {

            String line;
            int index = 0;
            list = new LinkedList<>();
            while ((line = br.readLine()) != null) {
                String clearLine = "";
                for (int i = 0; i < line.length();i++) {
                    if(line.charAt(i) == '/') break;
                    clearLine += line.charAt(i);
                }
                list.add(index, clearLine);
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] alphabet = {"a","ą","b","c","ć","d","e","ę","f","g","h","i","j","k","l","ł","m",
                "n","ń","o","ó","p","r","s","ś","t","u","w","y","z","ź","ż","x","v","q"};

        int[] answers = new int[alphabet.length];

        //Odległości dla liter
        for(int i = 0; i < answers.length; i++) {
            connect();
            answers[i] = -1;
            int lower, upper;
            System.out.println("LOGIN szymon;" + alphabet[i]);
            out.println("LOGIN szymon;" + alphabet[i]);
            String ans = in.readLine();
            System.out.println(ans);
            if(!isInteger(ans)) continue;
            lower = Integer.parseInt(ans);

            connect();
            System.out.println("LOGIN szymon;" + alphabet[i].toUpperCase());
            out.println("LOGIN szymon;" + alphabet[i].toUpperCase());
            ans = in.readLine();
            System.out.println(ans);
            if(!isInteger(ans)) continue;
            upper = Integer.parseInt(ans);

            answers[i] = lower < upper ? lower : upper;
        }


        //Długość hasła
        int passwordLength = answers[0];

        for (int x : answers) {
            if (x > passwordLength) passwordLength = x;
        }

        //Litery hasła
        List<String> passwordLetters = new ArrayList<>(30);

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == -1) continue;
            if (answers[i] < passwordLength) passwordLetters.add(alphabet[i]);
        }

        //Wyrzucanie z listy
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            s = s.toLowerCase();
            if(s.length() != passwordLength) {
                it.remove();
                continue;
            }
            for(String letter : passwordLetters) {
                if(!s.contains(letter)) {
                    it.remove();
                    break;
                }
            }
        }

        it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            s = s.toLowerCase();
            for(int i = 0; i < s.length(); i++) {
                if(!passContains(passwordLetters,  Character.toString(s.charAt(i)))) {
                    it.remove();
                    break;
                }
            }
        }

        for(int x : answers) {
            System.out.println(x);
        }
        System.out.println("Length: " + list.size());

        String id = "", password = "";
        for(String s : list) {
            int length;
            connect();
            out.println("LOGIN szymon;" + s);
            String ans = in.readLine();
            System.out.println(ans);
            if(!isInteger(ans) && ans.length() == 10) {
                id = ans;
                password = s;
                System.out.println(id + " PLUS " + password);
                break;
            }
            length = Integer.parseInt(ans);
            String copy = s;

            for(int i  = 0; i < s.length(); i++) {
                connect();
                char[] letters = copy.toCharArray();
                letters[i] = Character.toUpperCase(letters[i]);

                out.println("LOGIN szymon;" + new String(letters));
                ans = in.readLine();
                System.out.println(new String(letters) + " " + ans);
                if(!isInteger(ans) && ans.length() == 10) {
                    id = ans;
                    password = copy;
                    System.out.println(id + " PLUS " + password);
                    break;
                }
                int tmpLength = Integer.parseInt(ans);
                if(tmpLength < length) copy = new String(letters);
                length = tmpLength;
            }

        }

        out.close();
        in.close();
        echoSocket.close();
    }
}

