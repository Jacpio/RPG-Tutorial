package pl.jacpio.entities.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import pl.jacpio.entities.Entity;
import pl.jacpio.items.Item;
import pl.jacpio.items.basic.Armor;
import pl.jacpio.items.basic.Bow;
import pl.jacpio.items.basic.Sword;
import pl.jacpio.screens.GameScreen;

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
            System.out.println(index);
            if (index != -1) {
                inventory.get(index).amount -= 1;
                if (inventory.get(index).amount <= 0){
                    inventory.remove(index);
                }
            }
        }
    }

    private void removeAll(Item item) {
        if (item != null){
            int index = inventory.indexOf(item);
            if (index != -1) {
                inventory.remove(index);
            }
        }
    }
    public Item get(int i){
        return inventory.get(i);
    }

    public int getSize(){
        return inventory.size();
    }

    public int getBowSlot() {
        return inventory.indexOf(owner.bow);
    }

    public int getSwordSlot() {
        return inventory.indexOf(owner.sword);
    }

    public int getArmorSlot() {
        return inventory.indexOf(owner.armor);
    }

    public boolean isUse(Item item) {
        if (item instanceof Sword sword){
            if (owner.sword != null){
                return owner.sword.equals(sword);
            }
        }
        if (item instanceof Armor armor){
            if (owner.armor != null){
                return owner.armor.equals(armor);
            }
        }
        if (item instanceof Bow bow){
            if (owner.bow != null){
                return owner.bow.equals(bow);
            }
        }
        return false;
    }

    public void unUse(Item item) {
        if (item instanceof Sword){
            owner.sword = null;
        }
        if (item instanceof Armor){
            owner.armor = null;
        }
        if (item instanceof Bow){
            owner.bow = null;
        }
    }

    public void drop(Item item) {
        float x = owner.body.getPosition().x;
        float y = owner.body.getPosition().y;
        int amount = 1;
        switch (owner.direction) {
            case UP -> y+= owner.height * 0.9f;
            case DOWN -> y-= owner.height * 0.9f;
            case LEFT -> x-= owner.height * 0.9f;
            case RIGHT -> x+= owner.height * 0.9f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ALT_LEFT)){
            amount = inventory.get(inventory.indexOf(item)).amount;
            removeAll(item);
        }else remove(item);
        GameScreen.assetsSetter.addItem(item, x,y, amount);
        GameScreen.inventoryHUD.setTable();
    }

}
