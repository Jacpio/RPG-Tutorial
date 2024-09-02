package pl.jacpio.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.items.basic.ManaPotion;

public class LittleManaPotion extends ManaPotion {
    public LittleManaPotion(float x, float y, SpriteBatch batch, World world) {
        super(x, y, batch, world, 5);
        manaAmount = 20;
        name = "Mała mikstura many";
        description = "Mikstura prawdziwego czarodzieja";
    }

    public LittleManaPotion() {
        super(5);
        manaAmount = 20;
        name = "Mała mikstura many";
        description = "Mikstura prawdziwego czarodzieja";
    }
}
