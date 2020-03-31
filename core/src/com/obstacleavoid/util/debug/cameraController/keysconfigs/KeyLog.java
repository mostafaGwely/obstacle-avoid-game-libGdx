package com.obstacleavoid.util.debug.cameraController.keysconfigs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.JsonValue;

public class KeyLog extends KeyConfig {

    private static final int DEFAULT_LOG_KEY = Input.Keys.ENTER;

    public KeyLog(JsonValue root) {
        super(root);
    }

    @Override
    public int getKeyCode() {
        return getInputKeyValue("logKey", DEFAULT_LOG_KEY);
    }
}
