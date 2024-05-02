/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly2;

/**
 *
 * @author pca
 */

//Proxy class
public class AgeVerificationProxy implements MonopolyGame {
    private Scanner scanner;

    public AgeVerificationProxy() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void startGame() {
        System.out.print("Please enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        if (age >= 12) {
            MonopolyGame realGame = new MonopolyGameAL();
            realGame.startGame();
        } else {
            System.out.println("Sorry, you are not old enough to play the game.");
        }
    }
}

