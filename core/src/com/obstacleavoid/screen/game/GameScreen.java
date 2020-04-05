package com.obstacleavoid.screen.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.obstacleavoid.ObstacleAvoidGame;

/**
 * Created by goran on 27/08/2016.
 */
public class GameScreen implements Screen {

    private GameController controller;
    private GameRenderer renderer;

    private final AssetManager assetManager;
    private ObstacleAvoidGame obstacleAvoidGame;

    public GameScreen(ObstacleAvoidGame obstacleAvoidGame) {
        this.obstacleAvoidGame = obstacleAvoidGame;
        assetManager = obstacleAvoidGame.getAssetManager();
    }

    @Override
    public void show() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        controller = new GameController();
        renderer = new GameRenderer(assetManager, controller);
    }

    @Override
    public void render(float delta) {
        controller.update(delta);
        renderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        renderer.resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
