package maps;
import gameObject.*;
import gameObject.butons.VisibilityToggler;
import gameObject.items.Drug;
import gameObject.items.DrugColection;
import gameObject.items.Item;
import helper.ImageLoader;
import main.GameWindow;

/**
 * Klasse zum Bauen (Initialisiern) der Karte
 */
public  class MainRoom implements MapBuilder{
    /**
     * Methode zum Bauen (Initialisiern) der Karte
     * @param gameObjects Liste aller Gameobjekte der aktuellen Karte
     * @return Liste aller Gameobjekte nach dem Buen (Initialisieren) der Karte
     */
    public static GameObjects buildMap(GameObjects gameObjects){
       gameObjects.addGameObjects(buildBackgrounds());
       gameObjects.addGameObjects(buildDecoration());
       gameObjects.addGameObjects(buildButtons());
        gameObjects.addGameObjects(buildStorges());
        gameObjects.addGameObjects(buildMenus());



        return gameObjects;
    }


    private static GameObjects buildBackgrounds(){
        GameObjects gameObjects=new GameObjects();
        
        Background tempBackground =new Background( ImageLoader.loadImage("Räume/","Wohnzimmer.png",2));
        gameObjects.addGameObject(tempBackground);

        return gameObjects;
    }

    /**
     * Klasse zum Erstellen aller Lager
     * @return gameObject liste aller Lager
     */
    private static GameObjects buildStorges(){
        GameObjects gameObjects=new GameObjects();

        Storage mouseStorage =new Storage(ImageLoader.loadImage("empty.png"),"mouseStorage",100,0,0,1,1);
        mouseStorage.setVisible(true);
        mouseStorage.interactable=false;
        gameObjects.addGameObject(mouseStorage);







        return gameObjects;
    }

    private static GameObjects buildMenus(){
        GameObjects gameObjects=new GameObjects();
        GameObjects ChildGameObjects=new GameObjects();



        Storage playerInventory = new Storage(ImageLoader.loadImage("InvSlot.png"),"playerInventory",9,0,32,10,5);
        playerInventory.setImg(ImageLoader.loadTiledImage("InvSlot.png",playerInventory.getColumns(),playerInventory.getRows()));
        playerInventory.setVisible(true);
        Item testItem =new Drug(DrugColection.getCocain());
        playerInventory.setItem(testItem,0);
        playerInventory.setAmount(0,3);
        gameObjects.addGameObject(playerInventory);
        ChildGameObjects.addGameObject(playerInventory);


        Menu menu =new Menu(ImageLoader.loadImage("TempPixel.png",32*10,32),false,10,10,256,32*10,32,ChildGameObjects);
        VisibilityToggler visibilityToggler = new VisibilityToggler(ImageLoader.loadImage("exit.png"),true,1,9*32,0,32,32,true,menu);
        menu.addMenuGameObject(visibilityToggler);
        gameObjects.addGameObject(menu);








        Menu storageMenu =new Menu(ImageLoader.loadImage("TempPixel.png",32*10,32),false,10,10,600,32*10,32,new GameObjects());
        VisibilityToggler visibilityTogglerMainStorage = new VisibilityToggler(ImageLoader.loadImage("exit.png"),true,1,9*32,0,32,32,true,storageMenu);
        storageMenu.addMenuGameObject(visibilityTogglerMainStorage);

        Storage mainstorage =new Storage(ImageLoader.loadImage("TempSprite.png"),"mainstorage",1,0,32,10,9);
        mainstorage.setImg(ImageLoader.loadTiledImage("InvSlot.png",mainstorage.getColumns(),mainstorage.getRows()));
        mainstorage.setVisible(true);
        storageMenu.addMenuGameObject(mainstorage);
        gameObjects.addGameObject(storageMenu);
        VisibilityToggler visibilityTogglerMainStorage2 = new VisibilityToggler(ImageLoader.loadImage("Chest.png",0.04),true,10,100,500,64,64,false,storageMenu);
        gameObjects.addGameObject(visibilityTogglerMainStorage2);

        return gameObjects;
    }

    static GameObjects buildDecoration(){
        GameObjects gameObjects =new GameObjects();
        TempObject tempObject=new TempObject(true,10,320,600);
        tempObject.setImg(ImageLoader.loadImage("Tisch.png"));
        gameObjects.addGameObject(tempObject);


        TempObject tempObject1=new TempObject(true,10,420,226);
        tempObject1.setImg(ImageLoader.loadImage("Tür.png"));
        gameObjects.addGameObject(tempObject1);
        return gameObjects;
    }

    static GameObjects buildButtons(){
        GameObjects gameObjects =new GameObjects();
        return gameObjects;
    }



}
