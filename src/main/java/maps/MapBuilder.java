package maps;
import gameObject.*;
import helper.ImageLoader;
import main.*;

import javax.swing.*;
import java.awt.*;

/**
 * Klasse zum Bauen (Initialisiern) der Karte
 */
public  class MapBuilder {
    /**
     * Methode zum Bauen (Initialisiern) der Karte
     * @param gameObjekts Liste aller Gameobjekte der aktuellen Karte
     * @return Liste aller Gameobjekte nach dem Buen (Initialisieren) der Karte
     */
    public  static GameObjekts buildMap(GameObjekts gameObjekts){
        Background tempBackground =new Background( ImageLoader.loadImage("TempHintergrund.png"));
        gameObjekts.addGameObjekt(tempBackground);
        return gameObjekts;
    }
}
