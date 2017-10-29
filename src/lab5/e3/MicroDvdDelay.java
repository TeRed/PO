package lab5.e3;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MicroDvdDelay {
    public static void delay(final String in, final String out, int delay, int fps) throws IOException {
        int addition = Math.round((fps * delay)/1000);
        Pattern pattern = Pattern.compile("^\\{(\\d+)}\\{(\\d+)}(.*)$");
        BufferedWriter bw = null;
        BufferedReader br = null;

        try {
            bw = new BufferedWriter(new FileWriter(new File(out)));
            br = new BufferedReader(new FileReader(new File(in)));

            for(String line; (line = br.readLine()) != null; ) {
                String x = "";
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()) {
                    if(Integer.parseInt(matcher.group(1)) >= Integer.parseInt(matcher.group(2)))
                        throw new MicroDvdStartLaterThenEndException(line);
                    bw.write("{" + (Integer.parseInt(matcher.group(1)) + addition) + "}");
                    bw.write("{" + (Integer.parseInt(matcher.group(2)) + addition) + "}");
                    bw.write(matcher.group(3));
                }
                else if(!line.equals("")){
                    throw new wrongMicroDvdLineFormatException(line);
                }
                /*if(br.ready()) */bw.write('\n');
            }
        } finally {
            if(bw != null) bw.close();
            if(br != null) br.close();
        }
    }
}
