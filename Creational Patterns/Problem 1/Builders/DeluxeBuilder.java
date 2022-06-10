package Builders;

import Items.*;

public class DeluxeBuilder implements BuilderInterface{

    private final Product product;
    private final int displayUnitNo;
    private final String commChannel;

    public DeluxeBuilder(String commChannel, int displayUnitNo){
        this.product = new Product("Deluxe");
        this.displayUnitNo = displayUnitNo;
        this.commChannel = commChannel;
    }

    @Override
    public void buildProcessor() {
        for(int i=0; i<displayUnitNo; i++)
            product.addItem(new RaspberryPi());
    }

    @Override
    public void buildDisplay() {
        for(int i=0; i<displayUnitNo; i++)
            product.addItem(new LCD());
    }

    @Override
    public void buildCommChannel() {
        if(commChannel.equalsIgnoreCase("wifi"))
            product.addItem(new WiFi());
        else if(commChannel.equalsIgnoreCase("sim"))
            product.addItem(new SIM());
        else
            System.out.println("Invalid Communication Channel");
    }

    @Override
    public Product getProduct() {
        return this.product;
    }
}
