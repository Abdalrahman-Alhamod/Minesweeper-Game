package Files_Handling;

import Logic.Game;
import Logic.Grid;
import Logic.Rules;
import Screen.GUI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveGame {
    static GameData CurrentGameData;
    static String fileName;

    static public void SaveCurrentGame(String filename) {
        // Create a GameData object to store the game data
        CurrentGameData = new GameData();
        fileName = filename;

        //Logic.Game Data
        CurrentGameData.Players = Game.Players;
        CurrentGameData.CurrentPlayer = Game.CurrentPlayer;
        CurrentGameData.ShowMethod = Game.ShowMethod;
        CurrentGameData.Multiplier = Game.Multiplier;

        //Grid Data
        CurrentGameData.GridCells = Grid.cells;
        CurrentGameData.GridRows = Grid.rows;
        CurrentGameData.GridColumns = Grid.columns;
        CurrentGameData.GridSize = Grid.size;
        CurrentGameData.MinesNumber = Grid.MinesNumber;
        CurrentGameData.MinedCells = Grid.MinedCells;
        CurrentGameData.FinalFlaggedCells = Grid.FinalFlaggedCells;
        CurrentGameData.FlaggedCellsNumber = Grid.FlaggedCellsNumber;
        CurrentGameData.RevealedCellsNumber = Grid.RevealedCellsNumber;

        //Rules Data
        CurrentGameData.Win = Rules.isWin();
        CurrentGameData.FlagRole = Rules.isFlagRole();
        CurrentGameData.GameOver = Rules.GameOver;
        CurrentGameData.Winner = Rules.Winner;
        CurrentGameData.Losers = Rules.Losers;
        CurrentGameData.Role = Rules.Role;
        CurrentGameData.PlayersColor = Rules.PlayersColor;
        CurrentGameData.ColorIndex = Rules.ColorIndex;
        CurrentGameData.TimePassed = Rules.GameTime.TimePassed;
        CurrentGameData.TimeLeft = Rules.GameTime.TimeLeft;
        CurrentGameData.MaxTimeLimit = Rules.GameTime.MaxTimeLimit;
        CurrentGameData.MinTimeLimit = Rules.GameTime.MinTimeLimit;

        //GUI Data
        //CurrentGameData.MainFrame = GUI.MainFrame;
        CurrentGameData.GridPanel = GUI.GridPanel;
        CurrentGameData.TimeLabel = GUI.TimeLabel;
        CurrentGameData.CurrentPlayerLabel = GUI.CurrentPlayerLabel;
        CurrentGameData.MainMenu = GUI.MainMenu;
        CurrentGameData.TopInformationPanel = GUI.TopInformationPanel;
        // Serialize the GameData object to a file
        try {
            serialize(CurrentGameData, fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void serialize(GameData CurrentGameData, String fileName) throws IOException {
        File MinesweeperDir = new File(System.getProperty("user.home") + File.separator + "Minesweeper" + File.separator + "Saved Games");
        MinesweeperDir.mkdirs();
        // Create a FileOutputStream to write the game data to a file
        FileOutputStream fileOut = new FileOutputStream(MinesweeperDir.getAbsolutePath() + File.separator + fileName + ".dat");
        // Create an ObjectOutputStream to serialize the game data
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        // Write the game data to the file
        out.writeObject(CurrentGameData);

        // Close the streams
        out.close();
        fileOut.close();
    }

    // Inner class to store the game data

}