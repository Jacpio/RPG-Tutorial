package pl.jacpio;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.jacpio.screens.GameScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Launcher extends Game {
    private SpriteBatch batch;
    @Override
    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new GameScreen(batch));
    }

    @Override
    public void dispose() {
        batch.dispose();
        super.dispose();
    }
}
