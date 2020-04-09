package com.obstacleavoid.screen.loading;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.obstacleavoid.ObstacleAvoidGame;
import com.obstacleavoid.assets.AssetsDescriptor;
import com.obstacleavoid.config.GameConfig;
import com.obstacleavoid.screen.menu.MenuScreen;
import com.obstacleavoid.util.GdxUtils;

public class LoadingScreen extends ScreenAdapter {
    public static final float PROGRESS_BAR_WIDTH = GameConfig.HUD_WIDTH / 2;
    public static final float PROGRESS_BAR_HEIGHT = 50;
    private final ObstacleAvoidGame obstacleAvoidGame;
    private final AssetManager assetManager;
    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer shapeRenderer;
    private BitmapFont bitmapFont;
    private SpriteBatch spriteBatch;
    private float progress;
    private float waitTime = 0.75f;

    public LoadingScreen(ObstacleAvoidGame obstacleAvoidGame) {
        this.obstacleAvoidGame = obstacleAvoidGame;
        this.assetManager = obstacleAvoidGame.getAssetManager();
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.HUD_WIDTH, GameConfig.HUD_HEIGHT, camera);
        shapeRenderer = new ShapeRenderer();

        bitmapFont = new BitmapFont();
        spriteBatch = new SpriteBatch();

        assetManager.load(AssetsDescriptor.FONT);
        assetManager.load(AssetsDescriptor.GAME_PLAY);
        assetManager.load(AssetsDescriptor.UI);
//        assetManager.load(AssetsDescriptor.UI_SKIN);
    }

    @Override
    public void render(float delta) {
        GdxUtils.clearScreen();
        viewport.apply();
        shapeRenderer.setProjectionMatrix(camera.combined);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        draw();

        shapeRenderer.end();

        update(delta);
    }

    private void draw() {
        float progressBarX = (GameConfig.HUD_WIDTH - PROGRESS_BAR_WIDTH) / 2f;
        float progressBarY = (GameConfig.HUD_HEIGHT - PROGRESS_BAR_HEIGHT) / 2f;

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        bitmapFont.draw(spriteBatch, progress * 100 + "%", progressBarX, progressBarY - 40);
        spriteBatch.end();
        shapeRenderer.rect(progressBarX, progressBarY, PROGRESS_BAR_WIDTH * progress, PROGRESS_BAR_HEIGHT);
    }

    private void update(float delta) {

        //progress between 0 and 1
        progress = assetManager.getProgress();

        if (assetManager.update()) {
            waitTime -= delta;
            if (waitTime <= 0)
                obstacleAvoidGame.setScreen(new MenuScreen(obstacleAvoidGame));
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        spriteBatch.dispose();
        bitmapFont.dispose();
    }
}
