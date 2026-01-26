package gameObject;

import gameObject.items.Item;

/**
 * Klasse zum Verwalten von Items in Lagern
 */
public class Storage extends GameObject {

    Item[] items; //Liste aller Items im Lager
    int amount[];//Liste der mengen der Items
    int colums;//Spalten des Lagers
    int rows;//Zeilen des Lagers

    /**
     * Construktor für ein Lager
     * @param colums Spalten des Lagers
     * @param rows Zeilen des Lagers
     * @param positionX Position der oberen Linken Ecke des Lagers (x-Koordinate)
     * @param positionY Position der oberen Linken Ecke des Lagers (y-Koordinate)
     */
    public Storage(int colums,int rows,int positionX,int positionY){
        super(null,false,1,positionX,positionY,0,0);
        int Zise = rows*colums;
        this.rows=rows;
        this.colums=colums;
        this.items=new Item[Zise];
    }

    /**
     * alle items eines Lagers bekommen
     * @return item Liste
     */
    public Item[] getItems() {
        return items;
    }

    /**
     * alle items eines lagers setzen
     * @param items zu setzende Items
     */
    public void setItems(Item[] items) {
        this.items = items;
    }

    /**
     * alle item mengen im lager bekommen
     * @return item mengen liste
     */
    public int[] getAmounts() {
        return amount;
    }

    /**
     * Menge eines Items in einer bestimmten poition eines bestimmten Lagers setzen
     * @param storage Lager welches betroffen ist
     * @param pos betroffene Position
     * @param amount neue Menge
     */
    public void setAmount(Storage storage, int pos, int amount) {
        storage.amount[pos]=amount;
    }

    /**
     * Item an einer bestimmten Position in einem bestimmten lager bekommen
     * @param storage Lager aus welchem das Item ausgewählt werden soll
     * @param pos Position des Items im Lager
     * @return Item an der Position pos
     */
    public Item getItem(Storage storage, int pos) {
        return items[pos];
    }

    /**
     * Items werden aus einem Source Lager in den ersten Slot eines Zieh-lagers verschoben, in welchem dieses bereits vorhanden ist,
     *             falls das item noch nicht vorhanden ist, wird der erste freie Slot verwendet.
     * @param targetStorage lager in welches die Items verschoben werden sollen
     * @param  sourceStorage lager aus dem die Items entnommen werden
     * @param pos Position des zu verschiebenden Items im Source lager
    */
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
     * Ein Item wird, aus einem Source Lager in den ausgewählten Slot im Ziel-Lager verschoben.
     * @param ziehlStorage Lager in welches die Items verschoben werden sollen
     * @param  sourceStorage Lager aus dem die Items entnommen werden
     * @param sourcePos Position des zu verschiebenden Items im Source lager
     * @param ziehlPos Position in die Verschoben wird
*/
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


    /**
     * private hilfsmethode zum leren eines lagerslots
     * @param storage lager in welchem ein slott gelert werden soll
     * @param pos position die gelert werden soll
     */
    private void emtyPos(Storage storage, int pos){
        storage.amount[pos]=0;
        storage.items[pos]=null;
    }

}




