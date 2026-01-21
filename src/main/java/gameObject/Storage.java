package gameObject;

import gameObject.items.Item;

public class Storage extends GameObject {
    Item[] items;
    int amount[];


    int colums;
    int rows;

    public Storage(int colums,int rows,int positionX,int positionY){
        super(null,positionX,positionY,0,0);
        int Zise = rows*colums;
        this.rows=rows;
        this.colums=colums;
        this.items=new Item[Zise];
    }


    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public int[] getAmounts() {
        return amount;
    }

    public void setAmount(Storage storage, int pos, int amount) {
        storage.amount[pos]=amount;
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
                targetStorage.amount[i] = targetStorage.amount[i]+ sourceStorage.amount[pos];
                emtyPos(sourceStorage,pos);
                return ;
            }
        }
        for (int i = 0; i < targetStorage.items.length; i++) {
            if (targetStorage.items[i] == null) {
                targetStorage.items[i]= sourceStorage.items[pos];
                targetStorage.amount[i] = sourceStorage.amount[pos];
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
            if (sourceStorage.amount[sourcePos]>0) {
                ziehlStorage.amount[ziehlPos]++;
                sourceStorage.amount[ziehlPos]--;
            }
            if (sourceStorage.amount[sourcePos]==0){
            emtyPos(sourceStorage,sourcePos);}
        }
        if(ziehlStorage.items[ziehlPos]==null){
            if (sourceStorage.amount[sourcePos]>0) {
                ziehlStorage.items[ziehlPos]= sourceStorage.items[sourcePos];
                ziehlStorage.amount[ziehlPos]++;
                sourceStorage.amount[ziehlPos]--;
            }
            if (sourceStorage.amount[sourcePos]==0){
                emtyPos(sourceStorage,sourcePos);}
        }


    }

    private void emtyPos(Storage storage, int pos){
        storage.amount[pos]=0;
        storage.items[pos]=null;
    }

}




