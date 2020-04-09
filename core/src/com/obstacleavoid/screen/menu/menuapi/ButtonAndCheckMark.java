package com.obstacleavoid.screen.menu.menuapi;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.obstacleavoid.ObstacleAvoidGame;

public abstract class ButtonAndCheckMark extends Button {
    protected Image checkMark;

    public ButtonAndCheckMark(ObstacleAvoidGame game, Image checkMark) {
        super(game);
        this.checkMark = checkMark;
    }

}
