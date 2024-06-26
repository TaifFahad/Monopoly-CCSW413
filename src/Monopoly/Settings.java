/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly2;

/**
 *
 * @author pca
 */
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
import java.util.Collections;
import java.util.Scanner;

public class Settings {

    private int numberOfSquare;
    private int numberOfIncomeTax;
    private int numberOfElectricTax;
    private int numberOfWaterTax;
    private int numberOfCommunityChestCard;
    private int numberOfChanceCard;
    private int numberOfPlayer;
    private int startingMoney;

    private Scanner scanner = new Scanner(System.in);

    // PLayer class is created players with getting information
    public void createPlayers(ArrayList<Player> player) {
        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.print(i + 1 + ". Player's Name: ");
            String name = scanner.nextLine();
            player.add(new ConcretePlayer(i, name, 0, getStartingMoney(), false));
        }
    }

    // Login Screen, taking starting game information
    public void getLoginInformation() {

        System.out.print("PLease, enter the number of square: ");
        setNumberOfSquare(scanner.nextInt());

        System.out.print("PLease, enter the number of income tax square: ");
        setNumberOfIncomeTax(scanner.nextInt());

        System.out.print("PLease, enter the number of electric tax square: ");
        setNumberOfElectricTax(scanner.nextInt());

        System.out.print("PLease, enter the number of water tax square: ");
        setNumberOfWaterTax(scanner.nextInt());

        System.out.print("PLease, enter the number of community chest card square: ");
        setNumberOfCommunityChestCard(scanner.nextInt());

        System.out.print("PLease, enter the number of chance card square: ");
        setNumberOfChanceCard(scanner.nextInt());

        System.out.print("Please, enter the amount of the money (min 1500M): ");
        setStartingMoney(scanner.nextInt());

        System.out.print("PLease, enter the number of player (2-8): ");
        setNumberOfPlayer(scanner.nextInt());

        scanner.nextLine();
    }

    public void setNumberOfSquare(int numberOfSquare) {
        if (numberOfSquare < 10) {
            System.out.println("Number of square should be min 10, again enter! \n");
            System.out.print("PLease, enter the number of square: ");
            setNumberOfSquare(scanner.nextInt());
        } else {
            this.numberOfSquare = numberOfSquare;
        }
    }

    public void setNumberOfIncomeTax(int numberOfIncomeTax) {
        if (numberOfIncomeTax < 1 && numberOfIncomeTax > numberOfSquare) {
            System.out.println("Number of income tax square should be min 1, again enter! \n");
            System.out.print("PLease, enter the number of income tax square: ");
            setNumberOfIncomeTax(scanner.nextInt());
        } else {
            this.numberOfIncomeTax = numberOfIncomeTax;
        }
    }

    public void setNumberOfElectricTax(int numberOfElectricTax) {
        if (numberOfElectricTax < 1 && numberOfElectricTax > numberOfSquare) {
            System.out.println("Number of electric tax square should be min 1, again enter! \n");
            System.out.print("PLease, enter the number of electric tax square: ");
            setNumberOfElectricTax(scanner.nextInt());
        } else {
            this.numberOfElectricTax = numberOfElectricTax;
        }
    }

    public void setNumberOfWaterTax(int numberOfWaterTax) {
        if (numberOfWaterTax < 1 && numberOfWaterTax > numberOfSquare) {
            System.out.println("Number of water tax square should be min 1, again enter! \n");
            System.out.print("PLease, enter the number of water tax square: ");
            setNumberOfWaterTax(scanner.nextInt());
        } else {
            this.numberOfWaterTax = numberOfWaterTax;
        }
    }

    public void setNumberOfCommunityChestCard(int numberOfCommunityChestCard) {
        if (numberOfCommunityChestCard < 1 && numberOfCommunityChestCard > numberOfSquare) {
            System.out.println("Number of community chest card square should be min 1, again enter! \n");
            System.out.print("PLease, enter the number of community chest card square: ");
            setNumberOfCommunityChestCard(scanner.nextInt());
        } else {
            this.numberOfCommunityChestCard = numberOfCommunityChestCard;
        }
    }

    public void setNumberOfChanceCard(int numberOfChanceCard) {
        if (numberOfChanceCard < 1 && numberOfChanceCard > numberOfSquare) {
            System.out.println("Number of chance card square should be min 1, again enter! \n");
            System.out.print("PLease, enter the number of chance card square: ");
            setNumberOfChanceCard(scanner.nextInt());
        } else {
            this.numberOfChanceCard = numberOfChanceCard;
        }
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        if (numberOfPlayer < 2 || numberOfPlayer > 8) {
            System.out.println("Number of player should be between 2-8, again enter! \n");
            System.out.print("PLease, enter the number of player (2-8): ");
            setNumberOfPlayer(scanner.nextInt());
        } else {
            this.numberOfPlayer = numberOfPlayer;
        }
    }

    public void setStartingMoney(int startingMoney) {
        if (startingMoney < 1500) {
            System.out.println("Amount of money should be greater than 1500M, again enter! \n");
            System.out.print("Please, enter the amount of the money (min 1500M): ");
            setStartingMoney(scanner.nextInt());
        } else {
            this.startingMoney = startingMoney;
        }
    }

    public int getNumberOfSquare() {
        return numberOfSquare;
    }

    public int getNumberOfIncomeTax() {
        return numberOfIncomeTax;
    }

    public int getNumberOfElectricTax() {
        return numberOfElectricTax;
    }

    public int getNumberOfWaterTax() {
        return numberOfWaterTax;
    }

    public int getNumberOfCommunityChestCard() {
        return numberOfCommunityChestCard;
    }

    public int getNumberOfChanceCard() {
        return numberOfChanceCard;
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public int getStartingMoney() {
        return startingMoney;
    }
    public void chosenColor(){
        
     Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to choose the color of the player piece
        System.out.println("Choose the color of your player piece:");
        System.out.println("1. Grey");
        System.out.println("2. Gold");
        System.out.print("Enter your choice (1 or 2): ");
        
        int choice = scanner.nextInt();
        
        // Create a ConcretePlayer object
        Player player = new ConcretePlayer(1, "Player 1", 0, 100, false);
        
        // Decorate the player object based on the user's choice
        switch (choice) {
            case 1:
                player = new GreyPiece(player);
                break;
            case 2:
                player = new GoldPiece(player);
                break;
            default:
                System.out.println("Invalid choice! Defaulting to Grey piece.");
                player = new GreyPiece(player);
                break;
        }
        
        // Display the chosen player piece color
        System.out.println(player.getColor());
    }

}
