import Decorator.Food;

import java.util.Scanner;

public class Main {

    public static void showMenu(){
        System.out.println("=============== Choose From Order Options Below ===============");
        System.out.println("1. Beef burger with French fry and cheese");
        System.out.println("2. Veggi burger with onion rings and Bottle of Water");
        System.out.println("3. A combo meal with Veggi burger, French Fry and Coke");
        System.out.println("4. A combo meal with Veggi burger, Onion Rings, Coffee and Water");
        System.out.println("5. A beef burger only");
        System.out.println("==================== Press 0 to Exit =========================");
    }

    public static void main(String[] args) {
        OrderDemo orderDemo = new OrderDemo();
        while(true){
            showMenu();
            Scanner scn = new Scanner(System.in);
            int choice = scn.nextInt();
            if(choice==0){
                return;
            } else {
                Food food = orderDemo.prepareFood(choice);
                if(food == null){
                    System.out.println("Invalid Option. Try Again!");
                    continue;
                } else{
                    System.out.println(food.foodDescription() + "- Total Price: " + food.foodPrice());
                }
            }
        }
    }
}
