/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly2;

/**
 *
 * @author pca
 */import java.util.ArrayList;
import java.util.Random;

public class Board {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private static Login login = new Login();
    private ArrayList<Player> player = new ArrayList<>();
    private ArrayList<Square> square = new ArrayList<>();
   //singleton
    //object instance
    private static Board Instance;
    //private constructor
    private Board() {}
    //public static method 
    public static Board createInstance() {
    	if (Instance == null) {
    		Instance = new Board();
    	}
    	return Instance;
    }

    //FACTORY PATTERN 
    private ConcreteSquareFactory factory = new ConcreteSquareFactory();
    private static Dice dice = new Dice();
    private int cycle = 0;
    private int inJail;

    private Random random = new Random();

    public void startGame() {

        login.getLoginInformation(); // Taking initial values from user for squares, players and money
        login.createPlayers(player); // Creation of players with the information received
        createSquares(); // Creation squares with type, name and position FACTORY

        playGame(); // Players start the game

        System.out.println(ANSI_RED + "\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n" + ANSI_RESET);
        System.out.println(ANSI_RED + "*-* Total cycle number: " + cycle + ANSI_RESET);
        System.out.println(ANSI_RED + "*-* Winner is " + player.get(0).getName() + " with " + player.get(0).getMoney() + "M ! " + ANSI_RESET);
        System.out.println(ANSI_RED + "\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n" + ANSI_RESET);
    }

