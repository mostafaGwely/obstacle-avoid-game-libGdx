package com.obstacleavoid.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.obstacleavoid.config.GameConfig;
import com.obstacleavoid.entity.Obstacle;
import com.obstacleavoid.entity.Player;
import com.obstacleavoid.util.GdxUtils;
import com.obstacleavoid.util.ViewportUtils;
import com.obstacleavoid.util.debug.DebugCameraController;

import java.util.ArrayList;

/**
 * Created by goran on 22/08/2016.
 */
public class GameScreen implements Screen {

//    private static final Logger log = new Logger(GameScreen.class.getName(), Logger.DEBUG);

    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer renderer;
    private DebugCameraController debugCameraController;
    private Player player;
    private ArrayList<Obstacle> obstacles = new ArrayList<>();
    private float obstacleTimer = GameConfig.OBSTACLE_SPAWN_TIME;

    private boolean alive = true;

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);
        renderer = new ShapeRenderer();
        debugCameraController = new DebugCameraController();
        debugCameraController.setStartPosition(GameConfig.WORLD_CENTER_X, GameConfig.WORLD_CENTER_Y);

        // create player
        player = new Player();

        // calculate position
        float startPlayerX = GameConfig.WORLD_WIDTH / 2f;
        float startPlayerY = 1;


        // position player
        player.setPosition(startPlayerX, startPlayerY);
    }

    @Override
    public void render(float delta) {
        debugCameraController.handleDebugInput(delta);
        debugCameraController.applyTo(camera);
        // update world
        if (alive)
            update(delta);

        // clear screen
        GdxUtils.clearScreen();

        // render debug graphics
        renderDebug();
    }

    private void update(float delta) {
        updatePlayer();
        updateObstacles(delta);

        if (isPlayerCollidingWithObstacle())
            alive = false;

    }

    private boolean isPlayerCollidingWithObstacle() {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.isPlayerColliding(player))
                return true;
        }
        return false;
    }

    private void updateObstacles(float delta) {
        for (Obstacle obstacle : obstacles)
            obstacle.update(delta);
        createNewObstacles();

    }

    private void createNewObstacles() {
        if (MathUtils.random(1f) < obstacleTimer) {
            Obstacle obstacle = new Obstacle();
            obstacle.setPosition(MathUtils.random(player.getBoundsRadius(), GameConfig.WORLD_WIDTH - player.getBoundsRadius()),
                    GameConfig.WORLD_HEIGHT - player.getBoundsRadius());
            obstacles.add(obstacle);

        }
    }

    private void updatePlayer() {
        player.update();
        blockPlayerFromLeavingWorld();
    }

    private void blockPlayerFromLeavingWorld() {
        player.setPosition(
                MathUtils.clamp(player.getX(), player.getBoundsRadius(), GameConfig.WORLD_WIDTH - player.getBoundsRadius())
                , 1);
    }

    private void renderDebug() {

        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Line);

        drawDebug();

        renderer.end();

        ViewportUtils.drawGrid(viewport, renderer);
    }

    private void drawDebug() {
        player.drawDebug(renderer);
        for (Obstacle obstacle :
                obstacles) {
            obstacle.drawDebug(renderer);
        }
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        ViewportUtils.debugPixelPerUnit(viewport);
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
}
