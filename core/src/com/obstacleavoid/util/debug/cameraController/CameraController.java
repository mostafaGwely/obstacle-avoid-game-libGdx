package com.obstacleavoid.util.debug.cameraController;

public interface CameraController {
    void moveCamera(float xSpeed, float ySpeed);

    void updateZoom(float value);

    void logDebug();

    void reset();

}
