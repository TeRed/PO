/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1.e4;

/**
 *
 * @author Szymon
 */
public class Login {
    private String login;
    private String password;

    /**
     *
     * @param _login login jaki dana instancja klasy będzie przechowywać
     * @param _password hasło jakie dana instancja klasy będzie przechowywać
     */
    public Login(String _login, String _password){
        login = _login;
        password = _password;
    }

    /**
     *
     * @param _login login do porównania z przechowywanym wewnątrz obiektu
     * @param _password hasło do porównania z przechowywanym wewnatrz obiektu
     * @return prawda, gdy login i hasło zgadzaja sie, fałsz gdy albo login albo hasło nie pasuje do tych rpzechowywanych przez instancję kalsy
     */
    public boolean check(String _login, String _password){
        return (_password.equals(password) && _login.equals(login));
    }

}
