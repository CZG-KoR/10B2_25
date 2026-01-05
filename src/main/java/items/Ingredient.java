package items;

import java.awt.*;

public class Ingredient extends Item{

    public Ingredient(String name, int value, Image img) {
        super(name, value,false,img);
    }

    @Override
    public void buy(int amount) {
    }

    @Override
    public void sell(int amount) {
    }



    public static class IngredientColection{

        static Ingredient placeholder =new Ingredient("This is a temporary Placeholder",1,null);
       static Ingredient[] cocainingredients ={placeholder};



    }
}
