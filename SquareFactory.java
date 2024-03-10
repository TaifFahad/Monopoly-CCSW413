package Monopoly;

/**
 *
 * @author pca
 */

//Factory Interface
public interface SquareFactory {
    Square createSquare(Type type, String name, int position);
}
