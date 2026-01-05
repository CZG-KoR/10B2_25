
package items;


import java.awt.*;

public abstract class Item {
    
    String name;
    int basevalue;
    final boolean craftable;

   Image img;

    public Item(String name, int basevalue, boolean craftable,Image img) {
        this.name = name;
        this.basevalue = basevalue;
        this.craftable = craftable;
        this.img=img;

    }

    public String getName() {
        return name;
    }

    public int getBasevalue() {
        return basevalue;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public abstract void buy(int amount);
    
    public abstract void sell(int amount);
        
    
}
