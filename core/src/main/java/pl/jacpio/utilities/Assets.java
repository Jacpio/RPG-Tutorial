package pl.jacpio.utilities;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Assets {
    public static final AssetManager MANAGER = new AssetManager();
    public static final String MAIN_FONT = "fonts/mainFont.fnt";

    public static final String ALL_ITEMS = "items/items.png";
    public static final String PLAYER = "characters/player/player.png";
    //NPC
    public static final String NPC_MACIEK = "characters/npc/maciek.png";

    public static final String INVENTORY_BACKGROUND = "hud/inventory/inventory.png";
    public static final String CELL = "hud/inventory/cell.png";
    public static final String CELL_ACTIVE = "hud/inventory/cellActive.png";
    public static final String ITEM_DESCRIPTION_BACKGROUND = "hud/inventory/ItemDescription.png";
    public static final String ITEM_PREVIEW_BACKGROUND = "hud/inventory/ItemPreview.png";

    public static final String BAR_BACKGROUND = "hud/player/barBackground.png";
    public static final String LIFE_ICON = "hud/player/lifeIcon.png";
    public static final String MANA_ICON = "hud/player/manaIcon.png";

    public static Texture getTexture(String path) {
        return MANAGER.get(path, Texture.class);
    }
    public static BitmapFont getFont(String path) {
        return MANAGER.get(path, BitmapFont.class);
    }
    public static void load(){
        //Texture
        MANAGER.load(ALL_ITEMS, Texture.class);
        MANAGER.load(PLAYER, Texture.class);
        MANAGER.load(INVENTORY_BACKGROUND, Texture.class);
        MANAGER.load(CELL, Texture.class);
        MANAGER.load(CELL_ACTIVE, Texture.class);
        MANAGER.load(ITEM_DESCRIPTION_BACKGROUND, Texture.class);
        MANAGER.load(ITEM_PREVIEW_BACKGROUND, Texture.class);
        MANAGER.load(BAR_BACKGROUND, Texture.class);
        MANAGER.load(LIFE_ICON, Texture.class);
        MANAGER.load(MANA_ICON, Texture.class);
        MANAGER.load(NPC_MACIEK, Texture.class);

        //Fonts
        MANAGER.load(MAIN_FONT, BitmapFont.class);
    }
    public static void dispose(){
        MANAGER.dispose();
    }
}
