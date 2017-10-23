package lab4.e4;

public class Polibiusz implements Algorithm {
    private static int[][] polibiusCipherArray = {{'a','b','c','d','e'},
                                                   {'f','g','h','i','k'},
                                                   {'l','m','n','o','p'},
                                                   {'q','r','s','t','u'},
                                                   {'v','w','x','y','z'}};
    @Override
    public String crypt(String in) {
        in = in.toLowerCase();
        System.out.println(in);
        in = in.replace('j', 'i');
        System.out.println(in);
        String cryptedString = new String();
        for(int i = 0; i < in.length(); i++) {
            int charValue = in.charAt(i);
            for(int y = 0; y < 5; y++)
                for(int x = 0; x < 5; x++) {
                    if(polibiusCipherArray[y][x] == charValue) {
                        cryptedString += y;
                        cryptedString += x;
                    }
                }
        }
        return cryptedString;
    }

    @Override
    public String decrypt(String in) {
        String cryptedString = new String();
        for(int i = 0; i < in.length(); i+=2) {
            cryptedString += (char)polibiusCipherArray[Character.getNumericValue(in.charAt(i))]
                                                      [Character.getNumericValue(in.charAt(i+1))];
        }
        return cryptedString;
    }
}
