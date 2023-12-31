package Screen;

import Files_Handling.LoadGame;
import Files_Handling.SaveGame;
import Logic.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Objects;

public class GUI implements java.io.Serializable {
    public static JFrame MainFrame;
    public static JPanel GridPanel;
    public static JLabel TimeLabel;
    public static JLabel CurrentPlayerLabel;
    //static int Time;
    public static JMenuBar MainMenu;
    public static JPanel TopInformationPanel;
    public static Icon FlagIcon;
    public static Icon MineIcon;
    public static Icon NewIcon;
    public static Icon SaveIcon;
    public static Icon LoadIcon;
    public static Icon How_To_Play;
    public static Icon About;
    public static Icon Player;
    public static Icon StopWatch;
    public static Icon Colors;
    public static Icon Names;
    public static Icon Players;
    public static Icon Winner;
    public static Icon Loser;
    public static Icon GameOver;
    public static Icon Restart;
    public static Icon Tutorial;
    public static Icon Innovation;
    public static Icon Exit;
    public static ImageIcon Difficulty;
    public static ImageIcon MainFrameIcon;
    public static Timer CountDownTimer;

    public static void init() {
        initIcons();

        MainFrame = new JFrame("Minesweeper");
        initMainFrame();

        MainMenu = new JMenuBar();
        initMainMenu();

        GridPanel = new JPanel();
        initGridPanel();

        TopInformationPanel = new JPanel();
        initTopInformationPanel();

        MainFrame.pack();


    }

