package Burgers;

public class ChickenBurger extends Burger{
    @Override
    public double foodPrice() {
        return 250.0;
    }

    @Override
    public String foodDescription() {
        return "Chicken Burger";
    }
}
