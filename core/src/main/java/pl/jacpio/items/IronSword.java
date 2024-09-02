package pl.jacpio.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;
import pl.jacpio.items.basic.Sword;

public class IronSword extends Sword {
    public static final int ID = 0;
    public IronSword(float x, float y, SpriteBatch batch, World world) {
        super(x, y, batch, world, ID);
        name = "Żelazny miecz";
        description = "Kute póki było gorące";
    }

    public IronSword() {
        super(ID);
        name = "Żelazny miecz";
        description = "Kute póki było gorące";
    }
}