    static public void initIcons() {
        try {
            FlagIcon = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/Flag.png")));
        } catch (Exception e) {
            ShowErrorMessage("Flag Icon", "Flag Icon Is Missing!");
        }
        try {
            MineIcon = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/Mine.png")));
        } catch (Exception e) {
            ShowErrorMessage("Mine Icon", "Mine Icon Is Missing!");
        }
        try {
            StopWatch = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/stopwatch.png")));
        } catch (Exception e) {
            ShowErrorMessage("Stop Watch Icon", "Stop Watch Icon Is Missing!");
        }
        try {
            Player = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/player.png")));
        } catch (Exception e) {
            ShowErrorMessage("Player Icon", "Player Icon Is Missing!");
        }
        try {
            Players = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/players.png")));
        } catch (Exception e) {
            ShowErrorMessage("Players Icon", "Players Icon Is Missing!");
        }
        try {
            Names = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/names.png")));
        } catch (Exception e) {
            ShowErrorMessage("Names Icon", "Names Icon Is Missing!");
        }
        try {
            Colors = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/colors.png")));
        } catch (Exception e) {
            ShowErrorMessage("Colors Icon", "Colors Icon Is Missing!");
        }
        try {
            Difficulty = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/difficulty.png")));
        } catch (Exception e) {
            ShowErrorMessage("Difficulty Icon", "Difficulty Icon Is Missing!");
        }
        try {
            GameOver = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/gameOver.png")));
        } catch (Exception e) {
            ShowErrorMessage("GameOver Icon", "GameOver Icon Is Missing!");
        }
        try {
            Innovation = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/innovation.png")));
        } catch (Exception e) {
            ShowErrorMessage("Innovation Icon", "Innovation Icon Is Missing!");
        }
        try {
            Tutorial = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/tutorial.png")));
        } catch (Exception e) {
            ShowErrorMessage("Tutorial Icon", "Tutorial Icon Is Missing!");
        }
        try {
            Winner = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/winner.png")));
        } catch (Exception e) {
            ShowErrorMessage("Winner Icon", "Winner Icon Is Missing!");
        }
        try {
            Loser = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/loser.png")));
        } catch (Exception e) {
            ShowErrorMessage("Loser Icon", "Loser Icon Is Missing!");
        }
        try {
            Restart = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/restart.png")));
        } catch (Exception e) {
            ShowErrorMessage("Restart Icon", "Restart Icon Is Missing!");
        }
        try {
            Exit = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/exit.png")));
        } catch (Exception e) {
            ShowErrorMessage("Exit Icon", "Exit Icon Is Missing!");
        }
        try {
            NewIcon = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/New.png")));
        } catch (Exception e) {
            ShowErrorMessage("New Icon", "New Icon Is Missing!");
        }
        try {
            SaveIcon = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/Save.png")));
        } catch (Exception e) {
            ShowErrorMessage("Save Icon", "Save Icon Is Missing!");
        }
        try {
            LoadIcon = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/Load.png")));
        } catch (Exception e) {
            ShowErrorMessage("Load Icon", "Load Icon Is Missing!");
        }
        try {
            How_To_Play = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/How_To_Play.png")));
        } catch (Exception e) {
            ShowErrorMessage("How To Play Icon", "How To Play Icon Is Missing!");
        }
        try {
            About = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/About.png")));
        } catch (Exception e) {
            ShowErrorMessage("About Icon", "About Icon Is Missing!");
        }
        try {
            //MainFrameIcon = ImageIO.read(new File("src/Icons/MainFrame.png"));
            MainFrameIcon = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("Icons/MainFrame.png")));
        } catch (Exception e) {
            ShowErrorMessage("Main Frame Icon", "Main Frame Icon Is Missing!");
        }
    }

    static public void initMainFrame() {
        MainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    SaveGame.SaveCurrentGame("Auto Save");
                } catch (Exception ex) {
                    ShowErrorMessage("Game Save", ex.getMessage());
                }
                MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        MainFrame.setSize(800, 600);
        MainFrame.setLocation(0, 0);
        MainFrame.setIconImage(MainFrameIcon.getImage());
    }

    static public void initMainMenu() {
        JMenu gameMenu = new JMenu("Game");

        JMenuItem restartGameItem = new JMenuItem(new AbstractAction("Restart Game") {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.dispose();
                CountDownTimer.stop();
                ArrayList<Player> oldPlayers = Game.Players;
                for (Player player : oldPlayers) {
                    player.setCurrentScore(0);
                }
                Game.init();
                Game.Players = oldPlayers;
                MainFrame.setVisible(true);
            }
        });
        JMenuItem newGameItem = new JMenuItem(new AbstractAction("New Game") {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.dispose();
                CountDownTimer.stop();
                Rules.StartNewGame();
                Rules.AddPlayers();
            }
        });
        JMenuItem saveGameItem = new JMenuItem(new AbstractAction("Save Game") {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean DataSaveError = false;
                try {
                    SaveGame.SaveCurrentGame(InputMessage("Game Save", "Enter Save File Name :"));
                } catch (Exception ex) {
                    //throw new RuntimeException(ex);
                    ShowErrorMessage("Game Save", ex.getMessage());
                    DataSaveError = true;
                }
                if (!DataSaveError)
                    ShowInfoMessage("Game Save", "Data Has Been Saved Successfully");
            }
        });
        JMenuItem loadGameItem = new JMenuItem(new AbstractAction("Load Game") {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean DataLoadError = false;
                MainFrame.setVisible(false);
                CountDownTimer.stop();
                try {
                    LoadGame.LoadGameData(InputMessage("Game Load", "Enter Load File Name :"));
                    CountDownTimer.start();
                } catch (Exception ex) {
                    //throw new RuntimeException(ex);
                    ShowErrorMessage("Game Load", ex.getMessage());
                    DataLoadError = true;
                }
                GUI.init();
                GUI.Start();
                UpdateGrid();
                MainFrame.setVisible(true);
                if (!DataLoadError)
                    ShowInfoMessage("Game Load", "Data Has Been Loaded Successfully");
            }
        });
        JMenuItem exitGameItem = new JMenuItem(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SaveGame.SaveCurrentGame("Auto Save");
                } catch (Exception ex) {
                    ShowErrorMessage("Game Save", ex.getMessage());
                }
                MainFrame.dispose();
                System.exit(0);
            }
        });
        restartGameItem.setIcon(Restart);
        newGameItem.setIcon(NewIcon);
        saveGameItem.setIcon(SaveIcon);
        loadGameItem.setIcon(LoadIcon);
        exitGameItem.setIcon(Exit);
        gameMenu.add(restartGameItem);
        gameMenu.addSeparator();
        gameMenu.add(newGameItem);
        gameMenu.add(saveGameItem);
        gameMenu.add(loadGameItem);
        gameMenu.addSeparator();
        gameMenu.add(exitGameItem);
        JMenu HelpMenu = new JMenu("Help");
        JMenuItem howToPlay = new JMenuItem(new AbstractAction("How To Play") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "Minesweeper rules are very simple :" +
                        " \n- The board is divided into cells, with mines randomly distributed." +
                        " \n- To win, you need to open all the cells." +
                        " \n- The number on a cell shows the number of mines adjacent to it." +
                        " \n- Using this information, you can determine cells that are safe," +
                        " and cells that contain mines." +
                        " \n- Cells suspected of being mines can be marked with a flag using the right mouse button";

                JOptionPane.showOptionDialog(null,message,"How To Play", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,Tutorial,new String[]{"OK"},null);
            }
        });
        JMenuItem about = new JMenuItem(new AbstractAction("About") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "<html>MINESWEEPER GAME v1.5 <br>By Abd_HM ❤<html/>";
                JLabel aboutLabel = new JLabel(message);

                JPanel contactPanel = new JPanel(new BorderLayout());
                JLabel contactLabel = new JLabel("Contact Me : ");
                contactLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
                contactPanel.add(contactLabel,BorderLayout.NORTH);

                JButton emailLabel = createHyperlinkButton("E-mail", "mailto:abd.alrrahman.alhamod@gmail.com");
                emailLabel.setBackground(new Color(204, 0, 0)); // Set color to dark red

                JButton githubLabel = createHyperlinkButton("Github", "https://github.com/Abdalrahman-Alhamod");
                githubLabel.setBackground(new Color(0, 153, 0)); // Set color to light green

                JButton linkedInLabel = createHyperlinkButton("LinkedIn", "https://www.linkedin.com/in/abd-alrrahman-alhamod/");
                linkedInLabel.setBackground(new Color(0, 102, 153)); // Set color to dark blue

                JButton telegramLabel = createHyperlinkButton("Telegram", "https://t.me/Abd_Alrhman_Alhamod");
                telegramLabel.setBackground(new Color(30, 87, 153)); // Set color to a Telegram-like blue


                JPanel links = new JPanel(new GridLayout(2, 2));
                links.add(emailLabel);
                links.add(githubLabel);
                links.add(linkedInLabel);
                links.add(telegramLabel);
                contactPanel.add(links,BorderLayout.CENTER);

                JPanel aboutPanel = new JPanel(new BorderLayout());
                aboutPanel.add(aboutLabel,BorderLayout.NORTH);
                aboutPanel.add(contactPanel,BorderLayout.CENTER);

                JOptionPane.showOptionDialog(null,aboutPanel,"About", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,Innovation,new String[]{"OK"},null);
            }
        });
        howToPlay.setIcon(How_To_Play);
        about.setIcon(About);
        HelpMenu.add(howToPlay);
        HelpMenu.add(about);
        MainMenu.add(gameMenu);
        MainMenu.add(HelpMenu);
        MainFrame.setJMenuBar(MainMenu);
    }

    static public void initGridPanel() {
        GridPanel.setLayout(new GridLayout(Grid.rows + 1, Grid.columns + 1));
        JButton[] Letters = new JButton[Grid.columns];
        JButton[] Numbers = new JButton[Grid.rows];

        Letters[0] = new JButton();
        Letters[0].setText("");
        Letters[0].setEnabled(false);
        GridPanel.add(Letters[0]);
        for (int i = 0; i < Grid.columns; i++) {
            Letters[i] = new JButton();
            Letters[i].setText(String.valueOf((char) (i + 65)));
            Letters[i].setEnabled(false);
            GridPanel.add(Letters[i]);
        }

        // Create the buttons and add them to the panel
        for (int i = 0; i < Grid.rows; i++) {
            //Adding Numbers Column
            Numbers[i] = new JButton();
            Numbers[i].setText(String.valueOf(i + 1));
            Numbers[i].setEnabled(false);
            GridPanel.add(Numbers[i]);

            for (int j = 0; j < Grid.columns; j++) {
                Grid.cells[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                Grid.cells[i][j].setVerticalAlignment(SwingConstants.CENTER);
                Grid.cells[i][j].setPreferredSize(new Dimension(60, 45));
                GridPanel.add(Grid.cells[i][j]);
            }
        }
        MainFrame.add(GridPanel);
    }

    static public void initTopInformationPanel() {
        TopInformationPanel.setLayout(new GridLayout(1, 2));
        TimeLabel = new JLabel("Time : 0");
        TimeLabel.setIcon(StopWatch);
        TopInformationPanel.add(TimeLabel);
        CurrentPlayerLabel = new JLabel("Current Player : ");
        CurrentPlayerLabel.setIcon(Player);
        TopInformationPanel.add(CurrentPlayerLabel);
        MainFrame.add(TopInformationPanel, "North");
        CountDownTimer = new Timer(1000, e -> {
            if (!Rules.GameOver) {
                TimeLabel.setText("Time : " + Rules.GameTime.TimeLeft);
                if (Rules.GameTime.TimeLeft == 0) {
                    Rules.SwapPlayer();
                    Rules.GameTime.TimeLeft++;
                }
                Rules.GameTime.TimeLeft--;
            }
        });
    }

    static public void Start() {
        for (int i = 0; i < Grid.rows; i++) {
            for (int j = 0; j < Grid.columns; j++) {
                Grid.cells[i][j].addMouseListener(new CellClickActionListener(Grid.cells[i][j]));
            }
        }
    }

    static public void StartTimer() {
        Rules.GameTime.MinTimeLimit = 15;
        Rules.GameTime.TimeLeft = Rules.GameTime.MinTimeLimit;
        CountDownTimer.start();
    }

    static public void UpdateGrid() {
        for (int i = 0; i < Grid.rows; i++) {
            for (int j = 0; j < Grid.columns; j++) {
                if (Grid.cells[i][j].isRevealed()) {
                    if (Grid.cells[i][j].getValue() == 'X') {
                        Grid.cells[i][j].setText("");
                        Grid.cells[i][j].setIcon(GUI.MineIcon);
                        Grid.cells[i][j].setDisabledIcon(GUI.MineIcon);
                        Grid.cells[i][j].setBackground(Color.red);
                        Grid.cells[i][j].setFocusPainted(false);
                        Grid.cells[i][j].setContentAreaFilled(false);
                    } else {
                        Grid.cells[i][j].setText(String.valueOf(Grid.cells[i][j].getValue()));
                        ColorNumbers(Grid.cells[i][j]);
                        Grid.cells[i][j].setBackground(Color.WHITE);
                        Grid.cells[i][j].setFocusPainted(false);
                        Grid.cells[i][j].setContentAreaFilled(false);
                        if (Game.Multiplier) {
                            Grid.cells[i][j].setBorder(new LineBorder(Grid.cells[i][j].getCellColor(), 2));
                        }
                    }
                } else {
                    if (Grid.cells[i][j].isFlag()) {
                        Grid.cells[i][j].setIcon(GUI.FlagIcon);
                        Grid.cells[i][j].setBackground(Color.lightGray);
                    } else {
                        Grid.cells[i][j].setText("");
                        Grid.cells[i][j].setIcon(null);
                        Grid.cells[i][j].setBackground(null);
                    }
                }
            }
        }
        GUI.CurrentPlayerLabel.setText("Current Player : " + Game.CurrentPlayer.getName());
        if (Game.Multiplier)
            GUI.CurrentPlayerLabel.setForeground(Game.CurrentPlayer.getColor());
    }

    static public void UpdateCell(Cell cell) {
        if (cell.isRevealed()) {
            if (cell.getValue() == 'X') {
                cell.setIcon(GUI.MineIcon);
                cell.setDisabledIcon(GUI.MineIcon);
                cell.setBackground(Color.red);
            } else {
                cell.setText(String.valueOf(cell.getValue()));
                ColorNumbers(cell);
                cell.setBackground(Color.WHITE);
            }
            cell.setFocusPainted(false);
            cell.setContentAreaFilled(false);
            if (Game.Multiplier) {
                cell.setBorder(new LineBorder(Game.CurrentPlayer.getColor(), 2));
                cell.setCellColor(Game.CurrentPlayer.getColor());
            }
        } else {
            if (cell.isFlag()) {
                cell.setIcon(GUI.FlagIcon);
                cell.setBackground(Color.lightGray);
            } else {
                cell.setText("");
                cell.setIcon(null);
                cell.setBackground(null);
            }
        }
    }

    static public void ColorNumbers(Cell cell) {
        int Number = cell.getValue() - '0';
        switch (Number) {
            case 1: {
                cell.setForeground(Color.decode("#0000cc"));
                break;
            }
            case 2: {
                cell.setForeground(Color.decode("#b30000"));
                break;
            }
            case 3: {
                cell.setForeground(Color.decode("#00cc00"));
                break;
            }
            case 4: {
                cell.setForeground(Color.decode("#e68a00"));
                break;
            }
            case 5: {
                cell.setForeground(Color.decode("#999900"));
                break;
            }
            case 6: {
                cell.setForeground(Color.decode("#008080"));
                break;
            }
            case 7: {
                cell.setForeground(Color.decode("#cc00cc"));
                break;
            }
            case 8: {
                cell.setForeground(Color.decode("#ff0000"));
                break;
            }
            default: {
                cell.setForeground(Color.BLACK);
                break;
            }
        }

    }

    static public void LoadLastGame() {
        File MinesweeperDir = new File(System.getProperty("user.home") + File.separator + "Minesweeper"
                + File.separator + "Saved Games" + File.separator + "Auto Save.dat");
        if (MinesweeperDir.exists()) {
            boolean DataLoadError = false;
            int result = JOptionPane.showConfirmDialog(null, "Do Want To Load The Last Game ?", "Game Load", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                GUI.MainFrame.setVisible(false);
                try {
                    LoadGame.LoadGameData("Auto Save");
                } catch (Exception ex) {
                    //throw new RuntimeException(ex);
                    ShowErrorMessage("Game Load", ex.getMessage());
                    DataLoadError = true;
                }
                GUI.init();
                GUI.Start();
                GUI.UpdateGrid();
                MainFrame.setVisible(true);
                if (!DataLoadError)
                    ShowInfoMessage("Game Load", "Data Has Been Loaded Successfully");
            } else {
                Rules.AddPlayers();
            }
        } else {
            Rules.AddPlayers();
        }


    }

    static public String InputMessage(String title, String message) {
        String InputText = "";
        JPanel inputPanel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(message);
        JTextField inputField = new JTextField();
        inputPanel.add(label, BorderLayout.NORTH);
        inputPanel.add(inputField, BorderLayout.SOUTH);
        int result = JOptionPane.showConfirmDialog(null, inputPanel, title, JOptionPane.DEFAULT_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // user clicked OK, get the value of the input field
            InputText = inputField.getText();
            // do something with the input
        }
        return InputText;
    }

    static public void ShowInfoMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    static public void ShowErrorMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    static public void AddPlayers() {
        while (true) {
            try {
                int NumberOfPlayers = 1;
                while (true) {
                    try {
                        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
                        slider.setMajorTickSpacing(1);
                        slider.setPaintLabels(true);
                        slider.setPaintTicks(true);
                        JLabel enterN = new JLabel("Enter The Number Of Players : ");
                        JPanel enterPlayers = new JPanel(new GridLayout(2, 1));
                        enterPlayers.add(enterN);
                        enterPlayers.add(slider);

                        int result = JOptionPane.showOptionDialog(null, enterPlayers, "Add Players", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, Players, new String[]{"OK"}, null);
                        if (result == 0)
                            NumberOfPlayers = slider.getValue();
                        else
                            System.exit(0);
                        break;
                    } catch (Exception e) {
                        ShowErrorMessage("Error", "An Error Occurred. Pleas Try Again !");
                    }
                }


                // Create a panel with text fields for each player
                JPanel InputsPanel = new JPanel(new GridLayout(NumberOfPlayers, 1));
                JTextField[] PlayersNamesFields = new JTextField[NumberOfPlayers];
                for (int i = 0; i < NumberOfPlayers; i++) {
                    InputsPanel.add(new JLabel("Player " + (i + 1) + ":"));
                    PlayersNamesFields[i] = new JTextField("");
                    InputsPanel.add(PlayersNamesFields[i]);
                }

                // Show the player name dialog
                int result = JOptionPane.showOptionDialog(null, InputsPanel, "Enter Players Name :", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, Names, new String[]{"OK"}, null);
                if (result == 0) {
                    // Get the player names from the text fields
                    for (int i = 0; i < NumberOfPlayers; i++) {
                        Game.addPlayer(PlayersNamesFields[i].getText());
                    }
                } else
                    System.exit(0);
                //GIVING COLORS TO PLAYERS
                if (Game.Players.size() > 1) {
                    // Create a panel with labels for each player
                    JPanel PlayersColorLabel = new JPanel(new GridLayout(Game.Players.size(), 1));
                    for (int i = 0; i < Game.Players.size(); i++) {
                        JLabel label = new JLabel("Player " + (i + 1) + " : ");
                        label.setForeground(Color.BLACK);  // Set player name text color to default
                        JLabel colorLabel = new JLabel(Game.Players.get(i).getName());
                        colorLabel.setForeground(Game.Players.get(i).getColor());  // Set color name text color to player color
                        // Add the labels to a panel
                        JPanel playerPanel = new JPanel();
                        playerPanel.add(label);
                        playerPanel.add(colorLabel);
                        PlayersColorLabel.add(playerPanel);
                    }

                    // Show the player color dialog
                    JOptionPane.showOptionDialog(null, PlayersColorLabel, "Players Colors", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, Colors, new String[]{"OK"}, null);
                }
                ChooseDifficulty();
                break;
            } catch (Exception e) {
                ShowErrorMessage("Error", "An Error Occurred. Pleas Try Again !");
            }
        }
    }

    static public void UpdateCurrentPlayerLabel(Player CurrentPlayerRole) {
        GUI.CurrentPlayerLabel.setText("Current Player : " + CurrentPlayerRole.getName());
        if (Game.Multiplier)
            GUI.CurrentPlayerLabel.setForeground(CurrentPlayerRole.getColor());
    }

    static public void ShowFinalResults() {
        JPanel PlayersResultsPanel = new JPanel(new GridLayout(0, 1));
        if (Rules.Winner != null) {
            JLabel WinnerColoredNameLapel = new JLabel(Rules.Winner.getName());
            WinnerColoredNameLapel.setForeground(Rules.Winner.getColor());
            JLabel WinnerLabel = new JLabel("Is Winner !");
            WinnerLabel.setIcon(Winner);
            WinnerLabel.setForeground(Color.BLACK);
            JPanel WinnerPanel = new JPanel();
            WinnerPanel.add(WinnerColoredNameLapel);
            WinnerPanel.add(WinnerLabel);
            PlayersResultsPanel.add(WinnerPanel);
        } else {
            JLabel LooserNameLapel = new JLabel(Rules.Losers.get(0).getName());
            JLabel LooserLabel = new JLabel("Is Looser !");
            LooserLabel.setIcon(Loser);
            JPanel LooserPanel = new JPanel();
            LooserPanel.add(LooserNameLapel);
            LooserPanel.add(LooserLabel);
            PlayersResultsPanel.add(LooserPanel);
        }
        for (int i = 0; i < Game.Players.size(); i++) {
            JLabel colorLabel = new JLabel(Game.Players.get(i).getName());
            if (Game.Multiplier)
                colorLabel.setForeground(Game.Players.get(i).getColor());
            JLabel label = new JLabel(" Score is : " + Game.Players.get(i).getCurrentScore());
            label.setForeground(Color.BLACK);
            JPanel playerPanel = new JPanel();
            playerPanel.add(colorLabel);
            playerPanel.add(label);
            PlayersResultsPanel.add(playerPanel);
        }
        // Show the player color dialog
        JOptionPane.showOptionDialog(null, PlayersResultsPanel, "Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, GameOver, new String[]{"OK"}, null);
    }

    public static void ChooseDifficulty() {

        JDialog difficultyDialog = new JDialog();
        difficultyDialog.setIconImage(Difficulty.getImage());
        difficultyDialog.setTitle("Choose Difficulty");
        difficultyDialog.setModal(true);
        difficultyDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        int[][] grids = {{10, 10, 15}, {15, 15, 35}, {20, 20, 75}, {25, 26, 125}};
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        JButton EasyButton = new JButton("Easy");
        EasyButton.setPreferredSize(new Dimension(100, 65));
        EasyButton.setBackground(Color.GREEN);
        JLabel EasyLabel = new JLabel("Grid: " + grids[0][0] + "x" + grids[0][1] + " Mines: " + grids[0][2]);
        JPanel EasyPanel = new JPanel(new BorderLayout(50, 10));
        EasyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        EasyPanel.add(EasyButton, BorderLayout.NORTH);
        EasyPanel.add(EasyLabel, BorderLayout.SOUTH);
        EasyButton.addActionListener(e -> {
            difficultyDialog.dispose();
            MainFrame.setVisible(false);
            Grid.init(10, 10, 15);
            GUI.init();
            GUI.Start();
            MainFrame.setVisible(true);
        });
        buttonPanel.add(EasyPanel);

        JButton MediumButton = new JButton("Medium");
        MediumButton.setPreferredSize(new Dimension(100, 65));
        MediumButton.setBackground(Color.YELLOW);
        JLabel MediumLabel = new JLabel("Grid: " + grids[1][0] + "x" + grids[1][1] + " Mines: " + grids[1][2]);
        JPanel MediumPanel = new JPanel(new BorderLayout(50, 10));
        MediumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        MediumPanel.add(MediumButton, BorderLayout.NORTH);
        MediumPanel.add(MediumLabel, BorderLayout.SOUTH);
        MediumButton.addActionListener(e -> {
            difficultyDialog.dispose();
            MainFrame.setVisible(false);
            Grid.init(15, 15, 35);
            GUI.init();
            GUI.Start();
            MainFrame.setVisible(true);
        });
        buttonPanel.add(MediumPanel);

        JButton HardButton = new JButton("Hard");
        HardButton.setPreferredSize(new Dimension(100, 65));
        HardButton.setBackground(Color.RED);
        JLabel HardLabel = new JLabel("Grid: " + grids[2][0] + "x" + grids[2][1] + " Mines: " + grids[2][2]);
        JPanel HardPanel = new JPanel(new BorderLayout(50, 10));
        HardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        HardPanel.add(HardButton, BorderLayout.NORTH);
        HardPanel.add(HardLabel, BorderLayout.SOUTH);
        HardButton.addActionListener(e -> {
// code to start a new hard game
            difficultyDialog.dispose();
            MainFrame.setVisible(false);
            Grid.init(20, 20, 75);
            GUI.init();
            GUI.Start();
            MainFrame.setVisible(true);
        });
        buttonPanel.add(HardPanel);

        JButton ExpertButton = new JButton("Expert");
        ExpertButton.setPreferredSize(new Dimension(100, 65));
        ExpertButton.setBackground(Color.GRAY);
        JLabel ExpertLabel = new JLabel("Grid: " + grids[3][0] + "x" + grids[3][1] + " Mines: " + grids[3][2]);
        JPanel ExpertPanel = new JPanel(new BorderLayout(50, 10));
        ExpertLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ExpertPanel.add(ExpertButton, BorderLayout.NORTH);
        ExpertPanel.add(ExpertLabel, BorderLayout.SOUTH);
        ExpertButton.addActionListener(e -> {
            difficultyDialog.dispose();
            MainFrame.setVisible(false);
            Grid.init(25, 26, 125);
            GUI.init();
            GUI.Start();
            MainFrame.setVisible(true);
        });
        buttonPanel.add(ExpertPanel);

        difficultyDialog.add(buttonPanel);
        difficultyDialog.setBounds(600, 250, 300, 400);
        difficultyDialog.setLocationRelativeTo(null);
        difficultyDialog.setResizable(false);
        difficultyDialog.setVisible(true);


    }

    public static class CellClickActionListener implements MouseListener {
        Cell ClickCell;

        public CellClickActionListener(Cell ClickCell) {
            this.ClickCell = ClickCell;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            Rules.setFlagRole(false);
            if (e.getButton() == MouseEvent.BUTTON3) {
                Rules.setFlagRole(true);
            }
            if (!ClickCell.isRevealed() && !Rules.GameOver) {
                new InputCellHandler(ClickCell).start();
            }

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (!ClickCell.isRevealed())
                ClickCell.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ClickCell.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }
    private static JButton createHyperlinkButton(String text, String link) {
        JButton button = new JButton();
        button.setText("<html><a href=\"" + link + "\"><b><font color=\"white\">" + text + "</font></b></a></html>");
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Add an action listener to handle the button click event
        button.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI(link));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        return button;
    }
}
