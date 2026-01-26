package gameObject;
import java.awt.*;

/**
 * Klasse zum Erstellen von Hintergründen
 */
public class Background extends GameObject {
    /**
     * Standart Hintergrund wir bei (0,0) Angezeigt (linke obere Ecke)
     * @param img Bild des Hintergundes
     */
    public Background(Image img){
        super(img,true,0,0,0,0,0);
    }
}
