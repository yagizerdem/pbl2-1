import enigma.console.TextAttributes;
import enigma.console.TextWindow;
import enigma.core.Enigma;
import enigma.event.TextMouseListener;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Screen {

    public static enigma.console.Console cn = Enigma.getConsole("Text Editor", 100, 30, 16);
    public static TextWindow cnt = cn.getTextWindow();
    public static TextAttributes att0 = new TextAttributes(Color.white, Color.black); // foreground, background color
    public static TextAttributes att1 = new TextAttributes(Color.black, Color.white);
    public static TextAttributes att2 = new TextAttributes(Color.black, Color.red);
    public TextMouseListener tmlis;
    public static KeyListener klis;


    public Screen() {
    } // Screen config
}
