package items;

public class initializeItems {
    /*
    * all Drugs can be crafted if a Ingredient List is present
    * if no Ingredient List is present Items are not craft-able
    *
    * */


    Ingredient placeholder =new Ingredient("This is a temporary Placeholder",1);


    Ingredient[] cocainingredients ={placeholder};

    Drug Cocain= new Drug("Koks",100,cocainingredients,0);

    Drug MagicMushroom = new Drug("Magic-mushroom",10);


    Drug Skittlez = new Drug("Skittlez",20);
    Drug LemonHaze= new Drug("Lemon Haze",12);
    Drug OGKush =new Drug("OG Kush",10);
}
