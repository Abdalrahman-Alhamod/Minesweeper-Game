package Logic;

import Screen.Console;
import Screen.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Rules implements java.io.Serializable {
    public static boolean GameOver;
    public static Player Winner;
    public static ArrayList<Player> Losers;
    public static Color Role;
    public static Color[] PlayersColor;
    public static int ColorIndex;
    static private boolean Win;
    static private boolean FlagRole;

    static public void StartNewGame() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        GameOver = false;
        Win = true;
        FlagRole = false;
        Winner = null;
        Losers = new ArrayList<>();
        initPlayersColor();
        ColorIndex = 0;
        InputCellHandler.HandledCellsNumber = 0;
        if (Grid.rows == 0)
            Grid.init(15, 15, 75);
        else
            Grid.init(Grid.rows,Grid.columns,Grid.MinesNumber);
        if (Game.ShowMethod.equals("GUI")) {
            GUI.init();
            GUI.Start();
        }
    }

    static public void calcFinalScore(Player player) {
        Grid.getFinalFlaggedCells();
        if (Rules.isWin()) {
            for (Cell cell : Grid.MinedCells) {
                if (cell.isFlag()) {
                    player.addScore(5);
                } else {
                    if (Game.Multiplier) {
                        if (!cell.isRevealed()) {
                            player.addScore(100);
                        }
                    } else {
                        player.addScore(100);
                    }
                }
            }
        } else {
            for (Cell cell : Grid.FinalFlaggedCells) {
                if (cell.getValue() == 'X') {
                    player.addScore(5);
                } else {
                    player.addScore(-1);

                }
            }
        }
    }

    static public void CheckWin(Player CurrentRolePlayer) {
        if ((Grid.size - (Grid.RevealedCellsNumber + Grid.FlaggedCellsNumber)) == Grid.MinesNumber) {
            setWin(true);
            Winner = CurrentRolePlayer;
            GameOver = true;
        }
    }

    static public void CheckGameOver() {
        if (Rules.GameOver) {
            if (Rules.isWin()) {
                Rules.calcFinalScore(Winner);
                if (Game.ShowMethod.equals("GUI")) {
                    GUI.ShowFinalResults();
                } else {
                    Console.PrintGrid();
                    System.out.println("Player " + Rules.Winner.getName() + " Is Winner With Score : " + Rules.Winner.getCurrentScore());
                    for (Player LooserPlayer : Game.Players) {
                        if (LooserPlayer != Winner)
                            System.out.println("Player " + LooserPlayer.getName() + " Is Looser Score is : " + LooserPlayer.getCurrentScore());
                    }
                }
            } else {
                Rules.calcFinalScore(Game.CurrentPlayer);
                if (Game.ShowMethod.equals("GUI")) {
                    GUI.ShowFinalResults();
                } else {
                    Console.PrintGrid();
                    System.out.println("Game over");
                    for (Player player : Game.Players) {
                        System.out.println("Player " + player.getName() + " Score is : " + player.getCurrentScore());
                    }
                }
            }
        }
    }

    public static boolean isFlagRole() {
        return FlagRole;
    }

    public static void setFlagRole(boolean flagRole) {
        FlagRole = flagRole;
    }

    public static void setPlayerRole(Player player) {
        Game.CurrentPlayer = player;
    }

    public static void SwapPlayer() {
        Rules.GameTime.TimeLeft = Rules.GameTime.MinTimeLimit;
        GUI.TimeLabel.setText("Time : " + Rules.GameTime.TimeLeft);
        for (int i = 0; i < Game.Players.size(); i++) {
            if (Game.Players.get(i).isRole()) {
                Game.Players.get(i).setRole(false);
                Game.Players.get((i + 1) % (Game.Players.size())).setRole(true);
                setPlayerRole(Game.Players.get((i + 1) % (Game.Players.size())));
                break;
            }
        }
        GUI.CurrentPlayerLabel.setText("Current Player : " + Game.CurrentPlayer.getName());
        if (Game.Multiplier)
            GUI.CurrentPlayerLabel.setForeground(Game.CurrentPlayer.getColor());
    }

    public static boolean isWin() {
        return Win;
    }

    public static void setWin(boolean win) {
        Win = win;
    }

    public static void initPlayersColor() {
        PlayersColor = new Color[10];
        PlayersColor[0] = Color.BLUE;
        PlayersColor[1] = new Color(225, 0, 241);
        PlayersColor[2] = new Color(12, 183, 8);
        PlayersColor[3] = new Color(245, 111, 1);
        PlayersColor[4] = new Color(250, 0, 0);
        PlayersColor[5] = new Color(231, 202, 4);
        PlayersColor[6] = new Color(155, 14, 225);
        PlayersColor[7] = new Color(100, 100, 100);
        PlayersColor[8] = new Color(0, 175, 152);
        PlayersColor[9] = Color.MAGENTA;
    }

    public static void AddPlayers() {
        Game.Players = new ArrayList<>();
        ColorIndex = 0;
        if (Game.ShowMethod.equals("GUI")) {
            GUI.AddPlayers();
        }
        Game.CurrentPlayer = Game.Players.get(0);
        Game.CurrentPlayer.setRole(true);
        if (Game.ShowMethod.equals("GUI")) {
            GUI.UpdateCurrentPlayerLabel(Game.Players.get(0));
        }
    }

    public static void CountPenalty(Player player) {
        if (Grid.rows == 10 && Grid.columns == 10) {
            player.addScore(-10);
        }
        if (Grid.rows == 15 && Grid.columns == 15) {
            player.addScore(-20);

        }
        if (Grid.rows == 20 && Grid.columns == 20) {
            player.addScore(-30);
        }
        if (Grid.rows == 25 && Grid.columns == 26) {
            player.addScore(-50);
        }
    }

    public static class GameTime implements java.io.Serializable {
        public static int TimePassed;
        public static int TimeLeft;
        public static int MaxTimeLimit;
        public static int MinTimeLimit;
    }
}
