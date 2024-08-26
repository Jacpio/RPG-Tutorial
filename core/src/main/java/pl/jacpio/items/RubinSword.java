package pl.jacpio.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;

public class RubinSword extends Item{
    public RubinSword(float x, float y, SpriteBatch batch, World world, int index) {
        super(x,y,0.5f,batch, world, ItemType.SWORD, index);
        setImage(3);
        setCollision();
        name = "Miecz Rubinowy";
    }
    public RubinSword(SpriteBatch batch, World world) {
        super(batch, world, ItemType.SWORD);
        setImage(3);
        name = "Miecz Rubinowy";
    }

    @Override
    public void use(Entity entity) {
        entity.sword = this;
    }
}
