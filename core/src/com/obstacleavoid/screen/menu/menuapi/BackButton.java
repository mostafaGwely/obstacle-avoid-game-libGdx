package com.obstacleavoid.screen.menu.menuapi;

import com.obstacleavoid.ObstacleAvoidGame;
import com.obstacleavoid.assets.AssetsDescriptor;
import com.obstacleavoid.assets.RegionNames;
import com.obstacleavoid.screen.menu.MenuScreen;

public class BackButton extends Button {
    public BackButton(ObstacleAvoidGame game) {
        super(game);
        atlas = assetManager.get(AssetsDescriptor.UI);
        button = createButtonUpDown(atlas, RegionNames.BACK, RegionNames.BACK_PRESSED);
    }

    @Override
    protected void doExecute() {
        game.setScreen(new MenuScreen(game));
    }
}
