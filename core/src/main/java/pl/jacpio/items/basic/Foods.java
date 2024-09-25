package pl.jacpio.items.basic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;
import pl.jacpio.items.Item;

public class Foods extends Item {
    public float lifeAmount = 0;
    public Foods(float x, float y, float scale, SpriteBatch batch, World world, int id) {
        super(x,y,scale,batch, world, id);
    }
    public Foods(int id) {
        super(id);
    }

    @Override
    public void use(Entity entity) {
        if (entity.addLife(lifeAmount)){
            entity.inventory.remove(this);
        }
    }
}
