package pl.jacpio.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;
import pl.jacpio.items.basic.Bow;

public class WoodenBow extends Bow {
    public static final int ID = 2;
    public WoodenBow(float x, float y, SpriteBatch batch, World world) {
        super(x, y, batch, world, ID);
        name = "Drewniany Łuk";
        description = "Łuk na polowania";
    }

    public WoodenBow() {
        super(ID);
        name = "Drewniany Łuk";
        description = "Łuk na polowania";
    }
}
