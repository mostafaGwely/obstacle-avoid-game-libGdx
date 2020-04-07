package com.obstacleavoid.screen.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.obstacleavoid.ObstacleAvoidGame;
import com.obstacleavoid.assets.AssetsDescriptor;
import com.obstacleavoid.assets.RegionNames;
import com.obstacleavoid.config.GameConfig;
import com.obstacleavoid.screen.menu.menuapi.HighScoreButton;
import com.obstacleavoid.screen.menu.menuapi.OptionsButton;
import com.obstacleavoid.screen.menu.menuapi.PlayButton;
import com.obstacleavoid.util.GdxUtils;

public class MenuScreen extends ScreenAdapter {
    public static final Logger logger = new Logger(MenuScreen.class.getName(), Logger.DEBUG);

    private final ObstacleAvoidGame game;
    private final AssetManager assetManager;
    private Viewport viewport;
    private Stage stage;

    public MenuScreen(ObstacleAvoidGame game) {
        this.game = game;
        this.assetManager = game.getAssetManager();

    }

    private void initUi() {
        Table table = new Table();
//        table.setDebug(true);

        TextureAtlas gamePlayAtlas = assetManager.get(AssetsDescriptor.GAME_PLAY);
        TextureAtlas uiAtlas = assetManager.get(AssetsDescriptor.UI);

        TextureRegion backgroundRegion = gamePlayAtlas.findRegion(RegionNames.BACKGROUND);
        TextureRegion panelRegion = uiAtlas.findRegion(RegionNames.PANEL);

        table.setBackground(new TextureRegionDrawable(backgroundRegion));

        //play button
        ImageButton playButton = new PlayButton(game).execute();
        //high score button
        ImageButton highScoreButton = new HighScoreButton(game).execute();
        //options
        ImageButton optionsButton = new OptionsButton(game).execute();
        //quite button

        //setup table
        Table buttonTable = new Table();
        buttonTable.defaults().pad(20);
        buttonTable.center();
        buttonTable.setBackground(new TextureRegionDrawable(panelRegion));
        buttonTable.add(playButton).row();
        buttonTable.add(highScoreButton).row();
        buttonTable.add(optionsButton).row();


        table.add(buttonTable);

        table.center();
        table.setFillParent(true);
        table.pack();

        stage.addActor(table);

    }


    @Override
    public void show() {
        viewport = new FitViewport(GameConfig.HUD_WIDTH, GameConfig.HUD_HEIGHT);
        stage = new Stage(viewport, game.getBatch());

        Gdx.input.setInputProcessor(stage);

        initUi();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        GdxUtils.clearScreen();
        stage.act();
        stage.draw();
    }
}
