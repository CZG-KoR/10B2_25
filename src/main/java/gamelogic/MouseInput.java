
package gamelogic;

import gameObject.GameObject;
import gameObject.GameObjects;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseInput {


    /**
     * Methode zum Prüfen, ob die Maus auf einem sichtbaren Objekt ist (mit diesem Interagieren kann)
     * dabei werden alle Game Objekte durchsucht bis ein passendes objekt gefunden wurde oder alle geprüft wurden
     * Deshalb ist es wichtig, dass die "Hitboxen" von objekten sich nicht überlagern, wenn diese beide Sichtbar sind!!!
     * @param gameObjects Liste der zu prüfenden Game Objekte
     * @return
     */
    public  static boolean mouseIsOnObjekt(GameObjects gameObjects){

          int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
          int mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();

        for (int i = 0; i <gameObjects.getGameObjects().size(); i++) {

            GameObject gameObjectI =gameObjects.getGameObjects().get(i);
            if (gameObjectI.isVisible()){
                if (gameObjectI.isInteractable()){
                    if (gameObjectI.getPositionX()<mouseX){
                        if (gameObjectI.getPositionY()<mouseY){
                            if (gameObjectI.getPositionX()+gameObjectI.getSizeX()>mouseX){
                                if (gameObjectI.getPositionY()+gameObjectI.getSizeY()>mouseY){
                                    return true;
                                }
                            }

                        }
                    }
                }
            }
        }

       return  false;
    }
            
}
