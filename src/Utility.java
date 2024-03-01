import java.util.Random;

public class Utility {
    public  static Random random = new Random();
    public  static  int GenerateRandomNumber(int efficient){
        // Generate a random double between 0.0 (inclusive) and 1.0 (exclusive)
        double randomDouble = Math.random();

        // Convert the random double to an integer
        int randomNumber = (int)(randomDouble * efficient);

        return randomNumber;
    }

    public static  void ClearScreen(){
        for(int i = 0 ; i < 40 ; i++){
            for(int j = 0 ; j <100 ;j++){
                Editor.cnt.setCursorPosition(j,i);
                System.out.print(" ");
            }
        }
        Editor.cnt.setCursorPosition(0,0);
    }
    public static  void PrintPieces(){
        int amount = 20 - SD.SelectedPieceID;
        if(amount > 5) amount = 4;
        for(int i = 0 ; i < amount; i++){
            boolean isColor = false;
            SD.allPieces.get(SD.SelectedPieceID - 1  + i).Print(17 * i , 2 , i == 0 ? true : false);
        }
    }

    public static void Clear() throws InterruptedException{
        SD.keypr = 0;
        Thread.sleep(20);
    }
}
