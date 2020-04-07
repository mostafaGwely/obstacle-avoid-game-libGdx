package com.obstacleavoid.screen.menu.menuapi;

import com.obstacleavoid.ObstacleAvoidGame;
import com.obstacleavoid.assets.AssetsDescriptor;
import com.obstacleavoid.assets.RegionNames;
import com.obstacleavoid.screen.menu.HighScoreScreen;

public class HighScoreButton extends Button {
    public HighScoreButton(ObstacleAvoidGame game) {
        super(game);
        atlas = assetManager.get(AssetsDescriptor.UI);
        button = createButton(atlas, RegionNames.HIGH_SCORE, RegionNames.HIGH_SCORE_PRESSED);
    }

    @Override
    protected void doExecute() {
        game.setScreen(new HighScoreScreen(game));
    }
}
