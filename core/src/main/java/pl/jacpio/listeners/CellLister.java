package pl.jacpio.listeners;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import pl.jacpio.entities.Entity;
import pl.jacpio.huds.InventoryHUD;
import pl.jacpio.items.Item;
import pl.jacpio.screens.GameScreen;

public class CellLister extends InputListener {
    private final Item item;
    private final Entity entity;

    private TextureRegionDrawable itemDrawable;

    public CellLister(Item item, Entity entity) {
        this.item = item;
        this.entity = entity;
        itemDrawable = new TextureRegionDrawable();
    }

    @Override
    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        itemDrawable.setRegion(item.image);
        InventoryHUD.itemImage.setDrawable(itemDrawable);
        String description = item.description ;

        InventoryHUD.description.setText(description);
        InventoryHUD.name.setText(item.name);


        super.enter(event, x, y, pointer, fromActor);
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            if (!item.isConsume()){
                if (entity.inventory.isUse(item)){
                    entity.inventory.unUse(item);
                }else item.use(entity);
            }else{
                item.use(entity);
            }
            GameScreen.inventoryHUD.setTable();
        } else if (button == Input.Buttons.RIGHT) {
            entity.inventory.drop(item);
        }

        return true;
    }
}
