package Files_Handling;

import Logic.Cell;
import Logic.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class GameData implements java.io.Serializable {
    //Logic.Game Data
    public ArrayList<Player> Players;
    public Player CurrentPlayer;
    public String ShowMethod;
    public boolean Multiplier;


    //Grid Data
    public Cell[][] GridCells;
    public int GridRows;
    public int GridColumns;
    public int GridSize;
    public int MinesNumber;
    public ArrayList<Cell> MinedCells;
    public ArrayList<Cell> FinalFlaggedCells;
    public int FlaggedCellsNumber;
    public int RevealedCellsNumber;


    //Rules Data
    public boolean Win;
    public boolean FlagRole;
    public boolean GameOver;
    public Player Winner;
    public ArrayList<Player> Losers;
    public Color Role;
    public Color[] PlayersColor;
    public int ColorIndex;
    public int TimePassed;
    public int TimeLeft;
    public int MaxTimeLimit;
    public int MinTimeLimit;


    //GUI Data
    JPanel GridPanel;
    JLabel TimeLabel;
    JLabel CurrentPlayerLabel;
    JMenuBar MainMenu;
    JPanel TopInformationPanel;

}