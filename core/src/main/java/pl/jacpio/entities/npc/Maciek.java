package pl.jacpio.entities.npc;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.utilities.Assets;
import pl.jacpio.utilities.JsonLoader;

public class Maciek extends NPC{
    public static final int ID = 0;
    public Maciek(float x, float y, World world, SpriteBatch batch) {
        super(x, y, world, batch);
        name = "Maciek";
        setAnimation(Assets.getTexture(Assets.NPC_MACIEK),32);
        dialogueData = JsonLoader.loadDialogues("dialogues/maciek/dialogue.json");
        System.out.println(dialogueData.toString());
    }
}
