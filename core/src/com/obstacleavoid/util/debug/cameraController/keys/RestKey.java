package com.obstacleavoid.util.debug.cameraController.keys;

import com.obstacleavoid.util.debug.DebugCameraConfig;
import com.obstacleavoid.util.debug.cameraController.CameraController;
import com.obstacleavoid.util.debug.cameraController.Key;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyConfig;

public class RestKey extends Key {
    public RestKey(DebugCameraConfig debugCameraConfig, KeyConfig keyReset) {
        super(debugCameraConfig, keyReset);
    }

    @Override
    protected int getKeyFromConfig() {
        return keyConfig.getKeyCode();
    }

    @Override
    public void doExecute(CameraController controller, float delta) {
        controller.reset();
    }
}
