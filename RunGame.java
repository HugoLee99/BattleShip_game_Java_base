package abdn.scnu.ai;

import java.util.Scanner;

public class RunGame {

    public RunGame(int width,int height, int numberOfShip){
        //Control the flow of the game
       Game game = new Game(width, height, numberOfShip);
       //initialise the gamegrids of both side 
       game.getOpponentssGrid();
       game.getPlayersGrid();
       
       Scanner scan = new Scanner(System.in);
       boolean t = false;
       //vicialize the grids
       game.Player.printGrid();
       System.out.println();
       game.Opponent.printGrid();
       System.out.println();
       //if no one wins after checkVictory, keep runing in while loop, until winner appear
       while (t == false) {
           System.out.println("Please input the location you want to attack (ex.1,2):");
           String s = scan.next();
           game.playRound1();
           game.playRound(s);
           t = game.checkVictory();
       }

        if (t==true){
            System.out.println("do you wanna exit? if so input (exit):");
            String s = scan.next();
            game.exitGame(s);}




    }
    public static void main(String[] args) {
        //set a flag
        boolean t=true;
        //get the info from the user,to initialise the size of grids,and numberOfShip
        //keep runing in this while loop
        while (t){
            Scanner scan = new Scanner(System.in);
            System.out.println("Please input the Map width:");
            int w=scan.nextInt();
            System.out.println("Please input the Map height:");
            int h=scan.nextInt();
            System.out.println("Please input the number of ship:");
            int n=scan.nextInt();
            new RunGame(w, h, n);
        }
    }
}
