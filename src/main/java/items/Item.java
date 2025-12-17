
package items;


public abstract class Item {
    
    String name;
    int basevalue;
    final boolean craftable;



    public Item(String name, int basevalue, boolean craftable) {
        this.name = name;
        this.basevalue = basevalue;
        this.craftable = craftable;

    }

    public String getName() {
        return name;
    }

    public int getBasevalue() {
        return basevalue;
    }

    
    public abstract void buy(int amount);
    
    public abstract void sell(int amount);
        
    
}
