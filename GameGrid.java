package abdn.scnu.ai;


import java.util.Random;

public class GameGrid extends AbstractGameGrid {

    int width;
    int height;

    
    public GameGrid(int width, int height, int numOfShip) {
        //set the space of (double dimensional Array) gameGrid size
        this.gameGrid = new String[height][width];
        //construct the width and height of the grid
        this.width = width;
        this.height = height;
        // automatically generateShips and initializeGrid then place all the ships in grid
        generateShips(numOfShip);
        initializeGrid();
        for (AbstractBattleShip i:ships) {
            placeShip(i);

        }
    }
    @Override
    public void initializeGrid () {
        //create the game grid by deflating "."
        for (int i = 0; i < gameGrid.length; i++) {
            for (int j = 0; j < gameGrid[i].length; j++) {
                gameGrid[i][j] = ".";
            }

        }
    }

    @Override
    public void generateShips ( int numberOfShips){
        //set the space of ships array
        ships = new BattleShip[numberOfShips];
        //instantiate the ship and store it in ships array
        for (int i = 0; i < numberOfShips; i++) {
            BattleShip ship = new BattleShip("Ship " + (i + 1));
            this.ships[i] = ship;

        }
    }

    @Override
    public void placeShip (AbstractBattleShip ship){
        Random r = new Random();
        ship.shipCoordinates = new int[3][2];
        //in order do not overspill
        int p1 = r.nextInt(this.width-2)+1;
        int p2 = r.nextInt(this.height-2)+1;
        //update the shipCoordinates
        if(ship.shipOrientation=="vertical"){
            ship.shipCoordinates[0][0]= p1-1;
            ship.shipCoordinates[0][1]= p2;
            ship.shipCoordinates[1][0]= p1;
            ship.shipCoordinates[1][1]= p2;
            ship.shipCoordinates[2][0]= p1+1;
            ship.shipCoordinates[2][1]= p2;

        } else if (ship.shipOrientation=="horizontal") {
            ship.shipCoordinates[0][0]= p1;
            ship.shipCoordinates[0][1]= p2-1;
            ship.shipCoordinates[1][0]= p1;
            ship.shipCoordinates[1][1]= p2;
            ship.shipCoordinates[2][0]= p1;
            ship.shipCoordinates[2][1]= p2+1;

        }
        //update the gameGrid to turn  the shipCoordinates in grid in to "*"
        for (int[] i:ship.shipCoordinates){
            p1 = i[0];
            p2 = i[1];
            gameGrid[p1][p2] = "*";}
        ship.setShipCoordinates(ship.shipCoordinates);
    }


}

