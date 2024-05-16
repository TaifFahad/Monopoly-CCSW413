/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly2;

/**
 *
 * @author pca
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//A dice interface to implement observer on it
 interface Dice {
    void rigesterObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(int diceValue);
    int rollDice();
}
//concrete class
class ConcreteDice implements Dice{
   public ConcreteDice()
    {
             this.observers = new ArrayList<>();
    }
     private List<Observer> observers;
    private Random randomDice = new Random();

public int rollDice() {
    return randomDice.nextInt(6) + 1;
}
 @Override
    public void rigesterObserver(Observer observer) {
      observers.add(observer);
      
     }

    @Override
    public void removeObserver(Observer observer) {
       observers.remove(observer); }

    @Override
     public void notifyObservers(int diceValue) {
        for (Observer observer : observers) {
            observer.updateDiceRoll(diceValue);
        }
    }
}
