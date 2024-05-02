/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly2;

/**
 *
 * @author pca
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      MonopolyGame game = new AgeVerificationProxy();
        game.startGame();
    }
}

