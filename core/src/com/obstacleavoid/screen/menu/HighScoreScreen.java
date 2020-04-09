package com.obstacleavoid.screen.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Logger;
import com.obstacleavoid.ObstacleAvoidGame;
import com.obstacleavoid.assets.AssetsDescriptor;
import com.obstacleavoid.assets.RegionNames;
import com.obstacleavoid.common.GameManager;
import com.obstacleavoid.screen.menu.menuapi.BackButton;
import com.obstacleavoid.screen.menu.menuapi.MenuBase;

public class HighScoreScreen extends MenuBase {
  public static final Logger logger = new Logger(HighScoreScreen.class.getName(), Logger.DEBUG);

  public HighScoreScreen(ObstacleAvoidGame game) {
    super(game);
  }

  @Override
  public void createUi() {
    Table table = new Table();
    //        table.setDebug(true);

    TextureAtlas gamePlayAtlas = assetManager.get(AssetsDescriptor.GAME_PLAY);
    TextureAtlas uiAtlas = assetManager.get(AssetsDescriptor.UI);

    BitmapFont font = assetManager.get(AssetsDescriptor.FONT);

    TextureRegion backgroundRegion = gamePlayAtlas.findRegion(RegionNames.BACKGROUND);
    TextureRegion panelRegion = uiAtlas.findRegion(RegionNames.PANEL);

    table.setBackground(new TextureRegionDrawable(backgroundRegion));

    // label style
    Label.LabelStyle labelStyle = new Label.LabelStyle(font, Color.WHITE);

    // back button
    ImageButton backButton = new BackButton(game).execute();
    // quite button

    // setup table
    Table buttonTable = new Table();
    buttonTable.defaults().pad(20);
    buttonTable.center();
    // background
    buttonTable.setBackground(new TextureRegionDrawable(panelRegion));
    // label
    Label highScoreText = new Label("HIGHSCORE", labelStyle);

    Label highScoreLabel = new Label(GameManager.INSTANCE.getHighScore(), labelStyle);

    buttonTable.add(highScoreText).row();
    buttonTable.add(highScoreLabel).row();
    buttonTable.add(backButton).row();

    table.add(buttonTable);

    table.center();
    table.setFillParent(true);
    table.pack();

    stage.addActor(table);
  }
}
