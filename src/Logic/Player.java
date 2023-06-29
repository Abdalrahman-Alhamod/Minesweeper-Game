package Logic;

import java.awt.*;

public class Player implements java.io.Serializable {
    private final String name;
    private Color color;
    private int currentScore;
    private boolean Role;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        currentScore = 0;
    }

    public String getName() {
        return name;
    }


    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void addScore(int score) {
        currentScore += score;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isRole() {
        return Role;
    }

    public void setRole(boolean role) {
        Role = role;
    }
}
