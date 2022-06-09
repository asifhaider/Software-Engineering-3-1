package Builders;

import Items.*;

public class PoorBuilder implements BuilderInterface{

    private final Product product;
    private final int displayUnitNo;
    private final String commChannel;

    public PoorBuilder(String commChannel, int displayUnitNo){
        this.product = new Product("Poor");
        this.displayUnitNo = displayUnitNo;
        this.commChannel = commChannel;
    }

    @Override
    public void buildProcessor() {
        product.addItem(new ATMega32());
    }

    @Override
    public void buildDisplay() {
        for(int i=0; i<displayUnitNo; i++)
            product.addItem(new LED());
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
