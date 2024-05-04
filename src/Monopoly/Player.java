/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly2;

/**
 *
 * @author pca
 */
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Monopoly;

/**
 *
 * @author pca
 * 
 */

interface Player {
    void decreaseMoney(int amount);
    void increaseMoney(int amount);
    void goInJail(int location);
    void setIsInJail(boolean inJail);
    void setLocationOfPlayer(int totalDiceValue, int numberOfSquare);
    void setLocationOfPlayer(int newLocation);
    String getName();
    int getLocation();
    int getMoney();
    boolean isInJail();
    public String getColor();
}

class ConcretePlayer implements Player {   
    

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    private int id;
    private String name;
    private int location;
    private int money;
    private boolean isInJail;
    private String color;

    public ConcretePlayer(int id, String name, int location, int money, boolean isInJail) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.money = money;
        this.isInJail = isInJail;
        
    }

    public void decreaseMoney(int amount) {
        this.money -= amount;
        if (this.money < 0) {
            this.money = 0;
        }
    }

    public void increaseMoney(int amount) {
        this.money += amount;
    }

    public void goInJail(int location) {
        this.location = location;
    }

    public void setIsInJail(boolean inJail) {
        isInJail = inJail;
        if (inJail) {
            System.out.println(ANSI_RED + "<<<  Opps! IN JAIL :(  >>>\n" + ANSI_RESET);
        } else {
            System.out.println(ANSI_BLUE + "<<<  Whuu! FREEDOM :)  >>>\n" + ANSI_RESET);
        }
    }

    public void setLocationOfPlayer(int totalDiceValue, int numberOfSquare) {
        // When the player reaches the end of the board, s/he returns to the beginning square.
        if (this.location + totalDiceValue >= numberOfSquare) {
            increaseMoney(50);
            this.location = this.location + totalDiceValue - numberOfSquare;
            System.out.println(ANSI_PURPLE + "You won 50M for completing a tour :) Your money: " + this.money + ANSI_RESET);
        } else {
            this.location += totalDiceValue;
        }
    }

    public void setLocationOfPlayer(int newLocation) {
        this.location = newLocation;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public int getMoney() {
        return money;
    }

    public boolean isInJail() {
        return isInJail;
    }

    @Override
    public String getColor() {
        return "defult color:grey";
    }
   
}

//Decorator Pattern
abstract class PlayerDecorator implements Player {
    protected Player coloredPiece;

    public PlayerDecorator(Player coloredPiece) {
        this.coloredPiece = coloredPiece;
    }
    public String getColor(){
        return coloredPiece.getColor();
    }
    
    @Override
    public void decreaseMoney(int amount) {
        coloredPiece.decreaseMoney(amount);
    }

    @Override
    public void increaseMoney(int amount) {
       coloredPiece.increaseMoney(amount); }

    @Override
    public void goInJail(int location) {
        coloredPiece.goInJail(location);   }

    @Override
    public void setIsInJail(boolean inJail) {
        coloredPiece.setIsInJail(inJail);
    }

    @Override
    public void setLocationOfPlayer(int totalDiceValue, int numberOfSquare) {
      coloredPiece.setLocationOfPlayer(totalDiceValue, numberOfSquare);  }

    @Override
    public void setLocationOfPlayer(int newLocation) {
       coloredPiece.setLocationOfPlayer(newLocation);    }

    @Override
    public String getName() {
    return coloredPiece.getName();
    }

    @Override
    public int getLocation() {
        return coloredPiece.getLocation();
    }

    @Override
    public int getMoney() {
        return coloredPiece.getLocation();
    }

    @Override
    public boolean isInJail() 
    {return coloredPiece.isInJail();
    }
    
    
}
//color Decorator
abstract class color extends PlayerDecorator{

      protected Player coloredPiece;

    public color(Player coloredPiece) {
        super(coloredPiece);
    }
     
}

class GreyPiece extends color{

    public GreyPiece(Player coloredPiece) {
        super(coloredPiece);
    }
     @Override
    public String getColor(){
        return "The chosen piece is Grey!";
    }

}

   class GoldPiece extends color{

    public GoldPiece(Player coloredPiece) {
        super(coloredPiece);
    }
     @Override
    public String getColor(){
        return "The chosen piece is Gold!";
    }

}
