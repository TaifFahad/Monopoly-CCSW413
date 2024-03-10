/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Monopoly;

/**
 *
 * @author pca
 */
import java.util.Random;

public class Dice {

    private Random randomDice = new Random();

    public int rollDice() {
        return randomDice.nextInt(6) + 1;
    }
}
