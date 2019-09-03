/*
    Took reference from: https://www.mkyong.com/java/java-how-to-read-a-file-into-a-list/
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class readFromFile {

    /*public static void test(String[] args) {
        String FILENAME = "C:\\Users\\parva\\Desktop\\Level 7 - Save.txt";

        try {
            List list = readByJava8(FILENAME);
            //return list;
            //list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static List readByJava8(String FILENAME) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(FILENAME))) {
            result = lines.collect(Collectors.toList());
        }
        return result;
    }
}
