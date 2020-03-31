package com.obstacleavoid.util.debug.cameraController.keys;

import com.obstacleavoid.util.debug.DebugCameraConfig;
import com.obstacleavoid.util.debug.cameraController.CameraController;
import com.obstacleavoid.util.debug.cameraController.Key;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyConfig;

public class ZoomIn extends Key {
    public ZoomIn(DebugCameraConfig debugCameraConfig, KeyConfig keyZoomIn) {
        super(debugCameraConfig, keyZoomIn);
    }

    @Override
    protected int getKeyFromConfig() {
        return keyConfig.getKeyCode();
    }

    @Override
    public void doExecute(CameraController controller, float delta) {
        float zoomSpeed = debugCameraConfig.getZoomSpeed() * delta;
        controller.updateZoom(zoomSpeed);

    }
}
