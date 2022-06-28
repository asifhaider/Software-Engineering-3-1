import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CalculatorAdapter {

    File modifiedFile;
    public CalculatorAdapter(File file, String delimiter) {
        String oldContent = "";
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }

            String newContent = oldContent.replaceAll(delimiter, " ");

            FileWriter writer = new FileWriter(file);
            writer.write(newContent);
            reader.close();
            writer.close();
        } catch (Exception e) {
            System.out.println("Error while reading file");
        }
        this.modifiedFile = file;
    }
}