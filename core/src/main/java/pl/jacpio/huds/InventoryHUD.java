package pl.jacpio.huds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
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
    private int cornerOffset = 9;
    private int col = 8;
    Table itemTable;

    private TextureRegionDrawable cellBackground;
    private TextureRegionDrawable cellActiveBackground;

    public static Label name;
    public static Label description;
    public static Image itemImage;


    public InventoryHUD(Viewport viewport, Batch batch, Entity entity) {
        super(viewport, batch);
        this.entity = entity;
        this.inventory = entity.inventory;

        cellBackground = new TextureRegionDrawable(new TextureRegion(Assets.getTexture(Assets.cell)));
        cellActiveBackground = new TextureRegionDrawable(new TextureRegion(Assets.getTexture(Assets.cellActive)));

        Image inventoryBackground = new Image(Assets.getTexture(Assets.inventory));
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

        Image itemDescription = new Image(Assets.getTexture(Assets.itemDescription));
        itemDescription.setPosition(25,25);
        addActor(itemDescription);

        name = new Label("Name", new Label.LabelStyle(Assets.getFont(Assets.mainFont), Color.WHITE));
        name.setSize(itemDescription.getWidth() - cornerOffset * 2, itemDescription.getHeight()/5);
        name.setPosition(itemDescription.getX() + cornerOffset,itemDescription.getY() - cornerOffset + itemDescription.getHeight() - name.getHeight());
        addActor(name);

        description = new Label("Description", new Label.LabelStyle(Assets.getFont(Assets.mainFont), Color.WHITE));
        description.setSize(itemDescription.getWidth() - cornerOffset * 2, itemDescription.getHeight() - cornerOffset * 2 - name.getHeight());
        description.setPosition(itemDescription.getX() + cornerOffset,itemDescription.getY() + cornerOffset);
        description.setAlignment(Align.topLeft);
        description.setFontScale(0.6f);
        addActor(description);

        Image itemPreview = new Image(Assets.getTexture(Assets.itemPreview));
        itemPreview.setPosition(25 + itemDescription.getWidth()/2f - itemPreview.getWidth()/2f, Gdx.graphics.getHeight()/2f);
        addActor(itemPreview);

        itemImage = new Image();
        itemImage.setPosition(itemPreview.getX() + cornerOffset,itemPreview.getY() + cornerOffset);
        itemImage.setSize(itemPreview.getWidth() - cornerOffset * 2, itemPreview.getWidth() - cornerOffset * 2);
        addActor(itemImage);


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

            Label itemCount = new Label(item.amount + "", new Label.LabelStyle(Assets.getFont(Assets.mainFont), Color.WHITE));
            itemCount.setFontScale(0.5f);
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
