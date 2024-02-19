
public class Main {
    public static Screen screen = new Screen();
    public static void main(String[] args) {

//        Box newBox = new Box(10 ,1);
//        newBox.fill();
//        newBox.draw();

        Piece piece = new Piece(3 ,0 , 10);
        piece.Load(1);
        piece.Draw();

        Piece piece2 = new Piece(3 ,0 , 40);
        piece2.Load(1);
        piece2.Draw();

        Piece piece3 = new Piece(3 ,0 , 60);
        piece3.Load(1);
        piece3.Draw();

//        Box box = new Box(10 ,10);
//        box.initNumber();
//        box.draw();
    }
}