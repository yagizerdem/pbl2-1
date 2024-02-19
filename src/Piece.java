import java.util.ArrayList;

public class Piece {
    public Box[][] container;
    public int size;
    public int start_row;
    public int start_col;
    public Piece(int size , int start_row ,int start_col){
        this.size = size;
        this.container = new Box[size][size];
        this.start_row = start_row;
        this.start_col = start_col;
    }

    public void Load(int no){
        if(no == 1){
            ArrayList<Box> allBox = generateBox(4);
            container[0][1] = allBox.get(0);
            container[0][2] = allBox.get(1);
            container[1][0] = allBox.get(2);
            container[1][1] = allBox.get(3);
        }

        for(var i = 0 ; i< size ;i++){
            for(int j = 0 ; j < size ; j++){
                if(this.container[i][j] != null){
                    this.container[i][j].start_row = this.start_row + (i * 5);
                    this.container[i][j].start_col = this.start_col + (j * 5);
                }
            }
        }
    }

    public void Draw(){
        for(int i = 0 ; i < this.size ; i++){
            for(int j = 0 ; j< this.size ;j++ ){
                if(this.container[i][j] != null) this.container[i][j].draw();
            }
        }
    }
    public ArrayList<Box> generateBox(int amount){
        ArrayList<Box> allBox = new ArrayList<Box>();
        for(var i = 0 ; i < amount ; i++){
            Box newBox = new Box();
            newBox.fill();
            allBox.add(newBox);
        }
        return  allBox;
    }
}
