/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Monopoly;

/**
 *
 * @author pca
 */
import java.util.ArrayList;

//concrete product
public class IstiklalAvenue extends PurchaseAndRentalSquare {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public IstiklalAvenue(Type type, String name, int position, int rent, int price, String color) {
        super(type, name, position, rent, price, color);
    }

    public IstiklalAvenue() {
    }

    @Override
    void takeProperties(ArrayList<Player> player, int order) {
        System.out.println(ANSI_GREEN + "GoodBye " + player.get(order).getName() + " from Istiklal Avenue" + ANSI_RESET);
    }
}
