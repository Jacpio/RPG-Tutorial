package pl.jacpio.items.basic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;
import pl.jacpio.items.Item;

public class ManaPotion extends Item {
    public float manaAmount = 0;
    public ManaPotion(float x, float y, SpriteBatch batch, World world, int id) {
        super(x,y,0.4f,batch, world, id);
    }
    public ManaPotion(int id) {
        super(id);
    }

    @Override
    public void use(Entity entity) {
        if (entity.addMana(manaAmount)){
            entity.inventory.remove(this);
        }
    }
}
