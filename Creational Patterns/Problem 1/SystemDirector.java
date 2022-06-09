import Builders.BuilderInterface;

public class SystemDirector {
    private BuilderInterface productBuilder;

    public void Construct(BuilderInterface builder){
        this.productBuilder = builder;
        productBuilder.buildProcessor();
        productBuilder.buildDisplay();
        productBuilder.buildCommChannel();
    }


}