    public void playGame() {

        System.out.println(ANSI_RED + "------------------------------------------------\n\t\t\t\tWELCOME!\n------------------------------------------------\n" + ANSI_RESET);

        int pls = random.nextInt(player.size());
        while (player.size() > 1) { // Spins until the last player remains in the game

            for (int pl = pls; pl < player.size(); pl++) { // Returns for all players respectively

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }

                int dice1 = dice.rollDice();
                int dice2 = dice.rollDice();

                if (!player.get(pl).isInJail()) {

                    System.out.println("--> " + player.get(pl).getName() + "'s dice: " + dice1 + " - " + dice2);

                    if (player.get(pl).getLocation() == ChanceCardSquare.bagdat) {
                        factory.createSquare(Type.GO, ANSI_RED, pls).takeProperties(player, pl);
                    } else if (player.get(pl).getLocation() == ChanceCardSquare.beyoglu) {
                        factory.createSquare(Type.GO, ANSI_RED, pls).takeProperties(player, pl);
                    } else if (player.get(pl).getLocation() == ChanceCardSquare.istiklal) {
                        factory.createSquare(Type.GO, ANSI_RED, pls).takeProperties(player, pl);
                    } else if (player.get(pl).getLocation() == ChanceCardSquare.taksim) {
                        factory.createSquare(Type.GO, ANSI_RED, pls).takeProperties(player, pl);
                    }

                    player.get(pl).setLocationOfPlayer(dice1 + dice2, login.getNumberOfSquare());

                    if (player.get(pl).getLocation() == inJail) {
                        player.get(pl).setIsInJail(true);
                        continue;
                    }
                    System.out.println("--> " + player.get(pl).getName()
                            + " is on the " + square.get(player.get(pl).getLocation()).getName()
                            + " number " + ((square.get(player.get(pl).getLocation()).getPosition())));
                }

                if (player.get(pl).isInJail()) {
                    square.get(player.get(pl).getLocation()).doTask(player, pl, login.getNumberOfSquare(), inJail);
                    if (!player.get(pl).isInJail()) {
                        System.out.println("--> " + player.get(pl).getName() + "'s dice: " + dice1 + " - " + dice2);
                        player.get(pl).setLocationOfPlayer(dice1 + dice2, login.getNumberOfSquare());
                        System.out.println("--> " + player.get(pl).getName()
                                + " is on the " + square.get(player.get(pl).getLocation()).getName()
                                + " number " + ((square.get(player.get(pl).getLocation()).getPosition())));
                    } else {
                        System.out.println("--> " + player.get(pl).getName() + "'s money: " + player.get(pl).getMoney() + "\n");
                        cycle++;
                        continue;
                    }
                }

                square.get(player.get(pl).getLocation()).doTask(player, pl, login.getNumberOfSquare(), inJail);

                System.out.println("--> " + player.get(pl).getName() + "'s money: " + player.get(pl).getMoney() + "\n");

                if (player.get(pl).getMoney() <= 0) {
                    System.out.println(ANSI_RED + "\n***************************\n" +
                            "* " + player.get(pl).getName() + " is dead!" + "\n***************************\n" + ANSI_RESET);
                    player.remove(player.get(pl));
                }
                cycle++;
                pls = 0;
            }

        }
    }

    public void createSquares() {
        

        square.add(factory.createSquare(Type.GO, "Go Square", 0));

        for (int i = 1; i < login.getNumberOfSquare(); i++) {
            square.add(factory.createSquare(Type.REGULAR, "RegularSquare Square", i));
        }

        int fill = 0;
        while (1 > fill) {
            int tmp = random.nextInt(square.size());
            if (square.get(tmp).getType() == Type.REGULAR && tmp > (square.size() / 2)) {
                square.set(tmp, factory.createSquare(Type.GO_TO_JAIL, "Go To Jail Square", tmp));
                fill++;
            }
        }

        fill = 0;
        while (1 > fill) {
            int tmp = random.nextInt(square.size());
            if (square.get(tmp).getType() == Type.REGULAR && tmp < (square.size() / 2)) {
                square.set(tmp, factory.createSquare(Type.IN_JAIL, "In Jail Square", tmp, 50, "You have to enter in jail!"));
                inJail = tmp;
                fill++;
            }
        }

        fill = 0;
        while (1 > fill) {
            int tmp = random.nextInt(square.size());
            if (square.get(tmp).getType() == Type.REGULAR) {
                square.set(tmp, new BagdatAvenue(Type.BAGDAT_AVENUE, "Bağdat Avenue", tmp, 100, 50, "yellow"));
                ChanceCardSquare.bagdat = tmp;
                fill++;
            }
        }

        fill = 0;
        while (1 > fill) {
            int tmp = random.nextInt(square.size());
            if (square.get(tmp).getType() == Type.REGULAR) {
                square.set(tmp, new IstiklalAvenue(Type.ISTIKLAL_AVENUE, "Istiklal Avenue", tmp, 120, 60, "yellow"));
                ChanceCardSquare.istiklal = tmp;
                fill++;
            }
        }

        fill = 0;
        while (1 > fill) {
            int tmp = random.nextInt(square.size());
            if (square.get(tmp).getType() == Type.REGULAR) {
                square.set(tmp, new TaksimAvenue(Type.TAKSIM_AVENUE, "Taksim Avenue", tmp, 130, 70, "pink"));
                ChanceCardSquare.taksim = tmp;
                fill++;
            }
        }

        fill = 0;
        while (1 > fill) {
            int tmp = random.nextInt(square.size());
            if (square.get(tmp).getType() == Type.REGULAR) {
                square.set(tmp, new BeyogluAvenue(Type.BEYOGLU_AVENUE, "Beyoğlu Avenue", tmp, 135, 75, "pink"));
                ChanceCardSquare.beyoglu = tmp;
                fill++;
            }
        }

        fill = 0;
        while (1 > fill) {
            int tmp = random.nextInt(square.size());
            if (square.get(tmp).getType() == Type.REGULAR) {
                square.set(tmp, factory.createSquare(Type.RAIL_ROAD, "Rail Road Square", tmp, 200, 100));
                ChanceCardSquare.railRoad = tmp;
                fill++;
            }
        }

        fill = 0;
        while (1 > fill) {
            int tmp = random.nextInt(square.size());
            if (square.get(tmp).getType() == Type.REGULAR) {
                square.set(tmp, factory.createSquare(Type.FREE_PARKING, "Free Parking Square", tmp));
                fill++;
            }
        }

        fill = 0;
        while (login.getNumberOfIncomeTax() > fill) {
            int tmp = random.nextInt(square.size());
            if (square.get(tmp).getType() == Type.REGULAR) {
                square.set(tmp, factory.createSquare(Type.INCOME_TAX, "Income Tax Square", tmp, 100, "You have to pay 100M"));
                fill++;
            }
        }

        fill = 0;
        while (login.getNumberOfChanceCard() > fill) {
            int tmp = random.nextInt(square.size());
            if (square.get(tmp).getType() == Type.REGULAR) {
                square.set(tmp, factory.createSquare(Type.CHANCE_CARD, "Chance Card Square", tmp));
                fill++;
            }
        }

        fill = 0;
        while (login.getNumberOfCommunityChestCard() > fill) {
            int tmp = random.nextInt(square.size());
            if (square.get(tmp).getType() == Type.REGULAR) {
                square.set(tmp, factory.createSquare(Type.COMMUNITY_CHEST_CARD, "Community Chest Card Square", tmp));
                fill++;
            }
        }

        fill = 0;
        while (login.getNumberOfElectricTax() > fill) {
            int tmp = random.nextInt(square.size());
            if (square.get(tmp).getType() == Type.REGULAR) {
                square.set(tmp, factory.createSquare(Type.ELECTRIC_TAX, "Electric Tax Square", tmp, 150, "You have to pay 150M electric tax on this square!"));
                fill++;
            }
        }
         
        fill = 0;
        while (login.getNumberOfWaterTax() > fill) {
            int tmp = random.nextInt(square.size());
            if (square.get(tmp).getType() == Type.REGULAR) {
                square.set(tmp, factory.createSquare(Type.WATER_TAX, "Water Tax Square", tmp, 150, "You have to pay 150M water tax on this square!"));
                fill++;
            }
        }
    }
}
