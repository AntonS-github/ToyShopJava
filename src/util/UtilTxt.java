package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class UtilTxt {
    public static String read(String fileName){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (!line.equals(" ")) {
                    sb.append(line).append("\n");
                }
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } return "";
    }

    public static void write(String fileName, String str) {
        try (FileWriter fw = new FileWriter(fileName, Charset.defaultCharset(),true)) {
            fw.write(str + "\n");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
