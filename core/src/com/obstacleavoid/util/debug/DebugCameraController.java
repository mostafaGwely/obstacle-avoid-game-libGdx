package com.obstacleavoid.util.debug;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Logger;

public class DebugCameraController {
    public static final Logger logger = new Logger(DebugCameraController.class.getName(), Logger.DEBUG);


    //attributes
    private Vector2 position = new Vector2();
    private Vector2 startPosition = new Vector2();
    private float zoom = 1f;
    private DebugCameraConfig debugCameraConfig;

    //constructor
    public DebugCameraController() {
        debugCameraConfig = new DebugCameraConfig();
        logger.info("camera config: "+ debugCameraConfig);
    }

    //public methods
    public void setStartPosition(float x, float y) {
        startPosition.set(x, y);
        position.set(x, y);
    }

    public void applyTo(OrthographicCamera camera) {
        camera.position.set(position, 0);
        camera.zoom = zoom;
        camera.update();
    }

    public void handleDebugInput(float delta) {
        if (Gdx.app.getType() != Application.ApplicationType.Desktop)
            return;
        float moveSpeed = debugCameraConfig.getMoveSpeed() * delta;
        float zoomSpeed = debugCameraConfig.getZoomSpeed() * delta;

        //move controllers
        if (debugCameraConfig.isLeftPressed())//left
        {
             moveLeft(moveSpeed);
        }
        if (debugCameraConfig.isRightPressed())//right
            moveRight(moveSpeed);
        if (debugCameraConfig.isUpPressed()) //up
            moveUp(moveSpeed);
        if (debugCameraConfig.isDownPressed())//down
            moveDown(moveSpeed);

        //zoom controllers
        if (debugCameraConfig.isZoomInPressed()) //zoom in
            zoomIn(zoomSpeed);
        if (debugCameraConfig.isZoomOutPressed())//zoom out
            zoomOut(zoomSpeed);
        if (debugCameraConfig.isResetPressed()) //reset zoom
            zoomReset();
        if (debugCameraConfig.isLogPressed()) //log
            logDebug();


    }

    //private methods
    private void setPosition(float x, float y) {
        position.x = x;
        position.y = y;
    }

    private void moveCamera(float xSpeed, float ySpeed) {
        position.set(position.x + xSpeed, position.y + ySpeed);
    }

    private void moveDown(float speed) {
        moveCamera(0, -speed);
    }

    private void moveUp(float speed) {
        moveCamera(0, speed);
    }

    private void moveRight(float speed) {
        moveCamera(speed, 0);
    }

    private void moveLeft(float speed) {
        moveCamera(-speed, 0);
    }

    private void setZoom(float value) {
        zoom = MathUtils.clamp(value, debugCameraConfig.getMaxZoomIn(), debugCameraConfig.getMaxZoomOut());
    }

    private void zoomIn(float zoomSpeed) {
        setZoom(zoom + zoomSpeed);
    }

    private void zoomOut(float zoomSpeed) {
        setZoom(zoom - zoomSpeed);
    }

    private void zoomReset() {
        setPosition(startPosition.x,startPosition.y);
        setZoom(1.0f);
    }

    private void logDebug() {
        logger.debug("position= " + position + ", zoom= " + zoom);
    }

}
