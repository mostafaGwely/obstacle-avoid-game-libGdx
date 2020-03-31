package com.obstacleavoid.util.debug.cameraController.keysconfigs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.JsonValue;

public class KeyDown extends KeyConfig {
    private static final int DEFAULT_DOWN_KEY = Input.Keys.S;

    public KeyDown(JsonValue root) {
        super(root);
    }

    @Override
    public int getKeyCode() {
        return getInputKeyValue("downKey", DEFAULT_DOWN_KEY);
    }
}
