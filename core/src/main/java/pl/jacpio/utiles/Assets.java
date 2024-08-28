package pl.jacpio.utiles;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Assets {
    public static final AssetManager manager = new AssetManager();

    public static final String allItems = "items/items.png";
    public static final String player = "characters/player/player.png";

    public static final String inventory = "inventory/inventory.png";
    public static final String cell = "inventory/cell.png";
    public static final String cellActive = "inventory/cellActive.png";
    public static final String mainFont = "fonts/mainFont.fnt";

    public static final String itemDescription = "inventory/ItemDescription.png";
    public static final String itemPreview = "inventory/ItemPreview.png";

    public static Texture getTexture(String path) {
        return manager.get(path, Texture.class);
    }
    public static BitmapFont getFont(String path) {
        return manager.get(path, BitmapFont.class);
    }
    public static void load(){
        //Texture
        manager.load(allItems, Texture.class);
        manager.load(player, Texture.class);
        manager.load(inventory, Texture.class);
        manager.load(cell, Texture.class);
        manager.load(cellActive, Texture.class);
        manager.load(itemDescription, Texture.class);
        manager.load(itemPreview, Texture.class);

        //Fonts
        manager.load(mainFont, BitmapFont.class);
    }
    public static void dispose(){
        manager.dispose();
    }
}
