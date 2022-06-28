package Burgers;

public class BeefBurger extends Burger{
    @Override
    public double foodPrice() {
        return 300.0;
    }

    @Override
    public String foodDescription() {
        return "Beef Burger";
    }
}