package monopoly2;

/**
 *
 * @author pca
 */

//Factory Interface
public interface SquareFactory {
    Square createSquare(Type type, String name, int position);
    Square createSquare(Type type, String name, int position, int taxAmount, String message);

}
