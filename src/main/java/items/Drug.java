/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package items;

/**
 *
 * @author administrator
 */
public class Drug extends Item implements crafteable{
    
    Ingredient[] ingredients;
    int qualety;

    public Drug(String name, int value, Ingredient[] ingredients,int qualety) {
        super(name, value, true);
        this.ingredients = ingredients;
        this.qualety= qualety;
    }
    public Drug(String name, int value) {
        super(name, value, false);
        this.ingredients = null;
        this.qualety=0;
    }

    @Override
    public void buy(int amount) {
    }

    @Override
    public void sell(int amount) {
    }


    @Override
    public void craft(int amount, Ingredient[] incregredients) {

    }
}
