package Factories;

import Builders.BuilderInterface;
import Builders.DeluxeBuilder;
import Builders.OptimalBuilder;
import Builders.PoorBuilder;

public class BuilderFactory {
    public BuilderInterface getBuilder(String[] order) {
        if (order[0].equalsIgnoreCase("deluxe")) {
            return new DeluxeBuilder(order[1], Integer.parseInt(order[2]));
        } else if (order[0].equalsIgnoreCase("optimal")) {
            return new OptimalBuilder(order[1], Integer.parseInt(order[2]));
        } else if (order[0].equalsIgnoreCase("poor")) {
            return new PoorBuilder(order[1], Integer.parseInt(order[2]));
        }
        return null;
    }
}
