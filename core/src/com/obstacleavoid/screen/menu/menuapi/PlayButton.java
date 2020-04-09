package com.obstacleavoid.screen.menu.menuapi;

import com.obstacleavoid.ObstacleAvoidGame;
import com.obstacleavoid.assets.AssetsDescriptor;
import com.obstacleavoid.assets.RegionNames;
import com.obstacleavoid.screen.game.GameScreen;

public class PlayButton extends Button {
    public PlayButton(ObstacleAvoidGame game) {
        super(game);
        atlas = assetManager.get(AssetsDescriptor.UI);
        button = createButtonUpDown(atlas, RegionNames.PLAY, RegionNames.PLAY_PRESSED);
    }

    @Override
    protected void doExecute() {
        game.setScreen(new GameScreen(game));
    }
}
