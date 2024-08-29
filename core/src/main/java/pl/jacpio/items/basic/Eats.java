package pl.jacpio.items.basic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;
import pl.jacpio.items.Item;

public class Eats extends Item {
    public float lifeAmount = 0;
    public Eats(float x, float y, float scale, SpriteBatch batch, World world, int id) {
        super(x,y,scale,batch, world, id);
    }
    public Eats(int id) {
        super(id);
    }

    @Override
    public void use(Entity entity) {
        if (entity.addLife(lifeAmount)){
            entity.inventory.remove(this);
        }
    }
}
