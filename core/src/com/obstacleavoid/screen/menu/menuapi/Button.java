package com.obstacleavoid.screen.menu.menuapi;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.obstacleavoid.ObstacleAvoidGame;

public abstract class Button {
    ImageButton button;
    AssetManager assetManager;
    TextureAtlas atlas;
    ObstacleAvoidGame game;

    public Button(ObstacleAvoidGame game) {
        this.game = game;
        this.assetManager = game.getAssetManager();
    }

    protected ImageButton createButtonUpDown(
            TextureAtlas atlas, String upRegionName, String downRegionName) {
        TextureRegion upRegion = atlas.findRegion(upRegionName);
        TextureRegion downRegion = atlas.findRegion(downRegionName);

        return new ImageButton(
                new TextureRegionDrawable(upRegion), new TextureRegionDrawable(downRegion));
    }

    protected ImageButton createButton(TextureAtlas atlas, String upRegionName) {
        TextureRegion upRegion = atlas.findRegion(upRegionName);

        return new ImageButton(new TextureRegionDrawable(upRegion));
    }

    public ImageButton execute() {
        button.addListener(
                new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        doExecute();
                    }
        });
        return button;
    }

    protected abstract void doExecute();
}
