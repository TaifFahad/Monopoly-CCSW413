/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly2;

/**
 *
 * @author pca
 */import java.util.ArrayList;

public class ElectricTaxSquare extends Square {

    private int amount;
    private String rule;

    public ElectricTaxSquare(Type type, String name, int position, int amount, String rule) {
        super(type, name, position);
        this.amount = amount;
        this.rule = rule;
    }

    @Override
    void doTask(ArrayList<Player> player, int order, int numberOfSquare, int jailPosition) {
        player.get(order).decreaseMoney(amount);
    }
}
