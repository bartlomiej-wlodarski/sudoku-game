/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import com.mycompany.sudokuproject1.BacktrackingSudokuSolver;
import com.mycompany.sudokuproject1.SudokuBoard;
import com.mycompany.sudokuproject1.SudokuBox;
import com.mycompany.sudokuproject1.SudokuField;
import com.mycompany.sudokuproject1.SudokuSolver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author bawlo
 */
public class SudokuBoxTest {
    
    private SudokuBoard sudoku;
    protected static SudokuBox box;

    @BeforeEach
    public void beforeEach() {
        sudoku = prepareBoard();
        box = sudoku.getBox(0, 0);
    } 

    private SudokuBoard prepareBoard() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(solver);
        return board;
    }

    public SudokuBoxTest() {
    }
    
    @Test
    public void TestEqualsOnTheSameBox() {
        assertSame(true, box.boxEquals(box));
    }
    
    @Test
    public void TestBoxEqualsOnNull() {
        assertFalse(box.boxEquals(null));
    }
    
    @Test
    public void testBoxHashCodeForTheSameObject() {
        assertEquals(box.boxHashCode(), box.boxHashCode());
    }
    
    
    @Test
    public void TestBoxToString() {
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
        SudokuBox box1 = board.getBox(0,0);
        String toString = box1.boxToString();
        assertTrue(toString.contains("SudokuBox"));
        assertTrue(toString.contains("0"));
    }
    
    @Test
    public void TestClone() {
        SudokuBox box1 = new SudokuBox();
        SudokuBox box2 = new SudokuBox();
        SudokuField field = new SudokuField();
        field.setFieldValue(2);
        box1.set(field, 0);
        try {
            box2 = (SudokuBox) box1.cloneBox();
        } catch (CloneNotSupportedException ex) {
        }
        assertEquals(box1, box2);
        box1.set(field, 2);
        assertNotEquals(box1, box2);
    }
    
     @Test
    public void cloneTest() throws CloneNotSupportedException {
        SudokuBox box1 = new SudokuBox();
        SudokuBox box2 = new SudokuBox();
        box2 = (SudokuBox) box1.cloneBox();
        assertNotSame(box1, box2);
    }
    
}
