package Factories;

import Fonts.CFont;
import Fonts.CppFont;
import Fonts.Font;
import Fonts.PythonFont;

public class FontFactory {
    
    public Font getFont(String fontType){
        if(fontType.equalsIgnoreCase("c")){
            return new CFont();
        } else if(fontType.equalsIgnoreCase("cpp")){
            return new CppFont();
        } else if (fontType.equalsIgnoreCase("py")){
            return new PythonFont();
        }
        return null;
    }
}
