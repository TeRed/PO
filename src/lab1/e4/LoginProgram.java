/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1.e4;
import java.io.*;
/**
 *
 * @author Szymon
 */
public class LoginProgram {
    public static void main(String[] argv){
      Login log = new Login ("ala", "makota");
	  try{
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader bfr = new BufferedReader(rd);

        System.out.println("Podaj haslo i login!!!!!!!!!!!!!!!!!!");
		String login = bfr.readLine();
        String haslo = bfr.readLine();

        /*TODO: sprawdzenie czy podane hasło i login zgadzaja sie z tymi
         przechowywanymi w obiekcie log Jeśli tak, to ma zostać
         wyswietlone "OK", jesli nie - prosze wyswietlić informacje o błedzie
         */
	  	System.out.println(log.check(login, haslo));

	  }catch(IOException e){e.printStackTrace();}

    }
}
