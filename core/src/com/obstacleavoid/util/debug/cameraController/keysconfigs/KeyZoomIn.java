package com.obstacleavoid.util.debug.cameraController.keysconfigs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.JsonValue;

public class KeyZoomIn extends KeyConfig {

    private static final int DEFAULT_ZOOM_IN_KEY = Input.Keys.COMMA;

    public KeyZoomIn(JsonValue root) {
        super(root);
    }

    @Override
    public int getKeyCode() {
        return getInputKeyValue("zoomInKey", DEFAULT_ZOOM_IN_KEY);
    }
}
