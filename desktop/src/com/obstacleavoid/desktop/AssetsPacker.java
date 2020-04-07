package com.obstacleavoid.desktop;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class AssetsPacker {
    public static final boolean DRAW_DEBUG_OUTLINE = true;
    public static final String RAW_ASSET_PATH = "android/assets/assets-raw";
    public static final String ASSETS_PATH = "android/assets";


    public static void main(String[] args) {
        TexturePacker.Settings settings = new TexturePacker.Settings();
//        settings.debug = DRAW_DEBUG_OUTLINE;

        TexturePacker.process(settings,
                RAW_ASSET_PATH + "/gameplay",
                ASSETS_PATH + "/gameplay",
                "gameplay");

        TexturePacker.process(settings,
                RAW_ASSET_PATH + "/ui",
                ASSETS_PATH + "/ui",
                "ui");
    }
}
