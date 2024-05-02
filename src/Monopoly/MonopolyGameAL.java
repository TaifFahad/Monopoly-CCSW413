/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package monopoly2;

/**
 *
 * @author pca
 */


//Real subject class
public class MonopolyGameAL implements MonopolyGame {
    @Override
    public void startGame() {
        Board newGame = Board.createInstance();
        newGame.startGame();
    }
}
