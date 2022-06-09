package Builders;

import Items.Display;
import Items.Item;

import java.util.LinkedList;

public class Product {
    private String productName;
    private double totalCost;
    private LinkedList<Items.Item> components;
    private final double applicationCost = 300.0;
    private final double yearlyCommCost = 100.0;

    public Product(String name){
        this.components = new LinkedList<Items.Item>();
        this.productName = name;
    }

    public void addItem(Items.Item item){
        this.components.add(item);
    }

    public void show(){
        System.out.println("System Configuration: " + this.productName);
        int displayNo = 0;
        for(Item item:components){
            this.totalCost += item.getPrice();
            if(item instanceof Display){
                displayNo++;
                continue;
            }
            System.out.println(item.getName() + ", Price: " + item.getPrice() + "$ x 1");
        }
        for(Item item:components){
            if(item instanceof Display) {
                System.out.println(item.getName() + ", Price: " + item.getPrice() + "$ x " + displayNo);
                break;
            }
        }
        this.totalCost += this.applicationCost;
        this.totalCost += this.yearlyCommCost;

        System.out.println("Web Based Controller Application Cost: " + this.applicationCost + "$");
        System.out.println("Yearly Communication Cost: " + this.yearlyCommCost + "$");
        System.out.println("Total Cost: " + this.totalCost + "$");
    }
}
