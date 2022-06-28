import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumCalculator implements SpaceSeparatedSumCalculator {
    CalculatorAdapter calculatorAdapter;

    @Override
    public int calculateSum(File file, String delimiter) {
        int sum = 0;
        Scanner scn = null;
        if(delimiter.equalsIgnoreCase(" ")){
            try {
                scn = new Scanner(file);
            } catch (FileNotFoundException e) {
                return Integer.MAX_VALUE;
            }
        } else {
            calculatorAdapter = new CalculatorAdapter(file, delimiter);
            try {
                scn = new Scanner(calculatorAdapter.modifiedFile);
            } catch (FileNotFoundException e) {
                return Integer.MAX_VALUE;
            }
        }
        while (scn.hasNextLine()) {
            String[] values = scn.nextLine().split(" ");
            try {
                for (String i : values) {
                    sum += Integer.parseInt(i);
                }
            } catch (Exception e) {
                System.out.println("Error while calculating sum");
                return Integer.MIN_VALUE;
            }
        }
        scn.close();
    return sum;
    }
}