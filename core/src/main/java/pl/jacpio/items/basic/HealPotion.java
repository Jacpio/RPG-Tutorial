package pl.jacpio.items.basic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;
import pl.jacpio.items.Item;

public class HealPotion extends Item {
    public float lifeAmount = 0;
    public HealPotion(float x, float y, SpriteBatch batch, World world, int id) {
        super(x,y,0.4f,batch, world, id);
    }
    public HealPotion(int id) {
        super(id);
    }

    @Override
    public void use(Entity entity) {
        if (entity.addLife(lifeAmount)){
            entity.inventory.remove(this);
        }
    }
}
