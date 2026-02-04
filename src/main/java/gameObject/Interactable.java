package gameObject;

public interface Interactable {

    /**
     * interaction for a Button where the Coordinate of the mouse is irrelevant
     * @param button clicked button
     */
    public abstract void interact(int button);
    public abstract void interact(int button,int xPosObjekt,int yPosObjekt,int xMouse,int yMouse);
}
