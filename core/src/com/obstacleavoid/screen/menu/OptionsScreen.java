package com.obstacleavoid.screen.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.obstacleavoid.ObstacleAvoidGame;
import com.obstacleavoid.assets.AssetsDescriptor;
import com.obstacleavoid.assets.RegionNames;
import com.obstacleavoid.common.GameManager;
import com.obstacleavoid.config.DifficultyLevel;
import com.obstacleavoid.config.GameConfig;
import com.obstacleavoid.screen.menu.menuapi.BackButton;
import com.obstacleavoid.screen.menu.menuapi.Easy;
import com.obstacleavoid.screen.menu.menuapi.Hard;
import com.obstacleavoid.screen.menu.menuapi.Medium;
import com.obstacleavoid.screen.menu.menuapi.MenuBase;

public class OptionsScreen extends MenuBase {

    private Image checkMark;

    public OptionsScreen(ObstacleAvoidGame game) {
        super(game);
    }

    @Override
    public void createUi() {
        Table table = new Table();
        table.defaults().pad(15);

        TextureAtlas gamePlayAtlas = assetManager.get(AssetsDescriptor.GAME_PLAY);
        TextureAtlas uiAtlas = assetManager.get(AssetsDescriptor.UI);
        BitmapFont font = assetManager.get(AssetsDescriptor.FONT);

        TextureRegion backGroundRegion = gamePlayAtlas.findRegion(RegionNames.BACKGROUND);
        Image backGround = new Image(new TextureRegionDrawable(backGroundRegion));

        checkMark = new Image(new TextureRegionDrawable(uiAtlas.findRegion(RegionNames.CHECK_MARK)));

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, Color.WHITE);
        Label label = new Label("DIFFICULTY", labelStyle);

        ImageButton easy = new Easy(game, checkMark).execute();
        ImageButton medium = new Medium(game, checkMark).execute();
        ImageButton hard = new Hard(game, checkMark).execute();
        ImageButton back = new BackButton(game).execute();

        label.setPosition(GameConfig.HUD_WIDTH / 2, GameConfig.HUD_HEIGHT / 2 + 150, Align.center);
        easy.setPosition(GameConfig.HUD_WIDTH / 2, GameConfig.HUD_HEIGHT / 2 + 90, Align.center);
        medium.setPosition(GameConfig.HUD_WIDTH / 2, GameConfig.HUD_HEIGHT / 2, Align.center);
        hard.setPosition(GameConfig.HUD_WIDTH / 2, GameConfig.HUD_HEIGHT / 2 - 90, Align.center);
        back.setPosition(GameConfig.HUD_WIDTH / 2, GameConfig.HUD_HEIGHT / 2 - 2 * 90, Align.center);

        DifficultyLevel difficultyLevel = GameManager.INSTANCE.getDifficultyLevel();
        switch (difficultyLevel) {
            case EASY:
                checkMark.setPosition(easy.getX() + 35, easy.getY() + 25);
                break;
            case MEDIUM:
                checkMark.setPosition(medium.getX() + 35, medium.getY() + 25);
                break;
            case HARD:
                checkMark.setPosition(hard.getX() + 35, hard.getY() + 25);
                break;
        }

        stage.addActor(backGround);
        stage.addActor(label);
        stage.addActor(easy);
        stage.addActor(medium);
        stage.addActor(hard);
        stage.addActor(back);
        stage.addActor(checkMark);
    }
}
