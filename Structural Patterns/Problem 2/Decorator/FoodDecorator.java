package Decorator;

public abstract class FoodDecorator implements Food {
    Food newFood;

    public FoodDecorator(Food newFood){
        this.newFood = newFood;
    }

    @Override
    public double foodPrice() {
        return newFood.foodPrice();
    }

    @Override
    public String foodDescription() {
        return newFood.foodDescription();
    }

}