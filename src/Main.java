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




        // zeka
        for(int i = 0 ; i <=3 ;i++){
            SD.r1In += Integer.parseInt(r1.container[i][2].split(" ")[1]);
            SD.r2In += Integer.parseInt(r2.container[i][2].split(" ")[1]);
        }
        int la1 = Integer.parseInt(r1.container[1][0].split(" ")[0]) + Integer.parseInt(r1.container[1][1].split(" ")[0]);
        int la2 = Integer.parseInt(r2.container[1][0].split(" ")[0]) + Integer.parseInt(r2.container[1][1].split(" ")[0]);

        int ra1 = Integer.parseInt(r1.container[1][3].split(" ")[0]) + Integer.parseInt(r1.container[1][4].split(" ")[0]);
        int ra2 = Integer.parseInt(r2.container[1][3].split(" ")[0]) + Integer.parseInt(r2.container[1][4].split(" ")[0]);


        SD.r1Sk = (la1 + ra1) / (Math.max(la1 , ra1) / Math.min(la1 , ra1));
        SD.r2Sk = (la2 + ra2) / (Math.max(la2 , ra2) / Math.min(la2 , ra2));



        int ll1 = Integer.parseInt(r1.container[2][1].split(" ")[1]) + Integer.parseInt(r1.container[3][1].split(" ")[1]) + Integer.parseInt(r1.container[4][1].split(" ")[1]);
        int rr1 = Integer.parseInt(r1.container[2][3].split(" ")[1]) + Integer.parseInt(r1.container[3][3].split(" ")[1]) + Integer.parseInt(r1.container[4][3].split(" ")[1]);

        SD.r1Sp = (ll1 + rr1) / (Math.max(ll1 , rr1) / Math.min(ll1 , rr1));


        int ll2 = Integer.parseInt(r2.container[2][1].split(" ")[1]) + Integer.parseInt(r2.container[3][1].split(" ")[1]) + Integer.parseInt(r2.container[4][1].split(" ")[1]);
        int rr2 = Integer.parseInt(r2.container[2][3].split(" ")[1]) + Integer.parseInt(r2.container[3][3].split(" ")[1]) + Integer.parseInt(r2.container[4][3].split(" ")[1]);

        SD.r2Sp = (ll2 + rr2) / (Math.max(ll2 , rr2) / Math.min(ll2 , rr2));

        SD.c1In = Utility.GenerateRandomNumber(100) *  4;
        SD.c2In = Utility.GenerateRandomNumber(100) *  4;

        int c1la =  Utility.GenerateRandomNumber(100) * 2;
        int c1ra =  Utility.GenerateRandomNumber(100) * 2;
        int c2la =  Utility.GenerateRandomNumber(100) * 2;
        int c2ra =  Utility.GenerateRandomNumber(100) * 2;


        SD.c1Sk = c1la + c1ra  / (Math.max(c1la , c1ra) / Math.min(c1la , c1ra));
        SD.c2Sk = c2la + c2ra  / (Math.max(c2la , c2ra) / Math.min(c2la , c2ra));

        int c1ll =  Utility.GenerateRandomNumber(100) * 3;
        int c1rl =  Utility.GenerateRandomNumber(100) * 3;
        int c2ll =  Utility.GenerateRandomNumber(100) * 3;
        int c2rl =  Utility.GenerateRandomNumber(100) * 3;

        SD.c1Sp = c1ll + c1rl  / (Math.max(c1ll , c1rl) / Math.min(c1ll , c1rl));
        SD.c2Sp = c2ll + c2rl  / (Math.max(c2ll , c2rl) / Math.min(c2ll , c2rl));


        Utility.ClearScreen();

        // games


        int totalChesspoint = SD.r1In + SD.r2In + SD.c1In + SD.c2In;
        int totalPingPongpoint = SD.r1Sk + SD.r2Sk + SD.c1Sk + SD.c2Sk;
        int totalRobotRUnpoint = SD.r1Sp + SD.r2Sp + SD.c1Sp + SD.c2Sp;


        //chess
        int[] intervals = {
            SD.r1In,
            SD.r1In + SD.r2In,
                SD.r1In + SD.r2In + SD.c1In,
                SD.r1In + SD.r2In+ SD.c1In+ SD.c2In,
        };

        while (true){
            int rnd = Utility.GenerateRandomNumber(totalChesspoint);
            if(rnd >= intervals[0] && rnd <= intervals[1]){
                SD.r1chessPoint++;
            }
            else if(rnd >= intervals[1] && rnd <= intervals[2]){
                SD.r2chessPoint++;
            }
            else if(rnd >= intervals[0] && rnd <= intervals[1]){
                SD.c1chessPoint++;
            }
            else{
                SD.c2chessPoint++;
            }

            if(SD.r1chessPoint == 20 || SD.r2chessPoint == 20 || SD.c1chessPoint == 20 || SD.c2chessPoint == 20){
               break;
            }
        }

        // winner
        if(SD.r1chessPoint == 20) System.out.println("robot chess winner " + "human robot 1");
        if(SD.r2chessPoint == 20) System.out.println("robot chess winner " + "human robot 2");
        if(SD.c1chessPoint == 20) System.out.println("robot chess winner " + "computer robot 1");
        if(SD.c2chessPoint == 20) System.out.println("robot chess winner " + "computer robot 2");

        // ping pong
        int[] intervals2 = {
                SD.r1Sk,
                SD.r1Sk + SD.r2Sk,
                SD.r1Sk + SD.r2Sk + SD.c1Sk,
                SD.r1Sk + SD.r2Sk+ SD.c1Sk+ SD.c2Sk,
        };

        while (true){
            int rnd = Utility.GenerateRandomNumber(totalPingPongpoint);
            if(rnd >= intervals2[0] && rnd <= intervals2[1]){
                SD.r1pingPongPoint++;
            }
            else if(rnd >= intervals2[1] && rnd <= intervals2[2]){
                SD.r2pingPongPoint++;
            }
            else if(rnd >= intervals2[0] && rnd <= intervals2[1]){
                SD.c1pingPongPoint++;
            }
            else{
                SD.c2pingPongPoint++;
            }

            if(SD.r1pingPongPoint == 20 || SD.r2pingPongPoint == 20 || SD.c1pingPongPoint == 20 || SD.c2pingPongPoint == 20){
                break;
            }
        }

        // winner
        if(SD.r1pingPongPoint == 20) System.out.println("robot ping pong winner " + "human robot 1");
        if(SD.r2pingPongPoint == 20) System.out.println("robot ping pong winner " + "human robot 2");
        if(SD.c1pingPongPoint == 20) System.out.println("robot ping pong winner " + "computer robot 1");
        if(SD.c2pingPongPoint == 20) System.out.println("robot ping pong winner " + "computer robot 2");


        // robot run
        int[] intervals3 = {
                SD.r1Sp,
                SD.r1Sp + SD.r2Sp,
                SD.r1Sp + SD.r2Sp + SD.c1Sp,
                SD.r1Sp + SD.r2Sp+ SD.c1Sp+ SD.c2Sp,
        };

        while (true){
            int rnd = Utility.GenerateRandomNumber(totalPingPongpoint);
            if(rnd >= intervals3[0] && rnd <= intervals3[1]){
                SD.r1runPoint++;
            }
            else if(rnd >= intervals3[1] && rnd <= intervals3[2]){
                SD.r2runPoint++;
            }
            else if(rnd >= intervals3[0] && rnd <= intervals3[1]){
                SD.c1runPoint++;
            }
            else{
                SD.c2runPoint++;
            }

            if(SD.r1runPoint == 20 || SD.r2runPoint == 20 || SD.c1runPoint == 20 || SD.c2runPoint == 20){
                break;
            }
        }

        // winner
        if(SD.r1runPoint == 20) System.out.println("robot run winner " + "human robot 1");
        if(SD.r2runPoint == 20) System.out.println("robot run winner " + "human robot 2");
        if(SD.c1runPoint == 20) System.out.println("robot run winner " + "computer robot 1");
        if(SD.c2runPoint == 20) System.out.println("robot run winner " + "computer robot 2");


    }

}