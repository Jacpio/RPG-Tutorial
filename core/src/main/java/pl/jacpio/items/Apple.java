package pl.jacpio.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class Apple extends Item{
    public Apple(float x, float y, SpriteBatch batch, World world) {
        super(x,y,0.3f,batch, world);
        setImage(1);
        setCollision();
    }
    public Apple(SpriteBatch batch, World world) {
        super(batch, world);
        setImage(1);
    }

    @Override
    public void pickUp() {
        System.out.println("Apple can be picked up!");
    }
}
