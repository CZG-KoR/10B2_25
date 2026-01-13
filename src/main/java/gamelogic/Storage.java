package gamelogic;

import items.Item;

public class Storage {
    Item[] items;
    int Amount[];
    public Storage(int Zise){
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

    public void setAmount(Storage storage, int pos, int amount) {
        storage.Amount[pos]=amount;
    }

    public Item getItem(Storage storage, int pos) {

        return items[pos];
    }
    /**
     * @param targetStorage lager in welches die Items verschoben werden sollen
     * @param  sourceStorage lager aus dem die Items entnommen werden
     * @param pos Position des zu verschiebenden Items im Source lager
    Items werden aus einem Source Lager in den ersten Slot eines Zieh-lagers verschoben, in welchem dieses bereits vorhanden ist,
            falls das item noch nicht vorhanden ist, wird der erste freie Slot verwendet.*/
    public void transferItem(Storage targetStorage, Storage sourceStorage, int pos) {

        for (int i = 0; i < targetStorage.items.length; i++) {
            if (targetStorage.items[i] == sourceStorage.items[pos]) {
                targetStorage.Amount[i] = targetStorage.Amount[i]+ sourceStorage.Amount[pos];
                emtyPos(sourceStorage,pos);
                return ;
            }
        }
        for (int i = 0; i < targetStorage.items.length; i++) {
            if (targetStorage.items[i] == null) {
                targetStorage.items[i]= sourceStorage.items[pos];
                targetStorage.Amount[i] = sourceStorage.Amount[pos];
                emtyPos(sourceStorage,pos);
                return ;
            }
        }
    }
    /**
     * @param ziehlStorage lager in welches die Items verschoben werden sollen
     * @param  sourceStorage lager aus dem die Items entnommen werden
     * @param sourcePos Position des zu verschiebenden Items im Source lager
     * @param ziehlPos Position in die Verschoben wird
    Ein Item wird aus einem Source Lager in den ausgewählten Slot im Ziel-Lager verschoben.*/
    public void addOneItem(Storage ziehlStorage, Storage sourceStorage, int sourcePos, int ziehlPos) {
        if(ziehlStorage.items[ziehlPos]== sourceStorage.items[sourcePos]){
            if (sourceStorage.Amount[sourcePos]>0) {
                ziehlStorage.Amount[ziehlPos]++;
                sourceStorage.Amount[ziehlPos]--;
            }
            if (sourceStorage.Amount[sourcePos]==0){
            emtyPos(sourceStorage,sourcePos);}
        }
        if(ziehlStorage.items[ziehlPos]==null){
            if (sourceStorage.Amount[sourcePos]>0) {
                ziehlStorage.items[ziehlPos]= sourceStorage.items[sourcePos];
                ziehlStorage.Amount[ziehlPos]++;
                sourceStorage.Amount[ziehlPos]--;
            }
            if (sourceStorage.Amount[sourcePos]==0){
                emtyPos(sourceStorage,sourcePos);}
        }


    }

    private void emtyPos(Storage storage, int pos){
        storage.Amount[pos]=0;
        storage.items[pos]=null;
    }

}




