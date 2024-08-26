package pl.jacpio.items;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;

public class Sword extends Item{
    public Sword(float x, float y, SpriteBatch batch, World world, int index) {
        super(x,y,0.5f,batch, world, ItemType.SWORD, index);
        setImage(0);
        setCollision();
        name = "Miecz";
    }
    public Sword(SpriteBatch batch, World world) {
        super(batch, world, ItemType.SWORD);
        setImage(0);
        name = "Miecz";
    }

    @Override
    public void use(Entity entity) {
        entity.sword = this;
    }
}
