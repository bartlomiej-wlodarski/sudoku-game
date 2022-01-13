package com.mycompany.sudokuproject1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Summary of a class in JavaDoc.
 *
 * @author bawlo
 */
public final class SudokuBoard extends Object implements Observable, Serializable, Cloneable {

    private final Set<Observer> observers = new HashSet<>();
    private List<SudokuField> board;
    private List<SudokuRow> row;
    private List<SudokuColumn> column;
    private List<SudokuBox> box;
    private final SudokuSolver solver;

    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(Observer::update);
    }

    public SudokuBoard(SudokuSolver solver) {
        this.solver = solver;

        //initialize temporary arrays
        List<SudokuRow> rowTemp = Arrays.asList(new SudokuRow[9]);
        List<SudokuColumn> columnTemp = Arrays.asList(new SudokuColumn[9]);
        List<SudokuBox> boxTemp = Arrays.asList(new SudokuBox[9]);
        for (int i = 0; i < 9; i++) {
            rowTemp.set(i, new SudokuRow());
            columnTemp.set(i, new SudokuColumn());
            boxTemp.set(i, new SudokuBox());
        }
        row = Collections.unmodifiableList(rowTemp);
        column = Collections.unmodifiableList(columnTemp);
        box = Collections.unmodifiableList(boxTemp);

        //initialize board
        List<SudokuField> boardTemp = Arrays.asList(new SudokuField[81]);
        for (int i = 0; i < 81; i++) {
            boardTemp.set(i, new SudokuField());
        }
        board = Collections.unmodifiableList(boardTemp);

        //connect elements with board
        for (int i = 0; i < 81; i++) {
            this.getColumn(i / 9).set(board.get(i), i % 9);
            this.getRow(i % 9).set(board.get(i), i / 9);
            this.getBox(i / 27, (i / 3) % 3).set(board.get(i), ((i / 9) % 3) * 3 + (i % 3));
        }

        //attach elements to observer pattern
        for (int i = 0; i < 9; i++) {
            this.attach(box.get(i));
            this.attach(row.get(i));
            this.attach(column.get(i));
        }
    }

    public int get(int x, int y) {
        return board.get(y * 9 + x).getFieldValue();
    }

    public void set(int x, int y, int value) {
        int pos = y * 9 + x;
        board.get(pos).setFieldValue(value);
        board.get(pos).setLocked(false);
        notifyObservers();
    }
    
    public boolean isLocked(int x, int y) {
        return board.get(y * 9 + x).isLocked();
    }
    
    public void lockAllFields() {
        for (int i = 0; i < 81; i++) {
            board.get(i).setLocked(true);
        }
    }

    public void solveGame() {
        solver.solve(this);
    }

    public boolean checkBoard() {
        for (int i = 0; i < 9; i++) {
            if (!getRow(i).verify()) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!getColumn(i).verify()) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!getBox(i, j).verify()) {
                    return false;
                }
            }
        }
        return true;
    }

    public SudokuRow getRow(int y) {
        return row.get(y);
    }

    public SudokuColumn getColumn(int x) {
        return column.get(x);
    }

    public SudokuBox getBox(int x, int y) {
        return box.get(x + 3 * y);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(System.getProperty("line.separator"))
                .append(row.get(0))
                .append(System.getProperty("line.separator"))
                .append(row.get(1))
                .append(System.getProperty("line.separator"))
                .append(row.get(2))
                .append(System.getProperty("line.separator"))
                .append(row.get(3))
                .append(System.getProperty("line.separator"))
                .append(row.get(4))
                .append(System.getProperty("line.separator"))
                .append(row.get(5))
                .append(System.getProperty("line.separator"))
                .append(row.get(6))
                .append(System.getProperty("line.separator"))
                .append(row.get(7))
                .append(System.getProperty("line.separator"))
                .append(row.get(8))
                .toString();
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        SudokuBoard clone = (SudokuBoard) super.clone();
        List<SudokuField> boardTemp = Arrays.asList(new SudokuField[81]);
        for (int i = 0; i < 81; i++) {
            boardTemp.set(i, (SudokuField) this.board.get(i).clone());
        }
        clone.board = Collections.unmodifiableList(boardTemp);
        
        List<SudokuRow> rowTemp = Arrays.asList(new SudokuRow[9]);
        List<SudokuColumn> columnTemp = Arrays.asList(new SudokuColumn[9]);
        List<SudokuBox> boxTemp = Arrays.asList(new SudokuBox[9]);
        for (int i = 0; i < 9; i++) {
            rowTemp.set(i, (SudokuRow) this.row.get(i).clone());
            columnTemp.set(i, (SudokuColumn) this.column.get(i).clone());
            boxTemp.set(i, (SudokuBox) this.box.get(i).clone());
        }
        clone.row = Collections.unmodifiableList(rowTemp);
        clone.column = Collections.unmodifiableList(columnTemp);
        clone.box = Collections.unmodifiableList(boxTemp);
        
        for (int i = 0; i < 81; i++) {
            clone.getColumn(i / 9).set(clone.board.get(i), i % 9);
            clone.getRow(i % 9).set(clone.board.get(i), i / 9);
            clone.getBox(i / 27, (i / 3) % 3).set(clone.board.get(i), ((i / 9) % 3) * 3 + (i % 3));
        }
        
        return clone;
    }
}
