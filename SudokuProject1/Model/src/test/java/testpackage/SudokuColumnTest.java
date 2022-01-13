/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import com.mycompany.sudokuproject1.BacktrackingSudokuSolver;
import com.mycompany.sudokuproject1.SudokuBoard;
import com.mycompany.sudokuproject1.SudokuColumn;
import com.mycompany.sudokuproject1.SudokuField;
import com.mycompany.sudokuproject1.SudokuSolver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author bawlo
 */
public class SudokuColumnTest {
    
    private SudokuBoard sudoku;
    protected static SudokuColumn column;

    @BeforeEach
    public void beforeEach() {
        sudoku = prepareBoard();
        column = sudoku.getColumn(0);
    }

    private SudokuBoard prepareBoard() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(solver);
        return board;
    }

    public SudokuColumnTest() {
    }
    
    @Test
    public void TestEqualsOnTheSameColumn() {
        assertSame(true, column.columnEquals(column));
    }
    
    @Test
    public void TestColumnEqualsOnNull() {
        assertFalse(column.columnEquals(null));
    }
    
    @Test
    public void TestColumnHashCodeForTheSameObject() {
        assertEquals(column.columnHashCode(), column.columnHashCode());
    }
    
    @Test
    public void TestColumnToString() {
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
        SudokuColumn column1 = board.getColumn(0);
        String toString = column1.columnToString();
        assertTrue(toString.contains("SudokuColumn"));
        assertTrue(toString.contains("0"));
    }
    
    @Test
    public void TestClone() {
        SudokuColumn column1 = new SudokuColumn();
        SudokuColumn column2 = new SudokuColumn();
        SudokuField field = new SudokuField();
        field.setFieldValue(2);
        column1.set(field, 0);
        try {
            column2 = (SudokuColumn) column1.cloneColumn();
        } catch (CloneNotSupportedException ex) {
        }
        assertEquals(column1, column2);
        column1.set(field, 5);
        assertNotEquals(column1, column2);
    }
    
    @Test
    public void verifyTest() {
        assertFalse(column.verify());
        for (int i = 0; i < 9; i++) {
            SudokuField field = new SudokuField();
            field.setFieldValue(i + 1);
            column.set(field, i);
        }
        assertTrue(column.verify());
    }
}
