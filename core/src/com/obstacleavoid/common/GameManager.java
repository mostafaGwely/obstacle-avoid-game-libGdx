package com.obstacleavoid.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.obstacleavoid.ObstacleAvoidGame;

public class GameManager {
    public static final GameManager INSTANCE = new GameManager();
    private static final String HIGH_SCORE_KEY = "highscore";

    private Preferences PREFS;

    private int highScore;

    private GameManager() {
        PREFS = Gdx.app.getPreferences(ObstacleAvoidGame.class.getSimpleName());
        highScore = PREFS.getInteger(HIGH_SCORE_KEY, 0);

    }

    public String getHighScore() {
        return String.valueOf(highScore);
    }

    public void updateHighScore(int score) {
        if (score > highScore) {
            PREFS.putInteger(HIGH_SCORE_KEY, score);
            PREFS.flush();
        }
        highScore = score;
    }
}
