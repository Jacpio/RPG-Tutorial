package pl.jacpio.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;

public class IronArmor extends Item{
    public IronArmor(float x, float y, SpriteBatch batch, World world, int index) {
        super(x,y,0.5f,batch, world, ItemType.ARMOR, index);
        setImage(4);
        setCollision();
        name = "Żelazna Zbroja";
    }
    public IronArmor(SpriteBatch batch, World world) {
        super(batch, world, ItemType.ARMOR);
        setImage(4);
        name = "Żelazna Zbroja";
    }

    @Override
    public void use(Entity entity) {
        entity.armor = this;
    }
}
