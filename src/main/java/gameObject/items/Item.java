
package gameObject.items;
import gameObject.*;

import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class Item extends GameObject {
    
    String name;
    int basevalue;
    final boolean craftable;



    public Item(Image img,String name, int basevalue, boolean craftable) {
        super(img,0,0,0,0);

        ziseX = 0;
        ziseY =0;
        try {
            ziseX= img.getWidth(null);
            ziseY= img.getHeight(null);
        }catch (Exception e){
            throw e;
        }

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
