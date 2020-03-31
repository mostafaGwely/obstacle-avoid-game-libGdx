package com.obstacleavoid.util.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Logger;

public class DebugCameraConfig {
    public static final Logger logger = new Logger(DebugCameraConfig.class.getName(), Logger.DEBUG);

    //constants
    private static final int DEFAULT_LEFT_KEY = Input.Keys.A;
    private static final int DEFAULT_RIGHT_KEY = Input.Keys.D;
    private static final int DEFAULT_UP_KEY = Input.Keys.W;
    private static final int DEFAULT_DOWN_KEY = Input.Keys.S;

    private static final int DEFAULT_ZOOM_IN_KEY = Input.Keys.COMMA;
    private static final int DEFAULT_ZOOM_OUT_KEY = Input.Keys.PERIOD;
    private static final int DEFAULT_ZOOM_RESET_KEY = Input.Keys.BACKSPACE;
    private static final int DEFAULT_LOG_KEY = Input.Keys.ENTER;


    private static final float DEFAULT_MOVE_SPEED = 20.0F;
    private static final float DEFAULT_ZOOM_SPEED = 20;
    private static final float DEFAULT_MAX_ZOOM_IN = 0.20f;
    private static final float DEFAULT_MAX_ZOOM_OUT = 30;

    private static final String FILE_PATH = "debug/debugCameraConfig.json";

    //attributes
    private float maxZoomIn;
    private float maxZoomOut;
    private float zoomSpeed;
    private int zoomInKey;
    private int zoomOutKey;
    private int restKey;

    private float moveSpeed;

    private int upKey;
    private int leftKey;
    private int downKey;
    private int rightKey;

    private int logKey;

    private FileHandle fileHandle;
    //constructor

    public DebugCameraConfig() {
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
        zoomInKey = DEFAULT_ZOOM_IN_KEY;
        zoomOutKey = DEFAULT_ZOOM_OUT_KEY;
        restKey = DEFAULT_ZOOM_RESET_KEY;
        moveSpeed = DEFAULT_MOVE_SPEED;
        upKey = DEFAULT_UP_KEY;
        leftKey = DEFAULT_LEFT_KEY;
        downKey = DEFAULT_DOWN_KEY;
        rightKey = DEFAULT_RIGHT_KEY;
        logKey = DEFAULT_LOG_KEY;
    }

    private void load() {
        try {
            JsonReader jsonReader = new JsonReader();
            JsonValue root = jsonReader.parse(fileHandle);
            maxZoomIn = root.getFloat("maxZoomIn", DEFAULT_MAX_ZOOM_IN);
            maxZoomOut = root.getFloat("maxZoomOut", DEFAULT_MAX_ZOOM_OUT);

            zoomSpeed = root.getFloat("zoomSpeed", DEFAULT_MOVE_SPEED);

            zoomInKey = getInputKeyValue(root, "zoomInKey", DEFAULT_ZOOM_IN_KEY);
            zoomOutKey = getInputKeyValue(root, "zoomOutKey", DEFAULT_ZOOM_OUT_KEY);
            restKey = getInputKeyValue(root, "restKey", DEFAULT_ZOOM_RESET_KEY);
            moveSpeed = getInputKeyValue(root, "moveSpeed", DEFAULT_MOVE_SPEED);
            upKey = getInputKeyValue(root, "upKey", DEFAULT_UP_KEY);
            leftKey = getInputKeyValue(root, "leftKey", DEFAULT_LEFT_KEY);
            downKey = getInputKeyValue(root, "downKey", DEFAULT_DOWN_KEY);
            rightKey = getInputKeyValue(root, "rightKey", DEFAULT_RIGHT_KEY);
            logKey = getInputKeyValue(root, "logKey", DEFAULT_LOG_KEY);

        } catch (Exception e) {
            logger.error("error loading " + FILE_PATH + " using defaults", e);
            setupDefaults();
        }
    }

    private int getInputKeyValue(JsonValue root, String name, int defaultInput) {
        String keyString = root.getString(name);
        if (keyString == null) {
            return defaultInput;
        }
        return Input.Keys.valueOf(keyString);

    }
    private float getInputKeyValue(JsonValue root, String name, float defaultInput) {
        String keyString = root.getString("downKey");
        if (keyString == null) {
            return defaultInput;
        }
        return Input.Keys.valueOf(keyString);

    }

    //to string
    @Override
    public String toString() {
        return "DebugCameraConfig{" +
                "maxZoomIn=" + maxZoomIn +
                ", maxZoomOut=" + maxZoomOut +
                ", zoomSpeed=" + zoomSpeed +
                ", zoomInKey=" + zoomInKey +
                ", zoomOutKey=" + zoomOutKey +
                ", restKey=" + restKey +
                ", moveSpeed=" + moveSpeed +
                ", upKey=" + upKey +
                ", leftKey=" + leftKey +
                ", downKey=" + downKey +
                ", rightKey=" + rightKey +
                ", logKey=" + logKey +
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

    //input polling for arrows
    public boolean isLeftPressed(){
        return Gdx.input.isKeyPressed(leftKey);

    }
    public boolean isRightPressed(){
        return Gdx.input.isKeyPressed(rightKey);
    }
    public boolean isDownPressed(){
        return Gdx.input.isKeyPressed(downKey);
    }
    public boolean isUpPressed(){
        return Gdx.input.isKeyPressed(upKey);
    }
    //input polling for zooming
    public boolean isZoomInPressed(){
        return Gdx.input.isKeyPressed(zoomInKey);
    }
    public boolean isZoomOutPressed(){
        return Gdx.input.isKeyPressed(zoomOutKey);
    }
    public boolean isResetPressed(){
        return Gdx.input.isKeyPressed(restKey);
    }
    //input polling for logging
    public boolean isLogPressed(){
         return Gdx.input.isKeyPressed(logKey);
    }

}
