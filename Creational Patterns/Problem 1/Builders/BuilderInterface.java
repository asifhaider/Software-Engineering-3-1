package Builders;

import Items.Processor;

public interface BuilderInterface {
    void buildProcessor();
    void buildDisplay();
    void buildCommChannel();
    Product getProduct();
}
