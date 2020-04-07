package com.obstacleavoid.screen.menu.menuapi;

import com.obstacleavoid.ObstacleAvoidGame;
import com.obstacleavoid.assets.AssetsDescriptor;
import com.obstacleavoid.assets.RegionNames;

import static com.obstacleavoid.screen.menu.HighScoreScreen.logger;

public class OptionsButton extends Button {
    public OptionsButton(ObstacleAvoidGame game) {
        super(game);
        atlas = assetManager.get(AssetsDescriptor.UI);
        button = createButton(atlas, RegionNames.OPTIONS, RegionNames.OPTIONS_PRESSED);
    }

    @Override
    protected void doExecute() {
        logger.debug("options()");
    }
}
