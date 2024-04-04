package abdn.scnu.ai;

public class OpponentGameGrid extends GameGrid {
    public OpponentGameGrid(int w, int h, int s) {
        //reuse the construct of super class
        super(w, h, s);

    }
    //print the grid and hide the ship location by changing "*" to "."
    public void printGrid() {
        System.out.print("Opponent's Grid");
        for (int i = 0; i < gameGrid.length; i++) {
            String subArray[] = gameGrid[i];
            System.out.println();
            for (int j = 0; j < subArray.length; j++) {
                if (subArray[j]=="*"){
                    System.out.print(".");
                    continue;
                }
                System.out.print(subArray[j]);

            }

        }
    }
}