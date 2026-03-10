package gamelogic;

import gameObject.*;
import gameObject.Button;
import gameObject.Menu;
import helper.Sorter;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *Klasse in der alle Updates am Spiel ausgeführt werden
 */
public class GameLogic extends MouseInput{

    public static GameObjects update(GameObjects gameObjects, ActionEvent actionEvent){
        int lastGamObjectLength=gameObjects.getGameObjects().size();
        //System.out.println("started Updating");//Statusmeldung in der Konsole

        /*
        * Interagieren mit ausgewählten GameObject
        * */
       GameObject selectedGameObject =mouseIsOnObjekt(gameObjects);
        if (selectedGameObject!=null){

           if (MouseInput.mouseClicked) {
               System.out.println("in Objekt");
               if (selectedGameObject instanceof Storage) {
                   gameObjects = ((Storage) selectedGameObject).interact(gameObjects, MouseInput.button, selectedGameObject.getPositionX(), selectedGameObject.getPositionY(), MouseInput.mouseX, MouseInput.mouseY);
               }
               MouseInput.setMouseClicked(false);
           }
        }
        gameObjects=moveMouse(gameObjects);






        gameObjects= updateChildObjekts(gameObjects);
       gameObjects= Sorter.sortByLayers(gameObjects);
       //System.out.println("finished Updating");//Statusmeldung in der Konsole
        if (lastGamObjectLength!=gameObjects.getGameObjects().size()){
        System.out.println("GameObject-length "+gameObjects.getGameObjects().size());}
        return gameObjects;
    }

    /**
     * Methode zum Prüfen, ob die Maus auf einem sichtbaren Objekt ist (mit diesem Interagieren kann)
     * dabei werden alle Game Objekte durchsucht bis ein passendes objekt gefunden wurde oder alle geprüft wurden
     * Deshalb ist es wichtig, dass die "Hitboxen" von objekten sich nicht überlagern, wenn diese beide Sichtbar sind!!!
     * @param gameObjects Liste der zu prüfenden Game Objekte
     * @return
     */
    private  static GameObject mouseIsOnObjekt(GameObjects gameObjects){

        int mouseX =MouseInput.mouseX;
        int mouseY =MouseInput.mouseY;
        int size = gameObjects.getGameObjects().size();
        for (int i = 1; i <=size; i++) {

            GameObject gameObjectI =gameObjects.getGameObjects().get(size-i);
            if (gameObjectI.isVisible()){
                if (gameObjectI.isInteractable()){
                    if (gameObjectI.getPositionX()<mouseX){
                        if (gameObjectI.getPositionY()<mouseY){
                            if (gameObjectI.getPositionX()+gameObjectI.getZiseX()>mouseX){
                                if (gameObjectI.getPositionY()+gameObjectI.getZiseY()>mouseY){

                                    return gameObjectI;
                                }
                            }

                        }
                    }
                }
            }
        }



        return  null;
    }

    public  static GameObjects moveMouse(GameObjects gameObjects){
        if (MouseInput.mouseMoved) {
            System.out.println("Moved");
            MouseInput.setMouseMoved(false);
            Point point = new Point(MouseInput.mouseX,MouseInput.mouseY);
         Storage mouseStorage =Storage.getMouseStorage(gameObjects);
         mouseStorage.setPosition(point);
         gameObjects=  mouseStorage.updateStorage(gameObjects);


            boolean draging=false;
            for (int i = 0; i <gameObjects.getGameObjects().size(); i++) {
                if (gameObjects.getGameObjects().get(i)!=null){
                    if (gameObjects.getGameObjects().get(i).isLockedToMouse()&& MouseInput.mousepressed){
                        if (gameObjects.getGameObjects().get(i) instanceof Menu){
                            Point absolutePosition =new Point(
                                    (int) (point.getX()-((Menu) gameObjects.getGameObjects().get(i)).getLocalMousePosition().getX()),
                                    (int) (point.getY()- ((Menu) gameObjects.getGameObjects().get(i)).getLocalMousePosition().getY())
                            );
                            gameObjects.getGameObjects().get(i).setPosition(absolutePosition);
                        }else {
                        gameObjects.getGameObjects().get(i).setPosition(point);
                        }
                        gameObjects.updateGameObject(gameObjects.getGameObjects().get(i));
                        draging=true;
                    }else if (gameObjects.getGameObjects().get(i).isLockedToMouse()&& !MouseInput.mousepressed){
                        gameObjects.getGameObjects().get(i).setLockedToMouse(false);
                        gameObjects.getGameObjects().get(i).setInteractable(true);
                        gameObjects.updateGameObject(gameObjects.getGameObjects().get(i));

                    }
                }
            }
            if (MouseInput.mousepressed&& !draging){
                GameObject onObjekt =mouseIsOnObjekt(gameObjects);
                if (onObjekt!=null){
                    if (onObjekt.isDragable()){
                        onObjekt.setLockedToMouse(true);
                        onObjekt.setInteractable(false);
                        if (onObjekt instanceof Menu){
                            ((Menu) onObjekt).setLocalMousePosition(((Menu) onObjekt).calculateLocalMousePosition(point));
                        }
                        gameObjects.updateGameObject(onObjekt);
                    }}

            }



       }
    return  gameObjects;
    }


