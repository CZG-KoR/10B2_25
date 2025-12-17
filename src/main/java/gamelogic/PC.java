
package gamelogic;

import items.Item;


public class PC {
    Item[] items;

    public PC() {
        this.items = new Item[6];
    }
    
    public Item getItem(int pos) {
        return items[pos];
    }
    
    public void addItem(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i]==null){
                items[i]=item;
            }
        }
    }
     
}
