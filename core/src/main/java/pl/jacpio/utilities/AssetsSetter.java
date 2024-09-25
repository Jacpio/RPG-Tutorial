package pl.jacpio.utilities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.npc.Maciek;
import pl.jacpio.entities.npc.NPC;
import pl.jacpio.items.Apple;
import pl.jacpio.items.Item;
import pl.jacpio.items.SmallHealPotion;
import pl.jacpio.items.SmallManaPotion;

import java.util.ArrayList;
import java.util.List;

public class AssetsSetter {
    private final SpriteBatch batch;
    private final World world;

    private final List<Item> items;
    private final List<NPC> npcs;
    public AssetsSetter(SpriteBatch batch, World world) {
        this.batch = batch;
        this.world = world;
        items = new ArrayList<>();
        npcs = new ArrayList<>();
    }
    public void setItems() {
        items.add(new Apple(400,550,batch, world));
        items.add(new SmallManaPotion(450,550,batch, world));
        items.add(new SmallHealPotion(480,550,batch, world));
    }
    public void setNpcs() {
        npcs.add(new Maciek(400, 620, world, batch));
    }
    public void render(float deltaTime) {
        for (Item item : items) {
            item.render();
        }
        for (NPC npc : npcs) {
            npc.render(deltaTime);
        }
    }
    public void update(float deltaTime) {
        for (NPC npc : npcs) {
            npc.update(deltaTime);
        }
    }
    public void removeItem(Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) == item) {
                items.remove(i);
                break;
            }
        }
    }
    public void addItem(Item item, float x, float y, int amount) {
        Item itemToAdd = ItemRecognizer.recognize(item, x,y, batch, world);
        if (itemToAdd != null) {
            itemToAdd.amount = amount;
            items.add(itemToAdd);
        }
    }
}
