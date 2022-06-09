import Factories.FontFactory;
import Factories.ParserFactory;

public class Editor {
    private static Editor instance = null;
    private ParserFactory parserFactory = null;

    Editor() {
        parserFactory = new ParserFactory();
    }

    public static Editor getInstance() {
        if (instance == null) {
            instance = new Editor();
        }
        return instance;
    }

    public void parsing(String ext){
        ParserFactory parserFactory = new ParserFactory();
        FontFactory fontFactory = new FontFactory();
        if(ext.equalsIgnoreCase("c")||ext.equalsIgnoreCase("cpp")||ext.equalsIgnoreCase("py")){
            parserFactory.getParser(ext).parseOutput();
            fontFactory.getFont(ext).fontOutput();
        } else
            System.out.println("Invalid Extension Provided!");
    }
}
