package com.obstacleavoid.screen.menu.menuapi;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.obstacleavoid.ObstacleAvoidGame;
import com.obstacleavoid.assets.AssetsDescriptor;
import com.obstacleavoid.assets.RegionNames;
import com.obstacleavoid.common.GameManager;
import com.obstacleavoid.config.DifficultyLevel;

public class Medium extends ButtonAndCheckMark {
    public Medium(ObstacleAvoidGame game, Image checkMark) {
        super(game, checkMark);
        atlas = assetManager.get(AssetsDescriptor.UI);
        button = createButton(atlas, RegionNames.MEDIUM);
    }

    @Override
    protected void doExecute() {
        checkMark.setY(button.getY() + 25);
        GameManager.INSTANCE.updateDifficulty(DifficultyLevel.MEDIUM);
        checkMark.setPosition(button.getX() + 35, button.getY() + 25);
    }
}
