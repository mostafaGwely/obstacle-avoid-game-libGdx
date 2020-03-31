package com.obstacleavoid.util.debug.cameraController.keys;

import com.obstacleavoid.util.debug.DebugCameraConfig;
import com.obstacleavoid.util.debug.cameraController.CameraController;
import com.obstacleavoid.util.debug.cameraController.Key;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyConfig;

public class ZoomOut extends Key {
    public ZoomOut(DebugCameraConfig debugCameraConfig, KeyConfig keyZoomOut) {
        super(debugCameraConfig, keyZoomOut);
    }

    @Override
    protected int getKeyFromConfig() {
        return keyConfig.getKeyCode();
    }

    @Override
    public void doExecute(CameraController controller, float delta) {
        float zoomSpeed = debugCameraConfig.getZoomSpeed() * delta;
        controller.updateZoom(-zoomSpeed);

    }
}
