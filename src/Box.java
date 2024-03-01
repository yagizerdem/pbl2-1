import jdk.jshell.execution.Util;

public class Box {

    public Object[][] container = new Object[5][5];
    public int fy;
    public int fx;


    public Box(){
        this.Fill();
    }
    public void Fill(){
        for(int i = 0 ; i < 5 ; i++){
            for(var j = 0 ; j< 5 ; j++){
                container[i][j] = " ";
                if(i == 0 || i == 4 ||j == 0 ||j == 4){
                    container[i][j] = "+";
                    continue;
                }
                if((i == 1 && j == 2)||(i == 2 && j == 1) || (i == 2 && j == 3) ||(i == 3 && j == 2)){
                    container[i][j]= Utility.GenerateRandomNumber(10);
                }
            }
        }
    }

    public void Print(int x , int y){
        for(int i = 0 ; i < 5 ; i++){
            for(var j = 0 ; j< 5 ; j++){
                Editor.cnt.setCursorPosition(x + j , y + i);
                System.out.print(this.container[i][j]);
            }
        }
    }

    public static void PrintEmptyBox(int x ,int y){
        for(int i = 0 ; i < 5 ; i++){
            for(var j = 0 ; j< 5 ; j++){
                Editor.cnt.setCursorPosition(x + j , y + i);
                if(i == 0  || i == 4 || j == 0 || j == 4){
                    System.out.print(".");
                }
                else            System.out.print(" ");
            }
        }
    }


}
