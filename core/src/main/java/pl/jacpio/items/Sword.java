package pl.jacpio.items;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class Sword extends Item{
    public Sword(float x, float y, SpriteBatch batch, World world) {
        super(x,y,0.5f,batch, world);
        setImage(0);
        setCollision();
    }
    public Sword(SpriteBatch batch, World world) {
        super(batch, world);
        setImage(0);
    }

    @Override
    public void use() {
        System.out.println("Sword can be picked up!");
    }
}
