package gameObject;
import java.util.ArrayList;
public class GameObjekts {
    ArrayList<GameObject> gameObjects = new ArrayList<>();

    public GameObjekts(){
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }
}
