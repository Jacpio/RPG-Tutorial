package pl.jacpio.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;

public class Apple extends Item{
    public Apple(float x, float y, SpriteBatch batch, World world, int index) {
        super(x,y,0.3f,batch, world, ItemType.EATS,index);
        setImage(1);
        setCollision();

    }
    public Apple(SpriteBatch batch, World world) {
        super(batch, world, ItemType.EATS);
        setImage(1);
    }

    @Override
    public void use(Entity entity) {
        if (entity.addLife(10)){
            entity.inventory.remove(this);
        }
    }
}
