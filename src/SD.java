import java.util.ArrayList;

public class SD {

    public static int mousepr; // mouse pressed?
    public static int mousex, mousey; // mouse text coords.
    public static int keypr; // key pressed?
    public static int rkey; // key (for press/release)
    public static int rkeymod; // key modifiers
    public static int capslock = 0; // 0:off 1:on

    public  static  int SelectedPieceID = 1;



    public static ArrayList<Piece> allPieces = new ArrayList<>();
    public static String[] coordlist = {"0 0","0 17" ,"0 34" ,"0 51","17 0","17 17" ,"17 34" ,"17 51",
            "34 0","34 12" ,"34 24" ,"34 36","34 48 ",
            "46 0","46 7" ,"46 14" ,"46 21","46 28 ","46 35 ","46 42"
    };
}
