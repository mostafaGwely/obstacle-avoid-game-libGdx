package com.obstacleavoid.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.obstacleavoid.ObstacleAvoidGame;
import com.obstacleavoid.config.DifficultyLevel;

public class GameManager {
    public static final GameManager INSTANCE = new GameManager();
    private static final String HIGH_SCORE_KEY = "highscore";
    private static final String DIFFICULTY_KEY = "difficulty";

    private Preferences PREFS;

    private int highScore;
    private DifficultyLevel difficultyLevel = DifficultyLevel.MEDIUM;

    private GameManager() {
        PREFS = Gdx.app.getPreferences(ObstacleAvoidGame.class.getSimpleName());
        highScore = PREFS.getInteger(HIGH_SCORE_KEY, 0);

        String difficultyName = PREFS.getString(DIFFICULTY_KEY, DifficultyLevel.MEDIUM.name());
        difficultyLevel = DifficultyLevel.valueOf(difficultyName);
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

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void updateDifficulty(DifficultyLevel newDifficulty) {
        if (newDifficulty != difficultyLevel) {
            PREFS.putString(DIFFICULTY_KEY, newDifficulty.name());
            PREFS.flush();
        }
        difficultyLevel = newDifficulty;
    }
}
