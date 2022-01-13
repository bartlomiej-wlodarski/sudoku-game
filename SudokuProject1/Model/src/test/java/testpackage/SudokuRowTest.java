/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import com.mycompany.sudokuproject1.BacktrackingSudokuSolver;
import com.mycompany.sudokuproject1.SudokuBoard;
import com.mycompany.sudokuproject1.SudokuField;
import com.mycompany.sudokuproject1.SudokuSolver;
import com.mycompany.sudokuproject1.SudokuRow;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author bawlo
 */
public class SudokuRowTest {
    
    private SudokuBoard sudoku;
    protected static SudokuRow row;

    @BeforeEach
    public void beforeEach() {
        sudoku = prepareBoard();
        row = sudoku.getRow(0);
    }
    
    private SudokuBoard prepareBoard() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(solver);
        return board;
    }

    public SudokuRowTest() {
    }
    
    @Test
    public void TestEqualsOnTheSameRow() {
        assertSame(true, row.rowEquals(row));
    }
    
    @Test
    public void TestRowEqualsOnNull() {
        assertFalse(row.rowEquals(null));
    }
    
    @Test
    public void testRowHashCodeForTheSameObject() {
        assertEquals(row.rowHashCode(), row.rowHashCode());
    }
    
    @Test
    public void TestRowToString() {
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
        SudokuRow row1 = board.getRow(0);
        String toString = row1.rowToString();
        assertTrue(toString.contains("SudokuRow"));
        assertTrue(toString.contains("0"));
    }
    
    @Test
    public void TestClone() {
        SudokuRow row1 = new SudokuRow();
        SudokuRow row2 = new SudokuRow();
        SudokuField field = new SudokuField();
        field.setFieldValue(2);
        row1.set(field, 0);
        try {
            row2 = (SudokuRow) row1.cloneRow();
        } catch (CloneNotSupportedException ex) {
        }
        assertEquals(row1, row2);
        row1.set(field, 5);
        assertNotEquals(row1, row2);
    }
    
}
