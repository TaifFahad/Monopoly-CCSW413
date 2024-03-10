package Monopoly;

/**
 *
 * @author pca
 */

//Concrete Factory
public class ConcreteSquareFactory implements SquareFactory {
    @Override
    public Square createSquare(Type type, String name, int position) {
        switch (type) {
            case GO:
                return new GoSquare(type, name, position);
            case REGULAR:
                return new RegularSquare(type, name, position);
            case INCOME_TAX:
                return new IncomeTaxSquare(type, name, position, 0, "");
            case ELECTRIC_TAX:
                return new ElectricTaxSquare(type, name, position, 0, "");
            case WATER_TAX:
                return new WaterTaxSquare(type, name, position, 0, "");
            case IN_JAIL:
                return new InJailSquare(type, name, position, 0, "");
            case GO_TO_JAIL:
                return new GoToJailSquare(type, name, position);
            case COMMUNITY_CHEST_CARD:
                return new CommunityChestCardSquare(type, name, position);
            case CHANCE_CARD:
                return new ChanceCardSquare(type, name, position);
            case BAGDAT_AVENUE:
                return new BagdatAvenue(type, name, position, 0, 0, "");
            case ISTIKLAL_AVENUE:
                return new IstiklalAvenue(type, name, position, 0, 0, "");
            case TAKSIM_AVENUE:
                return new TaksimAvenue(type, name, position, 0, 0, "");
            case BEYOGLU_AVENUE:
                return new BeyogluAvenue(type, name, position, 0, 0, "");
            case RAIL_ROAD:
                return new RailRoadSquare(type, name, position, 0, 0);
            case FREE_PARKING:
                return new FreeParking(type, name, position);
            default:
                return null;
        }
    }

    //overloaded method for squares with tax amount and message
    public Square createSquare(Type type, String name, int position, int taxAmount, String message) {
        switch (type) {
            case IN_JAIL:
                return new InJailSquare(type, name, position, taxAmount, message);
            case INCOME_TAX:
                return new IncomeTaxSquare(type, name, position, taxAmount, message);
            case ELECTRIC_TAX:
                return new ElectricTaxSquare(type, name, position, taxAmount, message);
            case WATER_TAX:
                return new WaterTaxSquare(type, name, position, taxAmount, message);
            default:
                throw new IllegalArgumentException("Invalid square type: " + type);
        }
    }

    //overloaded method for squares with rent and price
    public Square createSquare(Type type, String name, int position, int rent, int price) {
        switch (type) {
            case RAIL_ROAD:
                return new RailRoadSquare(type, name, position, rent, price);
            default:
                throw new IllegalArgumentException("Invalid square type: " + type);
        }
    }
}
