package pl.jacpio.items;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.items.basic.Armor;

public class IronArmor extends Armor {
    public static final int ID = 4;
    public IronArmor(float x, float y, SpriteBatch batch, World world) {
        super(x, y, batch, world, ID);
    }

    public IronArmor() {
        super(ID);
    }
}
