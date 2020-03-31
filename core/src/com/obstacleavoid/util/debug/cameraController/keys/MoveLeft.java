package com.obstacleavoid.util.debug.cameraController.keys;

import com.obstacleavoid.util.debug.DebugCameraConfig;
import com.obstacleavoid.util.debug.cameraController.CameraController;
import com.obstacleavoid.util.debug.cameraController.Key;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyConfig;

public class MoveLeft extends Key {
    public MoveLeft(DebugCameraConfig debugCameraConfig, KeyConfig keyLeft) {
        super(debugCameraConfig, keyLeft);
    }

    @Override
    protected int getKeyFromConfig() {
        return keyConfig.getKeyCode();
    }

    @Override
    public void doExecute(CameraController controller, float delta) {
        float moveSpeed = debugCameraConfig.getMoveSpeed() * delta;
        controller.moveCamera(-moveSpeed, 0);

    }
}
