package Logic;

import Screen.GUI;

import java.util.ArrayList;
import java.util.Random;

public class Grid implements java.io.Serializable {
    public static Cell[][] cells;
    public static int rows;
    public static int columns;
    public static int size;
    public static int MinesNumber;
    public static ArrayList<Cell> MinedCells;
    public static ArrayList<Cell> FinalFlaggedCells;
    public static int FlaggedCellsNumber;
    public static int RevealedCellsNumber;

    static public void initializeCells() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public static void init(int row, int column, int minesNumber) {
        rows = row;
        columns = column;
        size = rows * columns;
        MinesNumber = minesNumber;
        cells = new Cell[rows][columns];
        initializeCells();
        MinedCells = new ArrayList<>();
        FinalFlaggedCells = new ArrayList<>();
        FlaggedCellsNumber = 0;
        RevealedCellsNumber = 0;
    }

    static public void DistributeMines(Cell NotMinedCell) {
        int row, column;
        int DistributedMinesNumber = MinesNumber;
        Random random = new Random();
        while (DistributedMinesNumber != 0) {
            row = random.nextInt(Grid.rows);
            column = random.nextInt(Grid.columns);
            if (cells[row][column].getValue() != 'X' && (NotMinedCell.getRow() != row || NotMinedCell.getColumn() != column)) {
                cells[row][column].setValue('X');
                DistributedMinesNumber--;
                MinedCells.add(cells[row][column]);
            }
        }
    }

    static public void DistributeNumbers() {
        int[] dx = {-1, 1, 0, 0, 1, -1, -1, 1};
        int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
        int minesNumber;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                minesNumber = 0;
                for (int k = 0; k < 8; k++) {
                    if (isInsideGrid(dx[k] + i, dy[k] + j)) {
                        if (cells[dx[k] + i][dy[k] + j].getValue() == 'X')
                            minesNumber++;
                    }
                }
                if (minesNumber != 0 && cells[i][j].getValue() != 'X') {
                    cells[i][j].setValue((char) (minesNumber + '0'));
                }
            }
        }
    }

    static public void FloodFill(Player player, int row, int column) {
        if (!isInsideGrid(row, column) || cells[row][column].getValue() == 'X' || cells[row][column].isFlag() || cells[row][column].isRevealed())
            return;
        if (cells[row][column].getValue() > '0' && cells[row][column].getValue() < '9') {
            cells[row][column].setRevealed(true);
            if (Game.ShowMethod.equals("GUI")) {
                GUI.UpdateCell(cells[row][column]);
            }
            RevealedCellsNumber++;
            player.addScore(1);
            return;
        }
        cells[row][column].setRevealed(true);
        if (Game.ShowMethod.equals("GUI")) {
            GUI.UpdateCell(cells[row][column]);
        }
        RevealedCellsNumber++;
        player.addScore(1);
        //System.out.println("Cell row : "+row+" Cell column : "+column);
        FloodFill(player, row + 1, column);
        FloodFill(player, row - 1, column);
        FloodFill(player, row, column + 1);
        FloodFill(player, row, column - 1);
        FloodFill(player, row + 1, column + 1);
        FloodFill(player, row - 1, column + 1);
        FloodFill(player, row + 1, column - 1);
        FloodFill(player, row - 1, column - 1);
    }

    public static void setMinedCellsVisible() {
        for (Cell cell : MinedCells) {
            cell.setRevealed(true);
            if (Game.ShowMethod.equals("GUI")) {
                GUI.UpdateCell(cell);
            }
        }
    }

    static public boolean isInsideGrid(int row, int column) {
        return row < rows && row >= 0 && column >= 0 && column < columns;
    }

    static public void getFinalFlaggedCells() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (cells[i][j].isFlag())
                    FinalFlaggedCells.add(cells[i][j]);
            }
        }
    }


    static public void Explore(Player player, Cell cell) {
        if (cell.isRevealed() || cell.isFlag())
            System.out.println("Not Allowed To Explore All Ready Revealed Cell Or Flagged Cell");
        else if (cell.getValue() == 'X') {
            cell.setRevealed(true);
            Grid.RevealedCellsNumber++;
            if (!Game.Multiplier) {
                Grid.setMinedCellsVisible();
                Rules.GameOver = true;
                Rules.setWin(false);
                Rules.Losers.add(player);
            }
            if (Game.ShowMethod.equals("GUI")) {
                GUI.UpdateCell(cell);
                if (Game.Multiplier)
                    Rules.CountPenalty(player);
            }
        } else if (cell.getValue() > '0' && cell.getValue() < '9') {
            cell.setRevealed(true);
            Grid.RevealedCellsNumber++;
            int points = cell.getValue() - '0';
            player.addScore(points);
            if (Game.ShowMethod.equals("GUI")) {
                GUI.UpdateCell(cell);
            }
        } else {
            Grid.FloodFill(player, cell.getRow(), cell.getColumn());
        }
    }


}
