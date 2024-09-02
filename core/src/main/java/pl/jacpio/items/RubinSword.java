package pl.jacpio.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;
import pl.jacpio.items.basic.Sword;

public class RubinSword extends Sword {
    public static final int ID = 3;
    public RubinSword(float x, float y, SpriteBatch batch, World world) {
        super(x, y, batch, world, ID);
        name = "Miecz rubinowy";
        description = "Czerwony niczym krew";
    }

    public RubinSword() {
        super(ID);
        name = "Miecz rubinowy";
        description = "Czerwony niczym krew";
    }
}
