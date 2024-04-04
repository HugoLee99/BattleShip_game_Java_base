package abdn.scnu.ai;

import java.util.Random;

public class BattleShip extends AbstractBattleShip {
    public BattleShip(String name) {
        //to set ship Orientation randomly
        String[] index = {"vertical", "horizontal"};
        Random r = new Random();
        this.name = name;
        this.shipOrientation = index[r.nextInt(2)];

    }
    @Override
    public void setShipCoordinates(int[][] coordinates) {
        this.shipCoordinates = coordinates;
    }

    @Override
    public void setHits(int numberOfHits) {
        this.hits = numberOfHits;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHits() {
        return this.hits;
    }

    @Override
    public int[][] getShipCoordinates() {
        return this.shipCoordinates;
    }

    @Override
    public String getShipOrientation() {
        return this.shipOrientation;
    }

    @Override
    public boolean checkAttack(int row, int column) {
        //to check whether the ship get hit
        if (row==this.shipCoordinates[0][0]&&column==this.shipCoordinates[0][1]){
            //if so hits +1, when the ship's hits over 3 the ship was destroyed
            this.hits=this.hits+1;
            if (this.hits > 3) {
                return false;}
            else {
                return true;
            }
        }
        else {
            return false;
        }



    }}

