package pl.jacpio.utiles;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
    public static final AssetManager manager = new AssetManager();

    public static final String allItems = "items/items.png";
    public static final String player = "characters/player/player.png";

    public static final String inventory = "inventory/inventory.png";
    public static final String cell = "inventory/cell.png";
    public static final String cellActive = "inventory/cellActive.png";

    public static Texture loadTexture(String path) {
        return manager.get(path, Texture.class);
    }

    public static void load(){
        manager.load(allItems, Texture.class);
        manager.load(player, Texture.class);
        manager.load(inventory, Texture.class);
        manager.load(cell, Texture.class);
        manager.load(cellActive, Texture.class);
    }
    public static void dispose(){
        manager.dispose();
    }
}
