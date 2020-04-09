package com.obstacleavoid.screen.menu;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.obstacleavoid.ObstacleAvoidGame;
import com.obstacleavoid.assets.AssetsDescriptor;
import com.obstacleavoid.assets.RegionNames;
import com.obstacleavoid.screen.menu.menuapi.HighScoreButton;
import com.obstacleavoid.screen.menu.menuapi.MenuBase;
import com.obstacleavoid.screen.menu.menuapi.OptionsButton;
import com.obstacleavoid.screen.menu.menuapi.PlayButton;

public class MenuScreen extends MenuBase {

  public MenuScreen(ObstacleAvoidGame game) {
    super(game);
  }

  @Override
  public void createUi() {
    Table table = new Table();
    //        table.setDebug(true);

    TextureAtlas gamePlayAtlas = assetManager.get(AssetsDescriptor.GAME_PLAY);
    TextureAtlas uiAtlas = assetManager.get(AssetsDescriptor.UI);

    TextureRegion backgroundRegion = gamePlayAtlas.findRegion(RegionNames.BACKGROUND);
    TextureRegion panelRegion = uiAtlas.findRegion(RegionNames.PANEL);

    table.setBackground(new TextureRegionDrawable(backgroundRegion));

    // play button
    ImageButton playButton = new PlayButton(game).execute();
    // high score button
    ImageButton highScoreButton = new HighScoreButton(game).execute();
    // options
    ImageButton optionsButton = new OptionsButton(game).execute();
    // quite button

    // setup table
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
}
