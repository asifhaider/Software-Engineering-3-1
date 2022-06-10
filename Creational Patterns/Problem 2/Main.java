/*
 * Software Engineering Offline 2 Problem 2: Creational Design Pattern
 * Author: Md. Asif Haider
 * Date: 9 June 2022
 */

import java.util.Scanner;

public class Main {

    public static void inputPrompt(){
        System.out.println("================================================================");
        System.out.println("Provide the Filename with proper Extension! Enter 'exit' to halt.");
        System.out.println("================================================================");
    }
    public static void main(String[] args) {
        inputPrompt();
        Editor editor = Editor.getInstance();
        Scanner scn = new Scanner(System.in);
        while(scn.hasNextLine()){
            String input = scn.nextLine();
            if(input.equalsIgnoreCase("exit"))
                return;
            try{
                String[] filename = input.split("\\.");
                editor.parsing(filename[filename.length-1]);
                inputPrompt();
            } catch (Exception e){
                System.out.println(e);
                System.out.println("Wrong Keywords!");
            }
        }
    }
}
