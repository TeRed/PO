package lab1.e6;

public class PESEL {
    private String pesel;

    public PESEL(String pesel) {
        checkPesel(pesel);
        System.out.println(checkPesel(pesel));
        this.pesel = pesel;
    }

    private static boolean checkPesel(String pesel) {
        char[] cArray = pesel.toCharArray();
        int[] multiArray = {9, 7 ,3, 1};
        int controlSum = 0;

        for(int i = 0; i < 10; i++) controlSum += multiArray[i%4] * Character.getNumericValue(cArray[i]);

        return(controlSum % 10 == Character.getNumericValue(cArray[10]));
    }
}
