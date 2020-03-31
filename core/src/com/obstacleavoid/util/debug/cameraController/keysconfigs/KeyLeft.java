package com.obstacleavoid.util.debug.cameraController.keysconfigs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.JsonValue;

public class KeyLeft extends KeyConfig {

    private static final int DEFAULT_LEFT_KEY = Input.Keys.A;

    public KeyLeft(JsonValue root) {
        super(root);
    }

    @Override
    public int getKeyCode() {
        return getInputKeyValue("leftKey", DEFAULT_LEFT_KEY);
    }
}
