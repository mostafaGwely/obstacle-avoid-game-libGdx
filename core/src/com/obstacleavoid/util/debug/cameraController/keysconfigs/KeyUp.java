package com.obstacleavoid.util.debug.cameraController.keysconfigs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.JsonValue;

public class KeyUp extends KeyConfig {
    private static final int DEFAULT_UP_KEY = Input.Keys.W;

    public KeyUp(JsonValue root) {
        super(root);
    }

    @Override
    public int getKeyCode() {
        return getInputKeyValue("upKey", DEFAULT_UP_KEY);
    }
}
