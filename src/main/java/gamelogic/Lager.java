package gamelogic;

import items.Item;

public class Lager {
    Item[] items;
    int Amount[];
    public Lager(int Zise){
        this.items=new Item[Zise];
    }


    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public int[] getAmounts() {
        return Amount;
    }

    public void setAmount(Lager lager ,int pos,int amount) {
        lager.Amount[pos]=amount;
    }

    public Item getItem(Lager lager ,int pos) {

        return items[pos];
    }

    public void addItem(Lager lager) {
        lager.getItems();
    }
}
