/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly2;


import java.util.ArrayList;

//concrete product
public class GoSquare extends Square {

    public GoSquare(Type type, String name, int position) {
        super(type, name, position);
    }

    @Override
    void takeProperties(ArrayList<Player> player, int order){}

    @Override
    void doTask(ArrayList<Player> player, int order, int numberOfSquare, int jailPosition) {
        // Nothing
    }
}
