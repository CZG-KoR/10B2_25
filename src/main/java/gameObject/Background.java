package gameObject;
import java.awt.*;

/**
 * Hintergründe als spezielles Game Objekt
 */
public class Background extends GameObject {
    /**
     * Methode zum Erstellen des Standardhintergrundes
     * Standard Hintergrund wir bei (0,0) Angezeigt (linke obere Ecke) und befindet sich immer im layer 0, wird also zuerst gezeichnet
     * @param img Bild des Hintergrundes
     */
    public Background(Image img){
        super(img,true,0,0,0);
    }
}
