package pl.jacpio.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.items.basic.HealPotion;

public class LittleHealPotion extends HealPotion {
    public LittleHealPotion(float x, float y, SpriteBatch batch, World world) {
        super(x, y, batch, world, 6);
        lifeAmount = 20;
        name = "Mała mikstura lecznicza";
        description = "Bardzo dobra, czuć w niej zdrowie";
    }

    public LittleHealPotion() {
        super(6);
        lifeAmount = 20;
        name = "Mała mikstura lecznicza";
        description = "Bardzo dobra, czuć w niej zdrowie";
    }

}
