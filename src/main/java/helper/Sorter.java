package helper;

import gameObject.GameObject;
import gameObject.GameObjects;

import java.util.Collections;
import java.util.Comparator;
/**Klasse welche den Sorer für die GameObjects enthält*/
public class Sorter {
    /**
     * Methode zum Vorbereiten der GameObjektListe auf das Zeichnen/ zum Sortieren
     * @param gameObjects unsortierte GameObjektliste mit eventuellen null Objekten
     * @return sortierte GameObjektListe ohne null Objekte
     */
    public static GameObjects sortByLayers(GameObjects gameObjects){
        gameObjects.getGameObjects().removeAll(Collections.singleton(null));                            //entfernt alle Lehren GameObjekte aus der Liste um diese Sauber und kurzzuhalten und das Sortieren zu Ermöglichen
        Collections.sort(gameObjects.getGameObjects(),Comparator.comparingInt(GameObject::getLayer));   // Die GameObjektListe wird nach Layer Sortiert
         return gameObjects;                    //die sortierten GameObjekte werden zurückgegeben
    }
}
