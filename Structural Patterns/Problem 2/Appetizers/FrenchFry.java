package Appetizers;

import Decorator.Food;
import Decorator.FoodDecorator;

public class FrenchFry extends FoodDecorator {
    public FrenchFry(Food newFood) {
        super(newFood);
    }

    @Override
    public double foodPrice() {
        return super.foodPrice() + 80.0;
    }

    @Override
    public String foodDescription() {
        return (super.foodDescription() + ", French Fry");
    }
}
