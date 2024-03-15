public class Robot {

    public  boolean isDone = false;
    public int bx = 0 ;
    public  int by = 0;


    public  String[][] container = {
        {"-1","-1","0","-1","-1"},
        {"0","0","0","0","0"},
        {"-1","0","0","0","-1"},
            {"-1","0","0","0","-1"},
        {"-1","0","-1","0","-1"}
    };
    public  Box[][] uicontainer = {
            {null,null,null,null,null},
            {null,null,null,null,null},
            {null,null,null,null,null},
            {null,null,null,null,null},
            {null,null,null,null,null}
    };


    public    void PrintRobotUI(){
        Editor.cnt.setCursorPosition(0,0);
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j <5 ; j++){
                if(this.uicontainer[i][j] == null){
                    if(i == 0 && j == 2 || i == 1 ||((i == 2  ||i == 3 || i == 5)&& j <=3 && j >= 1) ||i == 4&& j == 1 || i == 4 && j == 3)  Box.PrintEmptyBox(j * 5, i*5);
                }
                else{
                    // prit box
                    this.uicontainer[i][j].Print(j * 5, i*5);
                }
            }
        }
    }
    public  void Bundle(){
        Utility.ClearScreen();
        Piece selectdPiece = SD.allPieces.get(SD.SelectedPieceID-1);
        selectdPiece.Print(70,10 , false);
        this.PrintRobotUI();
        this.printSelectedPieceOnRObot();
    }
    public void printSelectedPieceOnRObot(){
        Piece selectdPiece = SD.allPieces.get(SD.SelectedPieceID-1);
        for(int i = 0; i <selectdPiece.container[0].length ; i++ ){
            for(int j = 0; j <selectdPiece.container[0].length ; j++ ){
                Box b = selectdPiece.container[i][j];
                if(b != null){
                    if(this.container[by + i][bx + j].length() > 1){
                        Editor.cn.setTextAttributes(Editor.att2);
                    }
                    b.Print(this.bx * 5 + (j*5) , this.by * 5 + (i *5));
                    Editor.cn.setTextAttributes(Editor.att0);
                }
            }
        }
    }
    public  void BuildScreen() throws  Exception{

        Bundle();
        while (true){
            if(SD.keypr == 1){
                Piece selectdPiece = SD.allPieces.get(SD.SelectedPieceID-1);
                if(SD.rkey == 27){
                    this.bx = 0;
                    this.by = 0;
                    break;
                }
                if(SD.rkey == 39){
                    if(selectdPiece.container[0].length + this.bx < 5) this.bx++;
                }
                if(SD.rkey == 37){
                    if(this.bx > 0) this.bx--;
                }
                if(SD.rkey == 38){
                    if(this.by > 0) this.by--;
                }
                if(SD.rkey == 40){
                    if(this.by + selectdPiece.container[0].length < 5) this.by++;
                }
                if(SD.rkey == 10){
                    boolean flag = true;
                    for(int i = 0 ; i < selectdPiece.container[0].length ; i++){
                        for(int j = 0 ; j < selectdPiece.container[0].length ; j++){
                            if(this.container[this.by + i][this.bx + j]  == "-1" && selectdPiece.container[i][j] != null ) flag = false;
                        }
                    }
                    if(flag == true){
                        for(int i = 0 ; i < selectdPiece.container[0].length ; i++){
                            for(int j = 0 ; j < selectdPiece.container[0].length ; j++){
                                if(selectdPiece.container[i][j] != null){
                                    this.container[this.by + i][this.bx + j] = selectdPiece.container[i][j].fx + " " + selectdPiece.container[i][j].fy;
                                    this.uicontainer[this.by + i][this.bx + j] = selectdPiece.container[i][j];
                                }
                            }
                        }
                    }

                    this.isDone = true;
                    for(int i = 0 ; i< 5 ; i++){
                        for(int j = 0 ; j< 5 ; j++){
                            if(this.container[i][j] == "0"){
                                this.isDone = false;
                                break;
                            }
                        }
                    }

                }
                Bundle();
            }

            Utility.Clear();
        }

    }

}
