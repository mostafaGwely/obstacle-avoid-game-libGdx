package com.obstacleavoid.util.debug.cameraController.keys;

import com.obstacleavoid.util.debug.DebugCameraConfig;
import com.obstacleavoid.util.debug.cameraController.CameraController;
import com.obstacleavoid.util.debug.cameraController.Key;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyDown;

public class MoveDown extends Key {
    public MoveDown(DebugCameraConfig debugCameraConfig, KeyDown keyDown) {
        super(debugCameraConfig, keyDown);
    }

    @Override
    protected int getKeyFromConfig() {
        return keyConfig.getKeyCode();
    }

    @Override
    public void doExecute(CameraController controller, float delta) {
        float moveSpeed = debugCameraConfig.getMoveSpeed() * delta;
        controller.moveCamera(0, -moveSpeed);

    }
}
