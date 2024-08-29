package pl.jacpio.utiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import pl.jacpio.items.*;

public class ItemRecognizer {
    public static Item recognize(Item item) {
        return switch (item.id) {
            case Apple.ID -> new Apple();
            case IronArmor.ID -> new IronArmor();
            case IronSword.ID -> new IronSword();
            case RubinSword.ID -> new RubinSword();
            case WoodenBow.ID -> new WoodenBow();
            default -> null;
        };
    }
    public static Item recognize(Item item, float x, float y, SpriteBatch batch, World world) {
        return switch (item.id) {
            case Apple.ID -> new Apple(x,y,batch,world);
            case IronArmor.ID -> new IronArmor(x,y,batch,world);
            case IronSword.ID -> new IronSword(x,y,batch,world);
            case RubinSword.ID -> new RubinSword(x,y,batch,world);
            case WoodenBow.ID -> new WoodenBow(x,y,batch,world);
            default -> null;
        };
    }
}
