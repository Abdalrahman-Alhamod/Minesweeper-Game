package Screen;

import Logic.Cell;
import Logic.Grid;
import Logic.Rules;

import java.util.Scanner;

public class Console {
    public static Scanner input = new Scanner(System.in);

    static public String InputShowMethod() {
        int choice;
        System.out.println("Choose Show Method : ");
        System.out.println("1- Console");
        System.out.println("2- GUI");
        System.out.print("Choice : ");
        choice = input.nextInt();
        if (choice == 1) {
            return "Console";
        } else {
            return "GUI";
        }
    }

    static public void StartMessage() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Welcome To Minesweeper");
    }

    static public void PrintGrid() {
        //Clearing The Screen If It Runs From A Terminal
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Printing Characters Starts From A In The First Row Of The Grid
        for (int i = 0; i < Grid.columns; i++) {
            System.out.print("\t" + (char) (i + 65));
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < Grid.rows; i++) {
            //Printing Numbers Starts From 0 In The First Column From The Grid
            System.out.print(i + "\t");
            for (int j = 0; j < Grid.columns; j++) {
                if (Grid.cells[i][j].isRevealed()) {
                    //Printing Revealed Cell According To Its value
                    System.out.print(Grid.cells[i][j].getValue() + "\t");
                } else {
                    //Printing Flagged Cells
                    if (Grid.cells[i][j].isFlag())
                        System.out.print('P' + "\t");
                        //Printing Unrevealed Cells
                    else
                        System.out.print('O' + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
    }

    static public Cell inputCell() {
        int y;
        int x = 0;
        while (true) {
            System.out.print("Enter the cell coordinates : ");
            String cell = input.next();
            y = cell.charAt(1) - 65;
            x = cell.charAt(2) - '0';
            Rules.setFlagRole(false);
            if (cell.charAt(0) == '-') {
                Rules.setFlagRole(true);
            }
            if ((cell.charAt(0) != '-' && cell.charAt(0) != '+') || (y < 0) || (y > Grid.columns) || ((x < 0) || (x > Grid.rows))) {
                System.out.println("Wrong Input, Please Try Again!");

            } else {
                break;
            }
        }
        return Grid.cells[x][y];
    }

    static public String InputPlayerName() {
        System.out.print("Enter Player Name : ");
        String PlayerName = input.next();
        return PlayerName;
    }
}
