## Report

## Finish time

30th Dec. 2022

## Abstract 

in this project  I implement the Coding Battleship game using Java.

Battleship is a classic guessing game where players try to sink their opponent's ships by guessing their locations on a grid. In this report, I show how to explore how to implement a graphical user interface (GUI) for Battleship using Java's Swing library, specifically focusing on using 2D arrays, JButtons, and JFrame. 

### Stage1

#### 1.1-1.2 

In this task I created the class " BattleShip "which is the subclass of the abstract class "AbstractBattleShip",  this class has many variables like**"hits，name, shipCoordinate, shiporientation"** and so on. So I also provide access to the class variables by using method "**getName** (), **getHits**(), **getShipOrientation**(), **sethits**(), **getShipCoordinates**(), and **setShipCoordinates**()."

```java
public BattleShip(String name) {
        //to set ship Orientation randomly
        String[] index = {"vertical", "horizontal"};
        Random r = new Random();
        this.name = name;
        this.shipOrientation = index[r.nextInt(2)];
}
```

In order to set the ship Orientation randomly, I used the **Random** class and **nextInt** () method to generate random number as index to choose "vertical" and "horizontal" in a String list.

#### 1.3 CheckAttack()

```java
public boolean checkAttack(int row, int column) {
        //to check whether the ship get hit
        if (row==this.shipCoordinates[0][0]&&column==this.shipCoordinates[0][1]){
            //if so hits +1, when the ship's hits over 3 the ships was destroyed
            this.hits=this.hits+1;
            if (this.hits > 3) {
                return false;}
            else {
                return true;
            }
        }
        else {return false;}
```

In this method, I try to match the **row** and **column** parameters to shipCoordinates respectively to check whether the ship get hits. 

### Stage2	

#### 2.1 InitializeGrid()

```java
public void initializeGrid () {
        //create the game grid by deflating "."
        for (int i = 0; i < gameGrid.length; i++) {
            for (int j = 0; j < gameGrid[i].length; j++) {
                gameGrid[i][j] = ".";
            }}}
```

To initialize grid I use two **for loop** and insert the "." in gameGrid which is an 2 dimension arraylist

#### 2.2 generateShips()

```java
 public void generateShips ( int numberOfShips){
        //set the space of ships array
        ships = new BattleShip[numberOfShips];
        //instantiate the ship and store it in ships array
        for (int i = 0; i < numberOfShips; i++) {
            BattleShip ship = new BattleShip("Ship " + (i + 1));
            this.ships[i] = ship;
        }
    }
```

In this small section, I just instantiate BattleShip objects which amount is required by numberOfShips parameter and store them in ships Arraylist

#### 2.3 placeShip()

I think this may be not the optimal code. I create the  center coordinate of the ship initially, then considering shipOrientation , I can get the other two coordinate of the ship. After that, I update the shipCoordinates and update gameGrid too.

#### 2.4 Player&Opponent printGrid()

Opponent printGrid()

```java
public void printGrid() {
        System.out.print("Opponent's Grid");
        for (int i = 0; i < gameGrid.length; i++) {
            String subArray[] = gameGrid[i];
            System.out.println();
            for (int j = 0; j < subArray.length; j++) {
                //to hide the ship location
                if (subArray[j]=="*"){
                    System.out.print(".");
                    continue;
                }
                System.out.print(subArray[j]);}}}
```

printGrid() method both used two **for loop** structure.

as to Opponent printGrid() to hide the ship location ,  I replace"*" to "."

Player printGrid() is familiar except the hide part.



### Stage3	

#### 3.1 Construct Game.java

```java
public Game(int row, int column, int NumberOfShip){
        //Construct the basic variable
        this.row = row;
        this.column = column;
        this.NumberOfShip = NumberOfShip;
```

take 3 parameters: row, column, NumberOfShip

#### 3.2 exitGame()

```java
@Override
    public void exitGame(String input) {
        if(Objects.equals(input, "exit")){
            System.out.println("Exiting game_thank you for playing");
            System.exit(0);
        }}
```

if program get the input is "exit",  It would use method **System.exit(0);** to end the program

#### 3.3 checkVictory()

In this task, I just need to check all the ship in ships arraylist in both side respectively, whether all of them  are destroy. And return corresponding message.

#### 3.4 playround()

When it comes to playround. Firstly, I used the split() and Integer. parseInt() method to get the useful Input message and turn it from String type to Int type.  Then, I check the  whether the ships get hit. if so, turn update the gamegird of oppoent to "X" and hits plus 1, if not update the gamegrid of opponent to "%"

Last but not least, I also create a playround() for the robot as opponent, to attack the player's ship, which will be seen at the code.

### Stage4	

#### 4.5 RunGame.java try exception

Catch an exception thrown with an unexpected input (i.e, if users enters anything else apart 

from “exit” or “row,column” coordinates. When the error occurs, print “Incorrect input”. 

<img src="C:\Users\31684\AppData\Roaming\Typora\typora-user-images\image-20221030160204438.png" alt="image-20221030160204438" style="zoom:67%;" />

## How to run the game

After starting the code. you are required to set the row, column and number of ship for game.(press "enter" after insert the number)

<img src="C:\Users\31684\AppData\Roaming\Typora\typora-user-images\image-20221030115338967.png" alt="image-20221030115338967" style="zoom:67%;" />

Then, the program will initialize the player's grid and opponent's grid automatically. Then you can insert the coordinate you want to attack in grid. (use "," to apart row and column) for instance input 1,2  mean is want to attack row 2 and column 3.)

<img src="C:\Users\31684\AppData\Roaming\Typora\typora-user-images\image-20221030150658788.png" alt="image-20221030150658788" style="zoom: 50%;" />

(use "," to apart row and column) for instance input 1,2  mean is want to attack row 2 and column 3.)

As you can see, row 2 column 3 was attacked.(unfortunately, enemy battleship is not here) and you can see the enemy didn't find your ship too.

The program will keep asking you to insert attack coordinate until the game finish(Either player’s or opponent’s ships are destroyed.)

<img src="C:\Users\31684\AppData\Roaming\Typora\typora-user-images\image-20221030151421320.png" alt="image-20221030151421320" style="zoom:50%;" />

For instance, here I won the game, and the program asked me whether I want to exist.

If I enter "exit",  the program will end.

<img src="C:\Users\31684\AppData\Roaming\Typora\typora-user-images\image-20221030151710271.png" alt="image-20221030151710271" style="zoom:67%;" />

If not it will restart the game.

<img src="C:\Users\31684\AppData\Roaming\Typora\typora-user-images\image-20221030151959359.png" alt="image-20221030151959359" style="zoom:50%;" />
