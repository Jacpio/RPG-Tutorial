package pl.jacpio.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.items.*;
import pl.jacpio.utiles.Assets;

public class Player extends Entity {
    public Player(World world, SpriteBatch batch) {
        super(world, batch);
        createBody(400, 580, 32, 32);
        setAnimation(Assets.loadTexture(Assets.player), 32);
        for (int i = 0; i < 100; i++) {
            inventory.add(new Apple(batch, world));
            inventory.add(new Sword(batch, world));
        }
        inventory.add(new RubinSword(batch, world));
        inventory.add(new IronArmor(batch, world));
        inventory.add(new Bow(batch, world));
    }

    @Override
    public void update(float deltaTime) {
        input(deltaTime);
    }

    private void input(float deltaTime) {
        float velocityX = 0;
        float velocityY = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            velocityY = 10000;
            direction = Direction.UP;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            velocityY = -10000;
            direction = Direction.DOWN;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            velocityX = 10000;
            direction = Direction.RIGHT;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            velocityX = -10000;
            direction = Direction.LEFT;
        }
        if (velocityX != 0 && velocityY != 0) {
            velocityX /= (float) Math.sqrt(2);
            velocityY /= (float) Math.sqrt(2);
        }
        body.setLinearVelocity(velocityX * deltaTime * 2, velocityY * deltaTime * 2);
    }
}
