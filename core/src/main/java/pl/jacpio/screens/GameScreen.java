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
import pl.jacpio.entities.Player;
import pl.jacpio.huds.InventoryHUD;
import pl.jacpio.huds.PlayerHUD;
import pl.jacpio.listeners.CollisionListener;
import pl.jacpio.utilities.Assets;
import pl.jacpio.utilities.Constants;
import pl.jacpio.utilities.AssetsSetter;
import pl.jacpio.utilities.MapOperations;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;

    //Map
    private TiledMap map;
    private TiledMapRenderer renderer;
    private World world;
    private Box2DDebugRenderer debugRenderer;

    private ContactListener contactListener;
    //Player
    private Player player;
    private boolean inventoryActive = false;

    public GameScreen(SpriteBatch batch) {
        this.batch = batch;

    }

    private static List<Body> bodyToRemove = new ArrayList<>();


    public static InventoryHUD inventoryHUD;
    public static PlayerHUD playerHUD;

    public static AssetsSetter assetsSetter;

    public static void addBodyToRemove(Body body) {
        bodyToRemove.add(body);
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth()/ Constants.SCALE, Gdx.graphics.getHeight()/ Constants.SCALE, camera);

        Assets.load();

        while (!Assets.MANAGER.update()){
            System.out.println(Assets.MANAGER.getProgress() * 100 + "%");
        }


        // Initialize Map
        map = new TmxMapLoader().load("maps/map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        debugRenderer = new Box2DDebugRenderer();
        world = new World(new Vector2(0, 0), true);
        contactListener = new CollisionListener();
        world.setContactListener(contactListener);
        MapOperations.prepareMap(map, world);
        player = new Player(world, batch);

        assetsSetter = new AssetsSetter(batch, world);
        assetsSetter.setItems();
        assetsSetter.setNpcs();

        FitViewport hudViewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        inventoryHUD = new InventoryHUD(hudViewport, batch, player);
        playerHUD = new PlayerHUD(hudViewport, batch, player);

    }


    @Override
    public void render(float deltaTime) {
        update(deltaTime);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        debugRenderer.render(world, camera.combined);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        player.render(deltaTime);
        assetsSetter.render(deltaTime);
        batch.end();

        playerHUD.draw();

        if (inventoryActive) inventoryHUD.draw();
    }

    private void update(float deltaTime) {
        camera.update();
        viewport.apply();
        renderer.setView(camera);

        world.step(deltaTime, 6, 2);

        camera.position.x = player.body.getPosition().x;
        camera.position.y = player.body.getPosition().y;

        if (!world.isLocked()){
            for (Body body : bodyToRemove){
                world.destroyBody(body);
            }
            bodyToRemove.clear();
        }
        assetsSetter.update(deltaTime);
        player.update(deltaTime);
        if (inventoryActive) inventoryHUD.act();
        playerHUD.act();
        input();
    }

    private void input() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.TAB)) {
            inventoryActive = !inventoryActive;
            if (inventoryActive) Gdx.input.setInputProcessor(inventoryHUD);
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        inventoryHUD.getViewport().update(width, height, true);
        playerHUD.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Assets.dispose();
        map.dispose();
        debugRenderer.dispose();
        inventoryHUD.dispose();
        playerHUD.dispose();
    }

    @Override
    public void dispose() {}
}
