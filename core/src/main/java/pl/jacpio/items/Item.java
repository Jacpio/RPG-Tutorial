package pl.jacpio.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.utiles.Constants;
public class Item {
    public int id;

    public String name;
    public String description;

    public float x,y;
    public float size;

    public TextureRegion image;
    private final Texture allItems;

    private final SpriteBatch batch;
    private final World world;

    private Body body;

    public Item(float x, float y, float scale, SpriteBatch batch, World world) {
        this.x = x;
        this.y = y;
        this.batch = batch;
        this.world = world;
        allItems = new Texture("items/items.png");
        size = scale * Constants.itemSize;
    }
    public Item(SpriteBatch batch, World world) {
        this.batch = batch;
        this.world = world;
        allItems = new Texture("items/items.png");
    }

    public final void setCollision(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x, y);
        bodyDef.fixedRotation = true;
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(size/2, size/2);
        body.createFixture(shape, 0.0f);
        body.setUserData(this);
        shape.dispose();
    }
    public void use(){

    }
    public final void setImage(int id) {
        this.id = id;
        int y = (int) Math.floor((double) id/Constants.itemImageRow);
        int x = id - y * Constants.itemImageCol;
        y*= Constants.itemSize;
        x*= Constants.itemSize;
        image = new TextureRegion(allItems, x, y, Constants.itemSize, Constants.itemSize);
    }
    public final void render(){
        batch.draw(image, x - size/2, y - size/2, size, size);
    }
}
