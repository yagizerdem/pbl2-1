import java.util.ArrayList;

public class Piece {

    public static int idCounter = 0;
    public int pieceCount;
    public Box[][] container;

    public int id;
    public  Piece(){
        this.id = ++Piece.idCounter;

        if(id <= 4) pieceCount = 4;
        else if(id <= 8) pieceCount = 3;
        else if(id <= 13) pieceCount = 2;
        else pieceCount =1;

        if(pieceCount == 3 || pieceCount == 4){
            container = new Box[3][3];
        }
        else if(pieceCount == 2){
            container = new Box[2][2];
        }
        else{
            container = new Box[1][1];
        }

        Init();
    }

    public void Print(int startx , int starty , boolean isColor){
        if(SD.SelectedPieceID == this.id && isColor) Editor.cn.setTextAttributes(Editor.att1);
        for(int i = 0 ; i < container[0].length ;i++ ){
            for(var j = 0 ; j< container[0].length;j++){
                if(container[i][j] == null){
                    Box.PrintEmptyBox(startx + j *5 , starty + i * 5);
                }
                else{
                    Box box =(Box) container[i][j];
                    box.Print(startx + j *5 , starty + i * 5);
                }

            }
        }
        Editor.cn.setTextAttributes(Editor.att0);
    }

    public void Init(){
        ArrayList<Box> allBox = new ArrayList<>();
        for(int i = 0 ; i < this.pieceCount ; i++){
            Box newBox = new Box();
            if(this.pieceCount == 4){
                newBox.fx = 24 + Utility.GenerateRandomNumber(75);
                newBox.fy = 24 + Utility.GenerateRandomNumber(75);
            }
            else if(this.pieceCount == 3){
                newBox.fx = 12 + Utility.GenerateRandomNumber(75);
                newBox.fy = 12 + Utility.GenerateRandomNumber(75);
            }
            else if(this.pieceCount == 2){
                newBox.fx = 6 + Utility.GenerateRandomNumber(75);
                newBox.fy = 6 + Utility.GenerateRandomNumber(75);
            }
            else if(this.pieceCount == 1){
                newBox.fx =  Utility.GenerateRandomNumber(75);
                newBox.fy =  Utility.GenerateRandomNumber(75);
            }

            newBox.Fill();
            allBox.add(newBox);
        }
        if(id == 1){
            this.container[0][1] = allBox.get(0);
            this.container[0][2] = allBox.get(1);
            this.container[1][0] = allBox.get(2);
            this.container[1][1] = allBox.get(3);
        }
        if(id == 2){
            this.container[0][1] = allBox.get(0);
            this.container[1][0] = allBox.get(1);
            this.container[1][1] = allBox.get(2);
            this.container[2][1] = allBox.get(3);
        }
        if(id == 3){
            this.container[0][0] = allBox.get(0);
            this.container[0][1] = allBox.get(1);
            this.container[0][2] = allBox.get(2);
            this.container[1][0] = allBox.get(3);
        }
        if(id == 4){
            this.container[0][0] = allBox.get(0);
            this.container[1][0] = allBox.get(1);
            this.container[1][1] = allBox.get(2);
            this.container[2][0] = allBox.get(3);
        }
        if(id == 5){
            this.container[0][0] = allBox.get(0);
            this.container[0][1] = allBox.get(1);
            this.container[1][1] = allBox.get(2);
        }
        if(id == 6){
            this.container[0][0] = allBox.get(0);
            this.container[0][1] = allBox.get(1);
            this.container[0][2] = allBox.get(2);
        }
        if(id == 7){
            this.container[0][1] = allBox.get(0);
            this.container[1][0] = allBox.get(1);
            this.container[1][1] = allBox.get(2);
        }
        if(id == 8){
            this.container[0][0] = allBox.get(0);
            this.container[1][0] = allBox.get(1);
            this.container[2][0] = allBox.get(2);
        }
        if(id == 9){
            this.container[0][0] = allBox.get(0);
            this.container[0][1] = allBox.get(1);
        }
        if(id == 10){
            this.container[0][0] = allBox.get(0);
            this.container[0][1] = allBox.get(1);
        }
        if(id == 11){
            this.container[0][0] = allBox.get(0);
            this.container[1][0] = allBox.get(1);
        }
        if(id == 12){
            this.container[0][0] = allBox.get(0);
            this.container[0][1] = allBox.get(1);
        }
        if(id == 13){
            this.container[0][0] = allBox.get(0);
            this.container[1][0] = allBox.get(1);
        }
        if(id == 14){
            this.container[0][0] = allBox.get(0);
        }
        if(id == 15){
            this.container[0][0] = allBox.get(0);
        }
        if(id == 16){
            this.container[0][0] = allBox.get(0);
        }
        if(id == 17){
            this.container[0][0] = allBox.get(0);
        }
        if(id == 18){
            this.container[0][0] = allBox.get(0);
        }
        if(id == 19){
            this.container[0][0] = allBox.get(0);
        }
        if(id == 20){
            this.container[0][0] = allBox.get(0);
        }


    }

    public  void Rotate(){
        if(this.pieceCount == 1) return;
        if(this.pieceCount == 2){
            Box p1 = this.container[0][0];
            Box p2 = this.container[0][1];
            Box p3 = this.container[1][0];
            Box p4 = this.container[1][1];

            this.container[0][0] = p3;
            this.container[0][1] = p1;
            this.container[1][0] = p4;
            this.container[1][1] = p2;

        }
        if(this.pieceCount >= 3){
            Box p1 = this.container[0][0];
            Box p2 = this.container[0][1];
            Box p3 = this.container[0][2];
            Box p4 = this.container[1][0];
            Box p5 = this.container[1][1];
            Box p6 = this.container[1][2];
            Box p7 = this.container[2][0];
            Box p8 = this.container[2][1];
            Box p9 = this.container[2][2];

            this.container[0][0] = p7;
            this.container[0][1] = p4;
            this.container[0][2] = p1;

            this.container[1][0] = p8;
            this.container[1][1] = p5;
            this.container[1][2] = p2;

            this.container[2][0] = p9;
            this.container[2][1] = p6;
            this.container[2][2] = p3;
        }
    }


}
