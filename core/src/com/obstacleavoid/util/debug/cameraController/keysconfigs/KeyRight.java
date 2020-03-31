package com.obstacleavoid.util.debug.cameraController.keysconfigs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.JsonValue;

public class KeyRight extends KeyConfig {

    private static final int DEFAULT_RIGHT_KEY = Input.Keys.D;

    public KeyRight(JsonValue root) {
        super(root);
    }

    @Override
    public int getKeyCode() {
        return getInputKeyValue("rightKey", DEFAULT_RIGHT_KEY);
    }
}
