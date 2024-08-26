package pl.jacpio.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.components.Inventory;
import pl.jacpio.items.Item;
import pl.jacpio.items.Sword;

public class Entity {
    private final World world;
    private final SpriteBatch batch;
    private float elapsedTime = 0;

    public Inventory inventory;

    public float width = 32, height = 32;

    //Collision
    public Body body;
    public Direction direction = Direction.DOWN;
    public TextureRegion[] standImage;

    public Animation<TextureRegion>[] runAnimation;

    public Item sword = null;
    public Item armor = null;
    public Item bow = null;

    //Statistic
    int life = 80;
    int maxLife = 100;

    public Entity(World world, SpriteBatch batch) {
        this.world = world;
        this.batch = batch;
        standImage = new TextureRegion[4];
        runAnimation = new Animation[4];

        inventory = new Inventory(this);
    }
    public final void setAnimation(Texture texture, int size){
        TextureRegion[][] region = TextureRegion.split(texture, size, size);
        for (int row = 0; row < 4; row++) {
            standImage[row] = region[row][0];
        }
        for (int row = 0; row < 4; row++) {
            TextureRegion[] frames = new TextureRegion[2];
            for (int col = 1; col < 3; col++) {
                frames[col - 1] = region[row][col];
            }
            runAnimation[row] = new Animation<>(0.2f, frames);
        }
    }
    public final void createBody(float x, float y, float width, float height){
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(x, y);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.fixedRotation = true;
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width/2, height/2);
        body.createFixture(shape, 0.0f);
        body.setUserData(this);
        shape.dispose();
    }
    public void update(float delta){}
    public void render(float deltaTime){
        if (body.getLinearVelocity().isZero(0.01f)){
            switch (direction){
                case DOWN -> renderStandAnimation(0);
                case UP -> renderStandAnimation(1);
                case RIGHT -> renderStandAnimation(2);
                case LEFT -> renderStandAnimation(3);
            }
        }else{
            elapsedTime += deltaTime;
            switch (direction){
                case DOWN -> renderRunAnimation(0);
                case UP -> renderRunAnimation(1);
                case RIGHT -> renderRunAnimation(2);
                case LEFT -> renderRunAnimation(3);
            }
        }
    }

    private void renderRunAnimation(int i) {
        batch.draw(runAnimation[i].getKeyFrame(elapsedTime, true), body.getPosition().x - width/2, body.getPosition().y - height/2, width, height);
    }

    private void renderStandAnimation(int i) {
        batch.draw(standImage[i], body.getPosition().x - width/2, body.getPosition().y - height/2, width, height);
    }

    public boolean addLife(int amount) {
        life += amount;
        if (life > maxLife){
            life = maxLife;
            return false;
        }
        return true;
    }
}
