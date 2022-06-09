package Factories;
import Parsers.CParser;
import Parsers.CppParser;
import Parsers.Parser;
import Parsers.PythonParser;

public class ParserFactory {

    public Parser getParser(String parserType) {
        if(parserType.equalsIgnoreCase("c")){
            return new CParser();
        } else if (parserType.equalsIgnoreCase("cpp")){
            return new CppParser();
        } else if (parserType.equalsIgnoreCase("py")){
            return new PythonParser();
        }
        return null;
    }
}