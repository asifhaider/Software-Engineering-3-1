import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filename = "E:\\BUET 3-1\\CSE 308 SWE Lab\\Offline 3 Structural Pattern\\Problem 1\\input.txt";

        System.out.println("Please provide the appropriate delimiter to read the file!");
        Scanner scn = new Scanner(System.in);
        String delimiter = scn.nextLine();


        SumCalculator sumCalculator = new SumCalculator();
        try{
            File file = new File(filename);
            int sum = sumCalculator.calculateSum(file, delimiter);
            if(sum==Integer.MIN_VALUE){
                System.out.println("Wrong delimiter provided");
            } else if (sum == Integer.MAX_VALUE){
                System.out.println("Error while reading file");
            }
            else
                System.out.println("Calculated sum is: " + sum);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Error while reading file");
            System.out.println("Provide correct file info");
        }
    }
}