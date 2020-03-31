package com.obstacleavoid.util.debug.cameraController.keysconfigs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.JsonValue;

public class KeyReset extends KeyConfig {

    private static final int DEFAULT_ZOOM_RESET_KEY = Input.Keys.BACKSPACE;

    public KeyReset(JsonValue root) {
        super(root);
    }

    @Override
    public int getKeyCode() {
        return getInputKeyValue("restKey", DEFAULT_ZOOM_RESET_KEY);
    }
}
