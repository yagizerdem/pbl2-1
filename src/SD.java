import java.util.ArrayList;

public class SD {

    public static int mousepr; // mouse pressed?
    public static int mousex, mousey; // mouse text coords.
    public static int keypr; // key pressed?
    public static int rkey; // key (for press/release)
    public static int rkeymod; // key modifiers
    public static int capslock = 0; // 0:off 1:on

    public  static  int SelectedPieceID = 1;

    public static int r1In = -1;
    public static int r1Sk = -1;
    public static  int r1Sp = -1;

    public static int r2In = -1;
    public static int r2Sk = -1;
    public static  int r2Sp = -1;


    public static int c1Sk = -1;
    public static  int c1Sp = -1;
    public static int c1In = -1;

    public static int c2In = -1;
    public static int c2Sk = -1;
    public static  int c2Sp = -1;

    public static ArrayList<Piece> allPieces = new ArrayList<>();
    public static String[] coordlist = {"0 0","0 17" ,"0 34" ,"0 51","17 0","17 17" ,"17 34" ,"17 51",
            "34 0","34 12" ,"34 24" ,"34 36","34 48 ",
            "46 0","46 7" ,"46 14" ,"46 21","46 28 ","46 35 ","46 42"
    };

    public static int r1chessPoint = 0;
    public static int r1pingPongPoint = 0;
    public static int r1runPoint = 0;

    public static int r2chessPoint = 0;
    public static int r2pingPongPoint = 0;
    public static int r2runPoint = 0;

    public static int c1chessPoint = 0;
    public static int c1pingPongPoint = 0;
    public static int c1runPoint = 0;

    public static int c2chessPoint = 0;
    public static int c2pingPongPoint = 0;
    public static int c2runPoint = 0;

}
