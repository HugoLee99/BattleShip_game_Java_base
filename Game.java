package abdn.scnu.ai;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Game implements GameControls {
    public int NumberOfShip;
    public int row;
    public int column;
    public PlayerGameGrid Player;
    public OpponentGameGrid Opponent;



    public Game(int row, int column, int NumberOfShip){
        //Construct the basic variable
        this.row = row;
        this.column = column;
        this.NumberOfShip = NumberOfShip;



    }
    //player attack
    @Override
    public void playRound(String input) {
        //split the input in to two part row and column
        String[] strArray = input.split(",");
        //change string into int type
        int r =  Integer.parseInt(strArray[0]);
        int c = Integer.parseInt(strArray[1]);
        for(int i = 0; i < this.Opponent.ships.length; i++){
                AbstractBattleShip sp = this.Opponent.ships[i];
            for (int j = 0; j < 3; j++){
                if(r==sp.getShipCoordinates()[j][0]&&c==sp.getShipCoordinates()[j][1]){
                    System.out.println("player's attack:");
                    System.out.println("HIT "+sp.getName()+"!!!");
                    // update the ship hit and opponent's gamegrid
                    sp.hits++;
                    this.Opponent.gameGrid[r][c]="X";
                    this.Opponent.printGrid();
                    System.out.println();

                    return;
                }
            }
        }
        System.out.println("player's attack:");
        System.out.println("MISS!!!");
        // update player's gamegrid
        this.Opponent.gameGrid[r][c]="%";
        this.Opponent.printGrid();
        System.out.println();

    }
    
    
    //computer robot attack 
    public void playRound1(){
        //randomly create the coordinate to attack
        Random random = new Random();
        int r1 = random.nextInt(row);
        int c1 = random.nextInt(column);
        for(int i = 0; i < this.Player.ships.length; i++){
            AbstractBattleShip sp = this.Player.ships[i];
            for (int j = 0; j < 3; j++){
                if(r1==sp.getShipCoordinates()[j][0]&&c1==sp.getShipCoordinates()[j][1]){
                    sp.hits++;
                    System.out.println("Opponent's attack:");
                    System.out.println("HIT "+sp.getName()+"!!!");
                    this.Player.gameGrid[r1][c1]="X";
                    this.Player.printGrid();
                    System.out.println();
                    return;
                }
            }
        }
        System.out.println("Opponent's attack:");
        System.out.println("MISS!!!");
        this.Player.gameGrid[r1][c1]="%";
        this.Player.printGrid();
        System.out.println();


    }

    //To check the victory
    @Override
    public boolean checkVictory() {
        int count = 0;
        int count1 = 0;
        //whenever the player's ship was destroyed count++
        for (AbstractBattleShip ship : this.Player.ships) {
            if (ship.hits>=3){
                count++;
            }
        }
        //whenever the opponent's ship was destroyed count1++
        for (AbstractBattleShip ship1 : this.Opponent.ships) {
            if (ship1.hits>=3){
                count1++;
            }}
        //if count1 equals to the total number of Opponent's ships, player win
        if (count1==Opponent.ships.length){
            System.out.println("You have won!");
            return true;
        }
        //if count equals to the total number of player's ships, Opponent win
        else if (count==Player.ships.length){
            System.out.println("You have lost!");
            return true;
        }
        return false;
    }

    @Override
    public void exitGame(String input) {
        if(Objects.equals(input, "exit")){
            System.out.println("Exiting game_thank you for playing");
            System.exit(0);
        }


    }

    //  get the grid of Player, and store the PlayerGameGrid to the local variable Player
    @Override
    public AbstractGameGrid getPlayersGrid() {
        this.Player = new PlayerGameGrid(row, column, NumberOfShip);
        return this.Player;
    }
    //  get the grid of Opponent, and store the OpponentGameGrid to the local variable Opponent
    @Override
    public AbstractGameGrid getOpponentssGrid() {
        this.Opponent = new OpponentGameGrid(row,column,NumberOfShip);
        return this.Opponent;
    }



}

