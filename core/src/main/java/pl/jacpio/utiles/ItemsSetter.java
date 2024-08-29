package pl.jacpio.utiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.items.Apple;
import pl.jacpio.items.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsSetter {
    private final SpriteBatch batch;
    private final World world;

    private final List<Item> items;
    public ItemsSetter(SpriteBatch batch, World world) {
        this.batch = batch;
        this.world = world;
        items = new ArrayList<>();
    }
    public void setItems() {
        items.add(new Apple(400,550,batch, world));
    }
    public void render() {
        for (Item item : items) {
            item.render();
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
