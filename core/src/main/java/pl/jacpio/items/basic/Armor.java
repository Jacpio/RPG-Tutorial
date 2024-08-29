package pl.jacpio.items.basic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;
import pl.jacpio.items.Item;

public class Armor extends Item {
    public Armor(float x, float y, SpriteBatch batch, World world, int id) {
        super(x,y,0.5f,batch, world, id);

    }
    public Armor(int id) {
        super(id);
    }

    @Override
    public void use(Entity entity) {
        entity.armor = this;
    }
}
