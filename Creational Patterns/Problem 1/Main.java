/*
 * Software Engineering Offline 2 Problem 1: Creational Design Pattern
 * Author: Md. Asif Haider
 * Date: 9 June 2022
 */

import Builders.*;

import java.util.Scanner;

public class Main {

    public static void inputPrompt(){
        System.out.println("==============================================================================");
        System.out.println("Enter the specifications of your Queue Management System! Press 'exit' to halt.");
        System.out.println("Input Format: Space Separated 3 Words, 1 Line");
        System.out.println("Package Name (Deluxe/Optimal/Poor)");
        System.out.println("Communication Channel Type (WiFi/Sim)");
        System.out.println("The Number of Display Units (2/5/12)");
        System.out.println("==============================================================================");
    }

    public static void main(String[] args) {
        inputPrompt();
        SystemDirector director = new SystemDirector();
        BuilderInterface builder;
        Product p;
        Scanner scn = new Scanner(System.in);
        while(scn.hasNextLine()){
            String input = scn.nextLine();
            if(input.equalsIgnoreCase("exit"))
                return;
            else{
                try{
                    String[] words = input.split(" ");
                    if(words[0].equalsIgnoreCase("deluxe")){
                        builder = new DeluxeBuilder(words[1], Integer.parseInt(words[2]));
                        director.Construct(builder);
                        p = builder.getProduct();
                        p.show();
                    } else if(words[0].equalsIgnoreCase("optimal")){
                        builder = new OptimalBuilder(words[1], Integer.parseInt(words[2]));
                        director.Construct(builder);
                        p = builder.getProduct();
                        p.show();
                    } else if(words[0].equalsIgnoreCase("poor")) {
                        builder = new PoorBuilder(words[1], Integer.parseInt(words[2]));
                        director.Construct(builder);
                        p = builder.getProduct();
                        p.show();
                    } else
                        System.out.println("Invalid Sales Order Name");

                } catch (Exception e){
                    System.out.println("Invalid Input Keyword");
                }
            }
            inputPrompt();
        }
    }
}
