package gameObject;

public interface Interactable {

    /**
     * interaction for a Button where the Coordinate of the mouse and the clicked button is irrelevant
     */
    GameObjects interact(GameObjects gameObjects);
    /**
     * interaction for a Button where the Coordinate of the mouse is irrelevant but the button is relevant
     * @param button clicked button
     */
    GameObjects interact(GameObjects gameObjects, int button);

    /**
     * interaction for an Objekt where Mouse Position and the clicked Button maters
     * @param button clicked button
     */
    GameObjects interact(GameObjects gameObjects, int button, int xPosObjekt, int yPosObjekt, int xMouse, int yMouse);
}
