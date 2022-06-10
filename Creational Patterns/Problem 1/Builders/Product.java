package Builders;

import Items.Communication;
import Items.Display;
import Items.Item;
import Items.Processor;

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
        this.totalCost = 0;
    }

    public void addItem(Items.Item item){
        this.components.add(item);
    }

    public void show(){
        System.out.println("System Configuration: " + this.productName);
        String displayName = null, processorName = null;
        double displayPrice = 0, processorPrice = 0;
        for(Item item:components){
            this.totalCost += item.getPrice();
            if(item instanceof Communication){
                System.out.println(item.getName() + ", Price: " + item.getPrice() + "$ x 1");
            }
            else if(item instanceof Display){
                displayName = item.getName();
                displayPrice = item.getPrice();
            } else if(item instanceof Processor){
                processorName = item.getName();
                processorPrice = item.getPrice();
            }
        }
        int count = (components.size()-1)/2;
        System.out.println(displayName + " , Price: " + displayPrice + "$  x " + count);
        System.out.println(processorName + " , Price: " + processorPrice + "$  x " + count);
        this.totalCost += this.applicationCost;
        this.totalCost += this.yearlyCommCost;

        System.out.println("Web Based Controller Application Cost: " + this.applicationCost + "$");
        System.out.println("Yearly Communication Cost: " + this.yearlyCommCost + "$");
        System.out.println("Total Cost: " + this.totalCost + "$");
    }
}
