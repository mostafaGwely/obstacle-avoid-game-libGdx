package com.obstacleavoid.util.debug.cameraController.keys;

import com.obstacleavoid.util.debug.DebugCameraConfig;
import com.obstacleavoid.util.debug.cameraController.CameraController;
import com.obstacleavoid.util.debug.cameraController.Key;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyConfig;

public class LogKey extends Key {
    public LogKey(DebugCameraConfig debugCameraConfig, KeyConfig keyLog) {
        super(debugCameraConfig, keyLog);
    }

    @Override
    protected int getKeyFromConfig() {
        return keyConfig.getKeyCode();
    }

    @Override
    public void doExecute(CameraController controller, float delta) {
        controller.logDebug();
    }
}
