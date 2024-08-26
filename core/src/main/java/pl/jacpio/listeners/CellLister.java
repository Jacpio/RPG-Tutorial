package pl.jacpio.listeners;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import pl.jacpio.entities.Entity;
import pl.jacpio.huds.InventoryHUD;
import pl.jacpio.items.Item;
import pl.jacpio.screens.GameScreen;

public class CellLister extends InputListener {
    private final Item item;
    private final Entity entity;

    public CellLister(Item item, Entity entity) {
        this.item = item;
        this.entity = entity;
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            if (!item.isConsume()){
                System.out.println(item.isUse(entity));
                if (item.isUse(entity)){
                    item.unUse(entity);
                }else item.use(entity);
            }else{
                item.use(entity);
            }
            GameScreen.inventoryHUD.setTable();
        } else if (button == Input.Buttons.RIGHT) {
            item.drop(entity);
        }

        return true;
    }
}
