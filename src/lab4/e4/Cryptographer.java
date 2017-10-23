package lab4.e4;

import java.io.*;
import java.util.Scanner;

public class Cryptographer {
    public static void cryptfile(File inFile, File outFile, Algorithm algo) throws FileNotFoundException, IOException {
        Scanner input = new Scanner(inFile);
        FileWriter fw = new FileWriter(outFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(new FileReader(inFile));

        for(String line; (line = br.readLine()) != null; ) {
            String[] splited = line.split("\\s+");
            for(int i = 0; i < splited.length; i++) {
                bw.write(algo.crypt(splited[i]));
                if(i+1 < splited.length) bw.write(" ");
            }
            if(br.ready()) bw.write("\n");
        }
        bw.close();
        br.close();

    }
    public static void decryptfile(File inFile, File outFile, Algorithm algo) throws FileNotFoundException, IOException {
        Scanner input = new Scanner(inFile);
        FileWriter fw = new FileWriter(outFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(new FileReader(inFile));

        for(String line; (line = br.readLine()) != null; ) {
            String[] splited = line.split("\\s+");
            for(int i = 0; i < splited.length; i++) {
                bw.write(algo.decrypt(splited[i]));
                if(i+1 < splited.length) bw.write(" ");
            }
            if(br.ready()) bw.write("\n");
        }

        bw.close();
        br.close();
    }
}
