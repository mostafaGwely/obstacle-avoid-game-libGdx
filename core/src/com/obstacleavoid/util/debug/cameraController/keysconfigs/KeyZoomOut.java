package com.obstacleavoid.util.debug.cameraController.keysconfigs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.JsonValue;

public class KeyZoomOut extends KeyConfig {

    private static final int DEFAULT_ZOOM_OUT_KEY = Input.Keys.PERIOD;

    public KeyZoomOut(JsonValue root) {
        super(root);
    }

    @Override
    public int getKeyCode() {
        return getInputKeyValue("zoomOutKey", DEFAULT_ZOOM_OUT_KEY);
    }
}
