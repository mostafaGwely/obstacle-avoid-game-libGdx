package com.obstacleavoid.util.debug.cameraController;

import com.badlogic.gdx.Gdx;
import com.obstacleavoid.util.debug.DebugCameraConfig;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyConfig;

public abstract class Key {
    public DebugCameraConfig debugCameraConfig;
    public KeyConfig keyConfig;

    int key;

    public Key(DebugCameraConfig debugCameraConfig) {
        this.debugCameraConfig = debugCameraConfig;
        key = getKeyFromConfig();
    }

    public Key(DebugCameraConfig debugCameraConfig, KeyConfig keyConfig) {
        this.debugCameraConfig = debugCameraConfig;
        this.keyConfig = keyConfig;
        key = getKeyFromConfig();
    }

    public boolean isClicked() {
        return Gdx.input.isKeyPressed(key);
    }

    protected int getKeyFromConfig() {
        return keyConfig.getKeyCode();
    }

    public void execute(CameraController controller, float delta) {
        if (isClicked())
            doExecute(controller, delta);
    }

    public abstract void doExecute(CameraController controller, float delta);
}
