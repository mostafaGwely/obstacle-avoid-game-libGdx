package com.obstacleavoid.screen.menu.menuapi;

import com.obstacleavoid.ObstacleAvoidGame;
import com.obstacleavoid.assets.AssetsDescriptor;
import com.obstacleavoid.assets.RegionNames;
import com.obstacleavoid.screen.menu.OptionsScreen;

public class OptionsButton extends Button {
    public OptionsButton(ObstacleAvoidGame game) {
        super(game);
        atlas = assetManager.get(AssetsDescriptor.UI);
        button = createButtonUpDown(atlas, RegionNames.OPTIONS, RegionNames.OPTIONS_PRESSED);
    }

    @Override
    protected void doExecute() {
        game.setScreen(new OptionsScreen(game));
    }
}
