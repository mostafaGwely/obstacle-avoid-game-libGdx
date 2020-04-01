package com.obstacleavoid.entity;

import com.badlogic.gdx.math.Intersector;

/**
 * Created by goran on 23/08/2016.
 */
public class Obstacle extends GameObjectBase {

    private static final float BOUNDS_RADIUS = 0.2f; // world units
    private static final float SIZE = 2 * BOUNDS_RADIUS;


    private float ySpeed = 0.2f;


    public Obstacle() {
        super(BOUNDS_RADIUS);
    }


    public void update(float delta) {
        float speed = delta * ySpeed;
        setPosition(getX(), getY() - speed);
        updateBounds();
    }


    public float getBoundsRadius() {
        return BOUNDS_RADIUS;
    }

    public boolean isPlayerColliding(Player player) {
        return Intersector.overlaps(player.bounds, this.bounds);
    }

}
