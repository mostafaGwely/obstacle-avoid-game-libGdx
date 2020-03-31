package com.obstacleavoid.util.debug.cameraController;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Logger;
import com.obstacleavoid.util.debug.DebugCameraConfig;

public class DebugCameraController2 implements CameraController {
    public static final Logger logger = new Logger(DebugCameraController2.class.getName(), Logger.DEBUG);
    //Keys
    Keys keys;
    //attributes
    private Vector2 position = new Vector2();
    private Vector2 startPosition = new Vector2();
    private float zoom = 1f;
    private DebugCameraConfig debugCameraConfig;

    //constructor
    public DebugCameraController2() {
        debugCameraConfig = new DebugCameraConfig();
        logger.info("camera config: " + debugCameraConfig);
        keys = new Keys(debugCameraConfig);


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

        //handle clicks
        keys.doExecute(this, delta);

    }

    //private methods
    private void setPosition(float x, float y) {
        position.x = x;
        position.y = y;
    }

    public void moveCamera(float xSpeed, float ySpeed) {
        position.set(position.x + xSpeed, position.y + ySpeed);
    }


    public void setZoom(float value) {
        zoom = MathUtils.clamp(value, debugCameraConfig.getMaxZoomIn(), debugCameraConfig.getMaxZoomOut());
    }

    public void updateZoom(float value) {
        zoom = MathUtils.clamp(zoom + value, debugCameraConfig.getMaxZoomIn(), debugCameraConfig.getMaxZoomOut());
    }


    public void reset() {
        setPosition(startPosition.x, startPosition.y);
        setZoom(1.0f);
    }

    public void logDebug() {
        logger.debug("position= " + position + ", zoom= " + zoom);
    }


}
