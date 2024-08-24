package pl.jacpio.entities.components;

import pl.jacpio.entities.Entity;
import pl.jacpio.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> inventory;
    private final Entity owner;
    public Inventory(Entity owner) {
        this.owner = owner;
        inventory = new ArrayList<>();
    }

    public void add(Item item) {
        if (item != null){
            int index = inventory.indexOf(item);
            if (index != -1) {
                inventory.get(index).amount += item.amount;
            }else{
                inventory.add(item);
            }
        }
    }
    public void remove(Item item) {
        if (item != null){
            int index = inventory.indexOf(item);
            if (index != -1) {
                inventory.get(index).amount -= 1;
                if (inventory.get(index).amount <= 0){
                    inventory.remove(index);
                }
            }
        }
    }
    public Item get(int i){
        return inventory.get(i);
    }

    public int getSize(){
        return inventory.size();
    }
}
