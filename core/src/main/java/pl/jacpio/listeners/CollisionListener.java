package pl.jacpio.listeners;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import pl.jacpio.entities.Entity;
import pl.jacpio.entities.Player;
import pl.jacpio.items.Item;

public class CollisionListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Object objectA = contact.getFixtureA().getBody().getUserData();
        Object objectB = contact.getFixtureB().getBody().getUserData();
        if (objectA != null && objectB != null) {
            if (objectA instanceof Player) {
                if (objectB instanceof Item) {
                    ((Item) objectB).pickUp((Entity) objectA);
                }
            }else {
                if (objectA instanceof Item) {
                    ((Item) objectA).pickUp((Entity) objectB);
                }
            }
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold manifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse contactImpulse) {

    }
}