    public   static GameObjects updateChildObjekts(GameObjects gameObjects) {
        for (int i = 0; i < gameObjects.getGameObjects().size(); i++) {
            if (gameObjects.getGameObjects().get(i)!=null) {
            if (gameObjects.getGameObjects().get(i).isChildObject()) {
                gameObjects.setGameObject(null, i);
            }
            }
        }


        for (int i = 0; i < gameObjects.getGameObjects().size(); i++) {
            GameObject aktiveGameObject = gameObjects.getGameObjects().get(i);


            if (aktiveGameObject instanceof Storage) {
               gameObjects= updateStorage(gameObjects,aktiveGameObject);
            }

            if (aktiveGameObject instanceof Menu){
                gameObjects=updateMenu(gameObjects,aktiveGameObject);
            }
        }



        return gameObjects;
    }


    private static GameObjects updateStorage(GameObjects gameObjects, GameObject aktiveGameObject){
        Storage aktiveStorage = (Storage) aktiveGameObject;
        for (int j = 0; j < aktiveStorage.getItems().length; j++) {
            if (aktiveStorage.getItems()[j]!=null){
                Point localItemCoordinates = aktiveStorage.getLocalItemCoordinates(j);
                int absoluteItemPositionX = localItemCoordinates.x + aktiveStorage.getPositionX();
                int absoluteItemPositionY = localItemCoordinates.y + aktiveStorage.getPositionY();
                aktiveStorage.getItems()[j].setPositionX(absoluteItemPositionX);
                aktiveStorage.getItems()[j].setPositionY(absoluteItemPositionY);
                aktiveStorage.getItems()[j].setLayer(aktiveStorage.getLayer() + 1);
                aktiveStorage.getItems()[j].setVisible(aktiveStorage.isVisible());
                aktiveStorage.getItems()[j].setTextToDisplay(aktiveStorage.getAmounts()[j] + "");
                gameObjects.addGameObject(aktiveStorage.getItems()[j]);}
        }
        return gameObjects;
    }

    private static GameObjects updateMenu(GameObjects gameObjects, GameObject aktiveGameObject){
        Menu aktiveMenu = (Menu) aktiveGameObject;
        GameObjects aktiveMenuGameObjects = aktiveMenu.getMenuGameObjects();
        for (int j = 0; j <aktiveMenuGameObjects.getGameObjects().size(); j++) {
            GameObject aktiveChildGameObject = aktiveMenuGameObjects.getGameObjects().get(j);
            int absoluteChildObjectPositionX =aktiveMenu.getPositionX()+aktiveChildGameObject.getPositionX();
            int absoluteChildObjectPositionY =aktiveMenu.getPositionY()+aktiveChildGameObject.getPositionY();
            int absoluteChildObjectLayer= aktiveMenu.getLayer()+aktiveChildGameObject.getLayer();
            boolean absoluteChildObjectVisibility=false;
            if (aktiveMenu.isVisible()){
                if (aktiveChildGameObject.isVisible()){
                    absoluteChildObjectVisibility=true;
                }
            }
            GameObject globalChildGameObject = null;
            if (aktiveChildGameObject!= null){
            Image img =aktiveChildGameObject.getImg();
            if (aktiveChildGameObject instanceof Background){
                globalChildGameObject= new Background(img);
            }
            if (aktiveChildGameObject instanceof Button){
                globalChildGameObject =new Button(img,false,0,0,0,0,0,false);
            }
            if (aktiveChildGameObject instanceof Storage){
                globalChildGameObject =new Storage(img,((Storage) aktiveChildGameObject).getName(),1,0,0,((Storage) aktiveChildGameObject).getColums(),((Storage) aktiveChildGameObject).getRows());
                ((Storage) globalChildGameObject).setItems(((Storage) aktiveChildGameObject).getItems());
                ((Storage) globalChildGameObject).setAmounts(((Storage) aktiveChildGameObject).getAmounts());
            }
            if (aktiveChildGameObject instanceof TempObject){
                globalChildGameObject = new TempObject(false,0,0,0);
            }}



            if (globalChildGameObject != null){
            globalChildGameObject.setPositionX(absoluteChildObjectPositionX);
            globalChildGameObject.setPositionY(absoluteChildObjectPositionY);
            globalChildGameObject.setLayer(absoluteChildObjectLayer);
            globalChildGameObject.setVisible(absoluteChildObjectVisibility);
            globalChildGameObject.setChildObject(true);
            gameObjects.addGameObject(globalChildGameObject);
                if (globalChildGameObject instanceof Storage){
                    gameObjects=((Storage) globalChildGameObject).updateStorage(gameObjects);
                    gameObjects=updateStorage(gameObjects,globalChildGameObject);
                }
            }
        }
        return gameObjects;
    }








}
