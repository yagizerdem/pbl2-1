import java.awt.*;
import java.io.PipedReader;
import java.util.ArrayList;

public class Main {
    public static Editor  TextEditor = new Editor();
    public static void main(String[] args) throws  Exception {
        Robot r1 = new Robot();
        Robot r2 = new Robot();

        for(int i = 0  ; i < 20 ; i++){
//            String coords = SD.coordlist[i];
//            int startx = Integer.parseInt(coords.split(" ")[1]);
//            int starty = Integer.parseInt(coords.split(" ")[0]);

            Piece newPiece = new Piece();
            SD.allPieces.add(newPiece);
        }


        Utility.PrintPieces();

        while (true){
            if(SD.keypr == 1){
                Utility.ClearScreen();
                if(SD.rkey == 39){
                    if(SD.SelectedPieceID <19) SD.SelectedPieceID++;
                    Utility.PrintPieces();
                }
                else if(SD.rkey == 37){
                    if(SD.SelectedPieceID > 1) SD.SelectedPieceID--;
                    Utility.PrintPieces();
                }
                else if(SD.rkey == 10){
                    // enter
                    if(!r1.isDone) r1.BuildScreen();
                    else if(!r2.isDone) r2.BuildScreen();
                }
                else if(SD.rkey == 82){
                    // rotate r
                    Piece selected = SD.allPieces.get(SD.SelectedPieceID - 1);
                    selected.Rotate();

                    Utility.PrintPieces();
                }
                else if(SD.rkey == 77){
                    // referse m
                    Piece selected = SD.allPieces.get(SD.SelectedPieceID - 1);
                    selected.Rotate();
                    selected.Rotate();
                    Utility.PrintPieces();


                }

            }

            Utility.Clear();
            if(r1.isDone && r2.isDone) break;
        }
        Utility.ClearScreen();
        System.out.println("robot olimpics now");
        System.out.println(r1.container[0][2]);
        // robot build done olimpics noew


    }

}