package com.obstacleavoid.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.obstacleavoid.config.GameConfig;
import com.obstacleavoid.screen.GameRenderer;

/**
 * Created by goran on 23/08/2016.
 */
public class Player extends GameObjectBase {

    private static final float BOUNDS_RADIUS = 0.4f; // world units
    private static final float SIZE = 2 * BOUNDS_RADIUS;

    public Player() {
        super(BOUNDS_RADIUS);
    }

    public void update() {
        float xSpeed = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            xSpeed = GameConfig.MAX_PLAYER_X_SPEED;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            xSpeed = -GameConfig.MAX_PLAYER_X_SPEED;
        }
        Vector2 mousePosition = new Vector2(Gdx.input.getX(), Gdx.input.getY());
        GameRenderer.getViewPort().unproject(mousePosition);

        xSpeed = mousePosition.x - getX();


        setX(getX() + xSpeed);
        updateBounds();
    }

    public float getHeight() {
        return SIZE;
    }

    public float getWidth() {
        return SIZE;
    }
}
