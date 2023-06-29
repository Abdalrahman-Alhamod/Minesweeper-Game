package Files_Handling;

import Logic.Game;
import Logic.Grid;
import Logic.Rules;
import Screen.GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadGame {
    static GameData LoadedGameData;
    static String fileName;


    static public void LoadGameData(String filename) {
        fileName = filename;
        try {
            LoadedGameData = deserialize(fileName);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Logic.Game Data
        Game.Players = LoadedGameData.Players;
        Game.CurrentPlayer = LoadedGameData.CurrentPlayer;
        Game.ShowMethod = LoadedGameData.ShowMethod;
        Game.Multiplier = LoadedGameData.Multiplier;

        //Grid Data
        Grid.cells = LoadedGameData.GridCells;
        Grid.rows = LoadedGameData.GridRows;
        Grid.columns = LoadedGameData.GridColumns;
        Grid.size = LoadedGameData.GridSize;
        Grid.MinesNumber = LoadedGameData.MinesNumber;
        Grid.MinedCells = LoadedGameData.MinedCells;
        Grid.FinalFlaggedCells = LoadedGameData.FinalFlaggedCells;
        Grid.FlaggedCellsNumber = LoadedGameData.FlaggedCellsNumber;
        Grid.RevealedCellsNumber = LoadedGameData.RevealedCellsNumber;

        //Rules Data
        Rules.setWin(LoadedGameData.Win);
        Rules.setFlagRole(LoadedGameData.FlagRole);
        Rules.GameOver = LoadedGameData.GameOver;
        Rules.Winner = LoadedGameData.Winner;
        Rules.Losers = LoadedGameData.Losers;
        Rules.Role = LoadedGameData.Role;
        Rules.PlayersColor = LoadedGameData.PlayersColor;
        Rules.ColorIndex = LoadedGameData.ColorIndex;
        Rules.GameTime.TimePassed = LoadedGameData.TimePassed;
        Rules.GameTime.TimeLeft = LoadedGameData.TimeLeft;
        Rules.GameTime.MaxTimeLimit = LoadedGameData.MaxTimeLimit;
        Rules.GameTime.MinTimeLimit = LoadedGameData.MinTimeLimit;

        //GUI Data
        GUI.GridPanel = LoadedGameData.GridPanel;
        GUI.TimeLabel = LoadedGameData.TimeLabel;
        GUI.CurrentPlayerLabel = LoadedGameData.CurrentPlayerLabel;
        GUI.MainMenu = LoadedGameData.MainMenu;
        GUI.TopInformationPanel = LoadedGameData.TopInformationPanel;
    }

    private static GameData deserialize(String fileName) throws IOException, ClassNotFoundException {
        File MinesweeperDir = new File(System.getProperty("user.home") + File.separator + "Minesweeper" + File.separator + "Saved Games");
        // Create a FileInputStream to read the game data from a file
        FileInputStream fileIn = new FileInputStream(MinesweeperDir.getAbsolutePath() + File.separator + fileName + ".dat");

        // Create an ObjectInputStream to deserialize the game data
        ObjectInputStream in = new ObjectInputStream(fileIn);

        // Read the game data from the file
        GameData LoadedGameData = (GameData) in.readObject();

        // Close the streams
        in.close();
        fileIn.close();

        return LoadedGameData;
    }

}