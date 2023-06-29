package Logic;

import Screen.Console;
import Screen.GUI;

import java.util.ArrayList;

public class Game implements java.io.Serializable {
    public static ArrayList<Player> Players;
    public static Player CurrentPlayer;
    public static String ShowMethod;
    public static boolean Multiplier;

    static public void addPlayer(String PlayerName) {
        Players.add(new Player(PlayerName, Rules.PlayersColor[Rules.ColorIndex++]));
        Multiplier = Players.size() > 1;
    }

    static public void init() {
        if (Players == null)
            Players = new ArrayList<>();
        //ShowMethod = Console.InputShowMethod();
        ShowMethod = "GUI";
        Rules.StartNewGame();
    }

    static public void start() {
        if (ShowMethod.equals("GUI")) {
            GUI.LoadLastGame();
        } else {
            Console.StartMessage();
            Rules.StartNewGame();
            Grid.init(10, 10, 10);
            Game.addPlayer(Console.InputPlayerName());
            Game.CurrentPlayer = Game.Players.get(0);
            Game.CurrentPlayer.setRole(true);
            Console.PrintGrid();
            Cell NotMinedCell = Console.inputCell();
            Grid.DistributeMines(NotMinedCell);
            Grid.DistributeNumbers();
            Grid.Explore(CurrentPlayer, NotMinedCell);
            while (!Rules.GameOver) {
                Console.PrintGrid();
                Cell Choosencell = Console.inputCell();
                if (Rules.isFlagRole()) {
                    if (!Choosencell.isFlag()) {
                        if (!Choosencell.isRevealed()) {
                            Choosencell.setFlag(true);
                            Grid.FlaggedCellsNumber++;
                        } else {
                            System.out.println("Not Allowed");
                        }
                    } else {
                        Choosencell.setFlag(false);
                        Grid.FlaggedCellsNumber--;
                    }
                } else {
                    Grid.Explore(CurrentPlayer, Choosencell);
                }
                Rules.CheckWin(CurrentPlayer);
                Rules.CheckGameOver();
            }
        }
    }

    public static void main(String[] args) {
        Game.init();
        Game.start();
    }
}
