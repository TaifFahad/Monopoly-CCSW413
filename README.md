# Monopoly-CCSW413

The original implementation of the Monopoly game lacks proper design patterns,
resulting in low modularity, flexibility, and maintainability. Our objective is to
enhance the codebase by applying design patterns to improve modularity, enable
expansion for new game features, and foster code reuse. Through this approach, we
aim to deliver an engaging and well-structured digital Monopoly experience.

Creational Design Patterns

• Singleton design pattern ensures that a class has only one instance and
provides a global point of access to that instance. In the context of our
Monopoly-CCSW413 project, the Singleton pattern has been implemented in
the Board class, meaning that there is only one instance of the Board class
throughout the entire game. This can be useful for ensuring that all game
players interact with the same game board, preventing inconsistencies or
conflicts that could arise from multiple instances of the board.
• By using the Factory Method design pattern, we have achieved encapsulation
of the object creation logic within the factory class. This promotes loose
coupling between the client code and the concrete square classes, as the client
code can rely on the factory to create instances of squares without needing to
know the specific implementation details. The Factory Method pattern also
allows for easy extension and maintenance of the codebase, as adding new
square types or modifying the creation logic can be done by implementing or
extending the factory interface and classes.

Structural Design Patterns

• We implemented the Proxy design pattern to bolster the system's security
measures. Specifically, we introduced a secure access control system that
verifies the user's age to ensure appropriateness for the system's content. This
age verification mechanism acts as a protective barrier, allowing only users
who meet the specified age criteria to access the system's functionalities.
• We utilized the Decorator design pattern to customize the appearance of the
pieces in the Monopoly game, mimicking real-life board game pieces such as
hats or cars, which often come in gold or grey. By employing this pattern,
players have the flexibility to choose between gold-colored or grey-colored
pieces, enhancing their gaming experience.

Behavioral Design Patterns

• We implemented the State design pattern to manageplayer states, specifically
whether they are in jail. In our Monopoly game, the ConcretePlayer class uses
a PlayerState variable to represent the current state, either FreeState or
JailState. Changing the player's jail status updates this variable and executes
the corresponding behavior. This pattern simplifies state management by
encapsulating state-specific behavior and avoiding complex conditionals.
• We utilized the Observer design pattern to handle the interaction between the
dice and players. The Dice class acts as the subject, and ConcretePlayer acts
as the observer. When the dice are rolled, the ConcreteDice class notifies all
registered players of the dice value via their updateDiceRoll (int diceValue)
method. This ensures real-time updates and decouples dice-rolling logic from
player actions, enhancing modularity and scalability.

Class Diagram Link:
https://drive.google.com/file/d/1zEB6T6ZqLke5wbXE6F4vs82tNPBJIIi9/view?usp=sharing

Group members:
Taif Alhothali
Joud Alshehri
Jouri Alghamdi 
