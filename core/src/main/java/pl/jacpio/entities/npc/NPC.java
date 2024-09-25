package pl.jacpio.entities.npc;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.entities.Entity;
import pl.jacpio.entities.components.DialogueData;

public class NPC extends Entity {
    public DialogueData dialogueData;
    public NPC(float x, float y, World world, SpriteBatch batch) {
        super(world, batch);
        createBody(x,y,14,32);
    }
}
