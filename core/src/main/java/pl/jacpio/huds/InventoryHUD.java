package pl.jacpio.huds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import pl.jacpio.entities.Entity;
import pl.jacpio.entities.components.Inventory;
import pl.jacpio.items.Item;
import pl.jacpio.listeners.CellLister;
import pl.jacpio.utiles.Assets;

public class InventoryHUD extends Stage {
    private final Entity entity;
    private final Inventory inventory;
    private int cellSize = 70;
    private int cellOffset = 4;
    private int tableOffset = 12;
    private int col = 8;
    Table itemTable;

    private TextureRegionDrawable cellBackground;
    private TextureRegionDrawable cellActiveBackground;

    public InventoryHUD(Viewport viewport, Batch batch, Entity entity) {
        super(viewport, batch);
        this.entity = entity;
        this.inventory = entity.inventory;

        cellBackground = new TextureRegionDrawable(new TextureRegion(Assets.loadTexture(Assets.cell)));
        cellActiveBackground = new TextureRegionDrawable(new TextureRegion(Assets.loadTexture(Assets.cellActive)));

        Image inventoryBackground = new Image(Assets.loadTexture(Assets.inventory));
        inventoryBackground.setPosition(Gdx.graphics.getWidth() - inventoryBackground.getWidth() - 25, (Gdx.graphics.getHeight() - inventoryBackground.getHeight()) / 2f);

        addActor(inventoryBackground);

        itemTable = new Table();
        itemTable.top();
        itemTable.left();
        setTable();

        ScrollPane scrollInventory = new ScrollPane(itemTable);
        scrollInventory.setScrollingDisabled(true, false);
        scrollInventory.setFadeScrollBars(false);
        scrollInventory.setPosition(inventoryBackground.getX() + tableOffset, inventoryBackground.getY() + tableOffset);
        scrollInventory.setSize(inventoryBackground.getWidth() - tableOffset * 2, inventoryBackground.getHeight() - tableOffset * 2);
        addActor(scrollInventory);
    }

    public void setTable() {
        itemTable.clear();
        int armorIndex = inventory.getArmorSlot();
        int swordIndex = inventory.getSwordSlot();
        int bowIndex = inventory.getBowSlot();
        for (int i = 0; i < inventory.getSize(); i++) {
            Item item = inventory.get(i);
            Table cellTable = new Table();

            if (armorIndex == i || swordIndex == i || bowIndex == i) {
                cellTable.setBackground(cellActiveBackground);
            }else{
                cellTable.background(cellBackground);
            }

            Image image = new Image(item.image);
            cellTable.add(image).width(cellSize - 5).height(cellSize - 5);

            Label itemCount = new Label(item.amount + "", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            itemCount.setFontScale(1.3f);
            itemCount.setAlignment(Align.bottomRight);

            Stack stack = new Stack();
            stack.add(cellTable);
            stack.add(itemCount);

            stack.addListener(new CellLister(item, entity));
            itemTable.add(stack).width(cellSize).height(cellSize).padRight(cellOffset).padBottom(cellOffset);

            if ((i + 1) % col == 0) {
                itemTable.row();
            }
        }
    }
}
