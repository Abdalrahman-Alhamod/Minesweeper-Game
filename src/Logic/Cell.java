package Logic;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    private final int row;
    private final int column;
    private char value;
    private boolean isRevealed;
    private boolean isFlag;
    private Color DisabledTextColor;
    private Color CellColor;

    public Color getCellColor() {
        return CellColor;
    }

    public void setCellColor(Color cellColor) {
        CellColor = cellColor;
    }

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        value = ' ';
        isRevealed = false;
        isFlag = false;
        CellColor = null;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getValue() {
        return value;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean isRevealed) {
        this.isRevealed = isRevealed;
    }

}