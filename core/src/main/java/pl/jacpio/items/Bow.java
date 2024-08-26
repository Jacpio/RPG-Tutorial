package pl.jacpio.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;

public class Bow extends Item{
    public Bow(float x, float y, SpriteBatch batch, World world, int index) {
        super(x,y,0.5f,batch, world, ItemType.BOW, index);
        setImage(2);
        setCollision();
        name = "Luk";
    }
    public Bow(SpriteBatch batch, World world) {
        super(batch, world, ItemType.BOW);
        setImage(2);
        name = "Luk";
    }

    @Override
    public void use(Entity entity) {
        entity.bow = this;
    }
}
