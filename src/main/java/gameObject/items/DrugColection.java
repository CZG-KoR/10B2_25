package gameObject.items;

import helper.ImageLoader;

public  class DrugColection{

     static Drug Cocain= new Drug("Koks",100,Ingredient.IngredientColection.cocainingredients, ImageLoader.loadImage("TempItem.png"));

    Drug MagicMushroom = new Drug("Magic-mushroom",10,ImageLoader.loadImage("TempItem.png"));

    Drug Skittlez = new Drug("Skittlez",20,ImageLoader.loadImage("TempItem.png"));
    Drug LemonHaze= new Drug("Lemon Haze",12,ImageLoader.loadImage("TempItem.png"));
    Drug OGKush =new Drug("OG Kush",10,ImageLoader.loadImage("TempItem.png"));

     static Drug Maka = new Drug("Maka",10,ImageLoader.loadImage("Drogen/Maka/"+"Maka.png"));

    public static Drug getCocain() {
        return Cocain;
    }

    public static Drug getMaka() {
        return Maka;
    }
}