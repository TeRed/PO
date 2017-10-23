package lab4.e4;

public class ROT11 implements Algorithm {
    @Override
    public String crypt(String in) {
        String cryptedString = new String();
        for(int i = 0; i < in.length(); i++) {
            int charValue = in.charAt(i) + 11;
            if(charValue > 90 && charValue <= 101) charValue -= 26;
            else if(charValue > 122) charValue -= 26;

            cryptedString += (char)charValue;
        }
        return cryptedString;
    }

    @Override
    public String decrypt(String in) {
        String cryptedString = new String();
        for(int i = 0; i < in.length(); i++) {
            int charValue = in.charAt(i) - 11;
            if(charValue < 97 && charValue >= 86) charValue += 26;
            else if(charValue < 65) charValue += 26;

            cryptedString += (char)charValue;
        }
        return cryptedString;
    }
}
