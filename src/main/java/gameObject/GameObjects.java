package gameObject;
import java.util.ArrayList;

/**
 * Klasse zum Verwalten und Speichern von GameObjekten
 */
public class GameObjects  {
    ArrayList<GameObject> gameObjects = new ArrayList<>();//Liste zum Speichern aller Game Objekte
    int size;
    /**
     * Lehrer constructor → Neue Game Objekt listen, sind standardmäßig lehr
     */
    public GameObjects(){
    }

    /**
     * Methode zum Laden der GameObjekt Liste
     * @return Game Objekt Liste
     */
    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    /**
     * Methode zum Setzen der Gameobjekte Liste (bereits vorhandener Inhalt wird überschrieben)
     * @param gameObjects zu setzende GameObjekt Liste
     */
    public void setGameObjects(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    /**
     * Methode zum Hinzufügen eines neuen GameObjektes zu einer bereits bestehenden Liste
     * @param gameObject neues Game Objekt
     */
    public void addGameObject(GameObject gameObject){
        this.gameObjects.add(gameObject);
    }

    /**
     * Methode zum Hinzufügen einer Liste an GameObjekten zu einer bereits bestehenden Liste
     * @param gameObjects   Liste der hinzuzufügenden game Objekte
     */
    public void addGameObjects(GameObjects gameObjects){
        this.gameObjects.addAll(gameObjects.gameObjects);
    }

    /**
     * Methode zum Laden eines einzelnen Gameobjektes
     * @param pos Position des zu ladenden Game Objektes in der GameObjektListe
     * @return Game Objekt an der Position pos
     * */
    public GameObject getGameObject(int pos){
        if (pos>=0){
            if (pos<this.gameObjects.size()) {
                return this.gameObjects.get(pos);
            }
        }
        System.out.println("Die gewünschte Positon ist außerhalb der Game Objekt liste");
        return null;
    }

    /**
     * Methode zum Ersetzen eines GameObjektes durch ein neues
     * @param gameObject das Game objekt welches eingefügt wird
     * @param pos Die Position in der game Objekt Liste, welche ersetzt wird
     * */
    public void setGameObject(GameObject gameObject, int pos){
        if (this.gameObjects.size()>pos){
            this.gameObjects.set(pos,gameObject);
        }
    }

    /**
     * Methode zum Ersetzen eines GameObjektes durch eine veränderten/geupdateten variante desselben GameObjekts
     * @param gameObject das veränderte GameObjekt
     * */
    public GameObjects updateGameObject(GameObject gameObject){
        for (int i = 0; i <this.gameObjects.size(); i++) {
          if(  this.gameObjects.get(i)==gameObject){
              this.gameObjects.set(i,gameObject);
          }
        }
        return this;
    }

    public int getSize() {
        this.size=this.gameObjects.size();
        return size;
    }
}
