package items;

public class Ingredient extends Item{

    public Ingredient(String name, int value) {
        super(name, value,false);
    }

    @Override
    public void buy(int amount) {
    }

    @Override
    public void sell(int amount) {
    }

}
