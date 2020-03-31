package com.obstacleavoid.util.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Logger;

public class DebugCameraConfig {
    public static final Logger logger = new Logger(DebugCameraConfig.class.getName(), Logger.DEBUG);

    //constants
    private static final float DEFAULT_MOVE_SPEED = 20.0F;
    private static final float DEFAULT_ZOOM_SPEED = 20;
    private static final float DEFAULT_MAX_ZOOM_IN = 0.20f;
    private static final float DEFAULT_MAX_ZOOM_OUT = 30;

    private static final String FILE_PATH = "debug/debugCameraConfig.json";

    //attributes
    private float maxZoomIn;
    private float maxZoomOut;
    private float zoomSpeed;


    private float moveSpeed;


    private FileHandle fileHandle;
    public JsonValue root;
    //constructor


    public DebugCameraConfig() {
        JsonReader jsonReader = new JsonReader();
        fileHandle = Gdx.files.internal(FILE_PATH);
        root = jsonReader.parse(fileHandle);
        init();
    }

    private void init() {
        fileHandle = Gdx.files.internal(FILE_PATH);
        if (fileHandle.exists()) {
            load();
        } else {
            logger.info("using defaults, file doesn't exit: " + FILE_PATH);
            setupDefaults();
        }
    }

    private void setupDefaults() {
        maxZoomIn = DEFAULT_MAX_ZOOM_IN;
        maxZoomOut = DEFAULT_MAX_ZOOM_OUT;
        zoomSpeed = DEFAULT_ZOOM_SPEED;
        moveSpeed = DEFAULT_MOVE_SPEED;
    }

    private void load() {
        try {

            maxZoomIn = root.getFloat("maxZoomIn", DEFAULT_MAX_ZOOM_IN);
            maxZoomOut = root.getFloat("maxZoomOut", DEFAULT_MAX_ZOOM_OUT);

            zoomSpeed = root.getFloat("zoomSpeed", DEFAULT_MOVE_SPEED);

            moveSpeed = root.getFloat("moveSpeed", DEFAULT_MOVE_SPEED);

        } catch (Exception e) {
            logger.error("error loading " + FILE_PATH + " using defaults", e);
            setupDefaults();
        }
    }


    //to string
    @Override
    public String toString() {
        return "DebugCameraConfig{" +
                "maxZoomIn=" + maxZoomIn +
                ", maxZoomOut=" + maxZoomOut +
                ", zoomSpeed=" + zoomSpeed +

                ", moveSpeed=" + moveSpeed +

                ", fileHandle=" + fileHandle +
                '}';
    }
    //getters and setters

    public float getZoomSpeed() {
        return zoomSpeed;
    }

    public float getMoveSpeed() {
        return moveSpeed;
    }

    public float getMaxZoomIn() {
        return maxZoomIn;
    }

    public float getMaxZoomOut() {
        return maxZoomOut;
    }


}
