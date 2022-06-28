import Appetizers.FrenchFry;
import Appetizers.OnionRing;
import Burgers.BeefBurger;
import Burgers.VeggiBurger;
import Cheese.Cheese;
import Decorator.Food;
import Drinks.Water;
import Drinks.Coke;
import Drinks.Coffee;

public class OrderDemo {
    public Food prepareFood(int choice){
        switch(choice){
            case 1:
                Food beefBurger = new BeefBurger();
                Food cheeseBurger = new Cheese(beefBurger);
                Food frenchFryCheeseBurger = new FrenchFry(cheeseBurger);
                return frenchFryCheeseBurger;
            case 2:
                Food veggiBurger = new VeggiBurger();
                Food onionRingBurger = new OnionRing(veggiBurger);
                Food waterOnionRingBurger = new Water(onionRingBurger);
                return waterOnionRingBurger;
            case 3:
                veggiBurger = new VeggiBurger();
                Food frenchFryBurger = new FrenchFry(veggiBurger);
                Food cokeFrenchFryBurger = new Coke(frenchFryBurger);
                return cokeFrenchFryBurger;
            case 4:
                veggiBurger = new VeggiBurger();
                onionRingBurger = new OnionRing(veggiBurger);
                Food coffeeOnionRingBurger = new Coffee(onionRingBurger);
                Food waterCoffeeOnionRingBurger = new Water(coffeeOnionRingBurger);
                return waterCoffeeOnionRingBurger;
            case 5:
                beefBurger = new BeefBurger();
                return beefBurger;
            default:
                return null;
        }
    }
}
