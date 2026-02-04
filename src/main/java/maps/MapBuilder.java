package maps;
import gameObject.*;
import helper.ImageLoader;

/**
 * Klasse zum Bauen (Initialisiern) der Karte
 */
public  class MapBuilder {
    /**
     * Methode zum Bauen (Initialisiern) der Karte
     * @param gameObjects Liste aller Gameobjekte der aktuellen Karte
     * @return Liste aller Gameobjekte nach dem Buen (Initialisieren) der Karte
     */
    public  static GameObjects buildMap(GameObjects gameObjects){
       gameObjects.addGameObjekts(buildBackgrounds());
        gameObjects.addGameObjekts(buildStorges());



        return gameObjects;
    }


    private static GameObjects buildBackgrounds(){
        GameObjects gameObjects=new GameObjects();
        
        Background tempBackground =new Background( ImageLoader.loadImage("TempHintergrund.png"));
        gameObjects.addGameObjekt(tempBackground);

        return gameObjects;
    }

    /**
     * Klasse zum Erstellen aller Lager
     * @return gameObject liste aller Lager
     */
    private static GameObjects buildStorges(){
        GameObjects gameObjects=new GameObjects();

        Storage mouseStorage =new Storage(ImageLoader.loadImage("empty.png"),"mouseLager",10,0,0,1,1);
        mouseStorage.setVisible(false);
        gameObjects.addGameObjekt(mouseStorage);

        Storage playerInventory = new Storage(ImageLoader.loadImage("TempSprite.png"),"playerInventory",9,0,0,10,6);
        playerInventory.setVisible(true);
        gameObjects.addGameObjekt(playerInventory);

        Storage mainstorage =new Storage(ImageLoader.loadImage("TempSprite.png"),"mainstorage",9,22*32,22*32,10,10);
        mainstorage.setVisible(true);
        gameObjects.addGameObjekt(mainstorage);

        return gameObjects;
    }


}
