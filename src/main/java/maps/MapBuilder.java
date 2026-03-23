package maps;

import gameObject.GameObjects;

public interface MapBuilder {
    static GameObjects buildMap(GameObjects gameObjects){
        gameObjects.addGameObjects(buildBackgrounds());
        gameObjects.addGameObjects(buildDecoration());
        gameObjects.addGameObjects(buildStorages());
        gameObjects.addGameObjects(buildMenus());
        return gameObjects;
    };
     static GameObjects buildBackgrounds(){
        GameObjects gameObjects =new GameObjects();
        return gameObjects;
    };

    static GameObjects buildDecoration(){
        GameObjects gameObjects =new GameObjects();
        return gameObjects;
    }

    static GameObjects buildStorages(){
        GameObjects gameObjects =new GameObjects();
        return gameObjects;
    }

    static GameObjects buildMenus(){
        GameObjects gameObjects =new GameObjects();
        return gameObjects;
    }
}
