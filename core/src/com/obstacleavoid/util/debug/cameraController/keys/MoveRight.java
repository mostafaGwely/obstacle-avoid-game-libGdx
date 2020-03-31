package com.obstacleavoid.util.debug.cameraController.keys;

import com.obstacleavoid.util.debug.DebugCameraConfig;
import com.obstacleavoid.util.debug.cameraController.CameraController;
import com.obstacleavoid.util.debug.cameraController.Key;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyConfig;

public class MoveRight extends Key {
    public MoveRight(DebugCameraConfig debugCameraConfig, KeyConfig keyRight) {
        super(debugCameraConfig, keyRight);
    }


    @Override
    public void doExecute(CameraController controller, float delta) {
        float moveSpeed = debugCameraConfig.getMoveSpeed() * delta;
        controller.moveCamera(moveSpeed, 0);

    }
}
