package Logic;

import Screen.GUI;

public class InputCellHandler extends Thread {
    public Cell HandledCell;
    public static int HandledCellsNumber;

    public InputCellHandler(Cell cell) {
        super("Input Cell Handler Thread For Cell[" + cell.getRow() + "][" + cell.getColumn() + "]");
        HandledCellsNumber++;
        HandledCell = cell;
    }

    public void run() {
        if (Game.ShowMethod.equals("GUI")) {
            if (HandledCellsNumber == 1) {
                if (Game.Multiplier)
                    GUI.StartTimer();
                Cell NotMinedCell = HandledCell;
                Grid.DistributeMines(NotMinedCell);
                Grid.DistributeNumbers();
                Grid.Explore(Game.CurrentPlayer, NotMinedCell);
                Rules.SwapPlayer();
            } else {
                Cell Choosencell = HandledCell;
                if (Rules.isFlagRole()) {
                    OperateFlagCell(Choosencell);
                } else {
                    Grid.Explore(Game.CurrentPlayer, Choosencell);
                }
                Rules.CheckWin(Game.CurrentPlayer);
                Rules.CheckGameOver();
                Rules.SwapPlayer();
            }
        }
    }

    public static void OperateFlagCell(Cell choosencell) {
        if (!choosencell.isFlag()) {
            if (!choosencell.isRevealed()) {
                choosencell.setFlag(true);
                if (Game.ShowMethod.equals("GUI")) {
                    GUI.UpdateCell(choosencell);
                }
                Grid.FlaggedCellsNumber++;
            } else {
                System.out.println("Not Allowed Putting A Flag on Revealed Cell");
            }
        } else {
            choosencell.setFlag(false);
            if (Game.ShowMethod.equals("GUI")) {
                GUI.UpdateCell(choosencell);
            }
            Grid.FlaggedCellsNumber--;
        }
    }
}
