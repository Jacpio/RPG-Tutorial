package pl.jacpio.huds;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.Viewport;
import pl.jacpio.entities.Player;
import pl.jacpio.huds.actors.Bar;
import pl.jacpio.utilities.Assets;

public class PlayerHUD extends Stage {
    private final Player player;
    public static Bar lifeBar, manaBar;
    public Image lifeIcon, manaIcon;
    public PlayerHUD(Viewport viewport, Batch batch, Player player) {
        super(viewport, batch);
        this.player = player;
        lifeBar = new Bar(player.maxLife, 1,0,0);
        lifeBar.setPosition(25,25);
        lifeBar.setValue(player.life);

        manaBar = new Bar(player.maxMana, 0,0,1);
        manaBar.setPosition(25,100);
        manaBar.setValue(player.mana);

        lifeIcon = new Image(Assets.getTexture(Assets.LIFE_ICON));
        manaIcon = new Image(Assets.getTexture(Assets.MANA_ICON));
        lifeIcon.setScale(2.3f);
        manaIcon.setScale(2.3f);
        lifeIcon.setPosition( lifeBar.getWidth(), 25);
        manaIcon.setPosition( manaBar.getWidth(), 100);

        addActor(manaIcon);
        addActor(lifeIcon);

        addActor(lifeBar);
        addActor(manaBar);
    }
}
