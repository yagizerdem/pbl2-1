public class Box {
    public String[][] container = new String[5][5];
    public int start_row = 0;
    public int start_col = 0;

    public Box(int start_row , int start_col){
        this.start_row = start_row;
        this.start_col = start_col;
    }
    public Box(){

    }
    public void fill(){
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                container[i][j] = " ";
                if(i == 0 || i == 4 || j == 0 ||j == 4){
                    container[i][j] = "+";
                }
                else if(
                                (i == 1 && j == 2)||
                                (i == 2 && j == 1)||
                                (i == 2 && j == 3)||
                                (i == 3 && j == 2)

                ){
                    container[i][j] = String.valueOf(Helper.randomNumber());
                }

            }
        }
    }
    public void  draw(){
        for(int i = 0 ; i <5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                Screen.cnt.setCursorPosition(start_col + j , start_row + i);
                System.out.print(container[i][j]);
            }
        }
    }
}
