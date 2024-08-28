package pl.jacpio.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;
import pl.jacpio.screens.GameScreen;
import pl.jacpio.utiles.Assets;
import pl.jacpio.utiles.Constants;

public class Item {
    public int id;

    public String name;
    public String description;
    public ItemType type = ItemType.UNIDENTIFIED;

    public float x, y;
    public float size;

    public TextureRegion image;

    private final SpriteBatch batch;
    private final World world;
    public int amount = 1;

    private Body body;
    private int index = -1;

    @Override
    public boolean equals(Object o) {
        return id == ((Item) o).id;
    }

    public Item(float x, float y, float scale, SpriteBatch batch, World world, ItemType type, int index) {
        this.x = x;
        this.y = y;
        this.batch = batch;
        this.world = world;
        size = scale * Constants.itemSize;
        this.type = type;
        this.index = index;
    }

    public Item(SpriteBatch batch, World world, ItemType type) {
        this.batch = batch;
        this.world = world;
        this.type = type;
    }

    public boolean isConsume() {
        return type == ItemType.EATS || type == ItemType.POTION;
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
        if (index != -1) {
            GameScreen.itemsSetter.removeItem(index);
            GameScreen.addBodyToRemove(body);
        }
    }

    public void use(Entity entity) {

    }

    public final void setImage(int id) {
        this.id = id;
        int y = (int) Math.floor((double) id / Constants.itemImageRow);
        int x = id - y * Constants.itemImageCol;
        y *= Constants.itemSize;
        x *= Constants.itemSize;
        image = new TextureRegion(Assets.getTexture(Assets.allItems), x, y, Constants.itemSize, Constants.itemSize);
    }

    public final void render() {
        batch.draw(image, x - size / 2, y - size / 2, size, size);
    }

    public void drop(Entity entity) {

    }

    public boolean isUse(Entity entity) {
        switch (type) {
            case SWORD:
                System.out.println(this);
                if (entity.sword != null) {
                    return entity.sword.equals(this);
                }
                break;
            case ARMOR:
                if (entity.armor != null) {
                    return entity.armor == this;
                }
            case BOW:
                if (entity.bow != null) {
                    return entity.bow == this;
                }
        }
        return false;
    }

    public void unUse(Entity entity) {
        switch (type) {
            case SWORD:
                entity.sword = null;
                break;
            case ARMOR:
                entity.armor = null;
            case BOW:
                entity.bow = null;
        }
    }
}
