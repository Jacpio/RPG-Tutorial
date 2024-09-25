package pl.jacpio.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;
import pl.jacpio.items.basic.Foods;
import pl.jacpio.items.basic.HealPotion;
import pl.jacpio.screens.GameScreen;
import pl.jacpio.utilities.Assets;
import pl.jacpio.utilities.Constants;

public class Item {
    public final int id;

    public String name;
    public String description;

    public float x, y;
    public float size;

    public TextureRegion image;

    private SpriteBatch batch;
    private World world;
    public int amount = 1;

    private Body body;

    @Override
    public boolean equals(Object o) {
        return id == ((Item) o).id;
    }

    public Item(float x, float y, float scale, SpriteBatch batch, World world, int id) {
        this.x = x;
        this.y = y;
        this.batch = batch;
        this.world = world;
        size = scale * Constants.ITEM_SIZE;
        this.id = id;
        setImage();
        setCollision();
    }

    public Item(int id) {
        this.id = id;
        setImage();
    }

    public boolean isConsume() {
        return this instanceof Foods || this instanceof HealPotion;
    }

    public final void setCollision() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x, y);
        bodyDef.fixedRotation = true;
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(size / 2, size / 2);
        body.createFixture(shape, 0.0f);
        body.setUserData(this);
        shape.dispose();
    }

    public void pickUp(Entity entity) {
        entity.inventory.add(this);
        GameScreen.inventoryHUD.setTable();
        destroy();
    }

    private void destroy() {
        GameScreen.assetsSetter.removeItem(this);
        GameScreen.addBodyToRemove(body);
    }

    public void use(Entity entity) {

    }

    public final void setImage() {
        int y = (int) Math.floor((double) id / Constants.ITEM_IMAGE_ROW);
        int x = id - y * Constants.ITEM_IMAGE_COL;
        y *= Constants.ITEM_SIZE;
        x *= Constants.ITEM_SIZE;
        image = new TextureRegion(Assets.getTexture(Assets.ALL_ITEMS), x, y, Constants.ITEM_SIZE, Constants.ITEM_SIZE);
    }

    public final void render() {
        batch.draw(image, x - size / 2, y - size / 2, size, size);
    }


}
