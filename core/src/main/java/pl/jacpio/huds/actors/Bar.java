package pl.jacpio.huds.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import pl.jacpio.utilities.Assets;
import pl.jacpio.utilities.TextureOperation;

public class Bar extends Actor {
    private final Texture background;
    private final Texture front;
    private float value = 0;
    private float maxValue = 1;

    private float offsetX = 3;
    private float offsetY = 3;

    public Bar(float maxValue, float r, float g, float b) {
        this.maxValue = maxValue;
        this.background = Assets.getTexture(Assets.barBackground);
        this.front = TextureOperation.createColorTexture(r,g,b,1);
        this.setSize(background.getWidth(), background.getHeight());
        if (maxValue <= 0) {
            throw new IllegalArgumentException("maxValue must be greater than 0");
        }
    }
    public void setValue(float value) {
        if (value > maxValue) {
            maxValue = value;
        }else this.value = value;
    }
    public void setMaxValue(float maxValue) {
        if (maxValue <= 0) {
            throw new IllegalArgumentException("maxValue must be greater than 0");
        }
        if (maxValue < value) {
            maxValue = value;
        }
        this.maxValue = maxValue;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(background, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        batch.draw(front, this.getX() + offsetX, this.getY() + offsetY, (this.getWidth() - offsetX * 2) * value/maxValue, this.getHeight() - offsetY * 2);
    }
}
