package abdn.scnu.ai;

import java.util.Scanner;

public class PlayerGameGrid extends GameGrid{
    public PlayerGameGrid(int w,int h, int s){
        super(w,h,s);

    }
    //print the grid 
    public void printGrid(){
        System.out.print("Player's Grid");
        for (int i = 0; i < gameGrid.length; i++) {
            String subArray[] = gameGrid[i];
            System.out.println();
            for (int j = 0; j < subArray.length; j++) {
                System.out.print(subArray[j]);
            }

        }
    }

}
