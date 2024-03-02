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

public class GoToJailSquare extends Square {

    public GoToJailSquare(Type type, String name, int position) {
        super(type, name, position);
    }

    @Override
    void doTask(ArrayList<Player> player, int order, int numberOfSquare, int jailPosition) {
        player.get(order).setIsInJail(true);
        player.get(order).goInJail(jailPosition);
    }
}
