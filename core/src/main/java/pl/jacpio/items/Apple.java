package pl.jacpio.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.items.basic.Foods;

public class Apple extends Foods {
    public static final int ID = 1;
    public Apple(float x, float y, SpriteBatch batch, World world) {
        super(x, y, 0.3f, batch, world, ID);
        name = "Jabłko";
        description = "Zdrowe, pożywne i czerwone";
    }

    public Apple() {
        super(ID);
        name = "Jabłko";
        description = "Zdrowe, pożywne i czerwone";
    }
}
