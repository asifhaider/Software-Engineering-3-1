package Burgers;

public class VeggiBurger extends Burger{
    @Override
    public double foodPrice() {
        return 150.0;
    }

    @Override
    public String foodDescription() {
        return "Veggi Burger";
    }
}