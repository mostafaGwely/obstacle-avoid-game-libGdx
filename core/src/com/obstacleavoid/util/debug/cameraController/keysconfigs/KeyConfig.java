package com.obstacleavoid.util.debug.cameraController.keysconfigs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.JsonValue;

public abstract class KeyConfig {
    protected JsonValue root;

    public KeyConfig(JsonValue root) {
        this.root = root;
    }

    protected float getInputKeyValue(String name, float defaultInput) {
        String keyString = root.getString(name);
        if (keyString == null) {
            return defaultInput;
        }
        return Input.Keys.valueOf(keyString);

    }

    protected int getInputKeyValue(String name, int defaultInput) {
        String keyString = root.getString(name);
        if (keyString == null) {
            return defaultInput;
        }
        return Input.Keys.valueOf(keyString);

    }

    public abstract int getKeyCode();
}
