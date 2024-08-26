package pl.jacpio.utiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.items.Apple;
import pl.jacpio.items.Item;

public class ItemsSetter {
    private final SpriteBatch batch;
    private final World world;

    private final Item[] items;
    private int index;
    public ItemsSetter(SpriteBatch batch, World world) {
        this.batch = batch;
        this.world = world;
        items = new Item[100];
    }
    public void setItems() {
        index = 0;
        items[index] = new Apple(400,550,batch, world, index);
    }
    public void render() {
        for (int i = 0; i < index + 1; i++) {
            if (items[i] != null) {
                items[i].render();
            }
        }
    }
    public void removeItem(int index) {
        items[index] = null;
    }
}
