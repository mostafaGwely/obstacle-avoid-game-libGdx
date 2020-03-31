package com.obstacleavoid.util.debug.cameraController;

import com.obstacleavoid.util.debug.DebugCameraConfig;
import com.obstacleavoid.util.debug.cameraController.keys.LogKey;
import com.obstacleavoid.util.debug.cameraController.keys.MoveDown;
import com.obstacleavoid.util.debug.cameraController.keys.MoveLeft;
import com.obstacleavoid.util.debug.cameraController.keys.MoveRight;
import com.obstacleavoid.util.debug.cameraController.keys.MoveUp;
import com.obstacleavoid.util.debug.cameraController.keys.RestKey;
import com.obstacleavoid.util.debug.cameraController.keys.ZoomIn;
import com.obstacleavoid.util.debug.cameraController.keys.ZoomOut;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyDown;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyLeft;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyLog;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyReset;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyRight;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyUp;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyZoomIn;
import com.obstacleavoid.util.debug.cameraController.keysconfigs.KeyZoomOut;

import java.util.ArrayList;

public class Keys extends Key {
    private ArrayList<Key> keys;

    public Keys(DebugCameraConfig debugCameraConfig) {
        super(debugCameraConfig);
        this.keys = new ArrayList<>();
        addKeys(debugCameraConfig);
    }


    @Override
    protected int getKeyFromConfig() {
        return 0;
    }

    public void addKey(Key key) {
        keys.add(key);
    }

    public void addKeys(DebugCameraConfig debugCameraConfig) {
        addKey(new MoveDown(debugCameraConfig, new KeyDown(debugCameraConfig.root)));
        addKey(new MoveUp(debugCameraConfig, new KeyUp(debugCameraConfig.root)));
        addKey(new MoveLeft(debugCameraConfig, new KeyLeft(debugCameraConfig.root)));
        addKey(new MoveRight(debugCameraConfig, new KeyRight(debugCameraConfig.root)));
        addKey(new ZoomIn(debugCameraConfig, new KeyZoomIn(debugCameraConfig.root)));
        addKey(new ZoomOut(debugCameraConfig, new KeyZoomOut(debugCameraConfig.root)));
        addKey(new LogKey(debugCameraConfig, new KeyLog(debugCameraConfig.root)));
        addKey(new RestKey(debugCameraConfig, new KeyReset(debugCameraConfig.root)));
    }

    @Override
    public void doExecute(CameraController controller, float delta) {
        for (Key key : keys)
            key.execute(controller, delta);

    }
}
