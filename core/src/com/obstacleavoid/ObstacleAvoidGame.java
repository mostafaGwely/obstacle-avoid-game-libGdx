package com.obstacleavoid;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.obstacleavoid.screen.GameScreen;

public class ObstacleAvoidGame extends Game {
    private AssetManager assetManager;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        assetManager = new AssetManager();
        assetManager.getLogger().setLevel(Application.LOG_DEBUG);

        setScreen(new GameScreen(this));
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }
}
