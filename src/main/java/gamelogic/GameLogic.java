package gamelogic;

import gameObject.*;

import java.awt.event.ActionEvent;

/**
 *Klasse in der alle Updates am Spiel ausgeführt werden
 */
public class GameLogic extends MouseInput{



    public static void update(GameObjects gameObjects, ActionEvent actionEvent){
        System.out.println("started Updating");//Statusmeldung in der Konsole
       if (MouseInput.mouseIsOnObjekt(gameObjects)) System.out.println("in Objekt");





        System.out.println("finished Updating");//Statusmeldung in der Konsole
    }




}
