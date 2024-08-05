package pl.jacpio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import pl.jacpio.utiles.Constants;
import pl.jacpio.utiles.MapOperations;

public class GameScreen implements Screen {
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;

    //Map
    private TiledMap map;
    private TiledMapRenderer renderer;
    private World world;
    private Box2DDebugRenderer debugRenderer;

    //Temp player
    private Body player;
    public GameScreen(SpriteBatch batch) {
        this.batch = batch;

    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth()/ Constants.scale, Gdx.graphics.getHeight()/ Constants.scale, camera);

        // Initialize Map
        map = new TmxMapLoader().load("maps/map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        debugRenderer = new Box2DDebugRenderer();
        world = new World(new Vector2(0, 0), true);
        MapOperations.prepareMap(map, world);

        createPlayer();
    }

    private void createPlayer() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(400, 400);
        player = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(10,10);
        player.createFixture(shape, 0.0f);
    }

    @Override
    public void render(float deltaTime) {
        update(deltaTime);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        debugRenderer.render(world, camera.combined);
//        batch.setProjectionMatrix(camera.combined);
//        batch.begin();
//        //Render images etc.
//        batch.end();

    }

    private void update(float deltaTime) {
        camera.update();
        viewport.apply();
        renderer.setView(camera);

        world.step(deltaTime, 6, 2);

        camera.position.x = player.getPosition().x;
        camera.position.y = player.getPosition().y;
        input(deltaTime);
    }

    private void input(float deltaTime) {
        float velocityX = 0;
        float velocityY = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            velocityY = 10000;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            velocityY = -10000;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            velocityX = 10000;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            velocityX = -10000;
        }
        player.setLinearVelocity(velocityX * deltaTime * 2, velocityY * deltaTime* 2);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {}
}
