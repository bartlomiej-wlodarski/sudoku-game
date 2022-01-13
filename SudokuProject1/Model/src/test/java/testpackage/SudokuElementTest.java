/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import com.mycompany.sudokuproject1.BacktrackingSudokuSolver;
import com.mycompany.sudokuproject1.SudokuBoard;
import com.mycompany.sudokuproject1.SudokuSolver;
import com.mycompany.sudokuproject1.SudokuElement;
import com.mycompany.sudokuproject1.SudokuField;
import com.mycompany.sudokuproject1.SudokuRow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bawlo
 */
public class SudokuElementTest {
    
    private SudokuBoard sudoku;
    protected static SudokuElement element;

    @BeforeEach
    public void beforeEach() {
        sudoku = prepareBoard();
    }

    private SudokuBoard prepareBoard() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(solver);
        return board;
    }

    public SudokuElementTest() {
    }
    
   @Test
   public void TestClone() {
       SudokuElement element1 = new SudokuRow();
       SudokuElement element2 = new SudokuRow();
       SudokuField value = new SudokuField();
        try {
            element2 = (SudokuElement) element1.clone();
        } catch (CloneNotSupportedException ex) {
            assertTrue(false);
        }
       assertEquals(element1, element2);
       value.setFieldValue(3);
       element2.set(value, 0);
       assertNotEquals(element1, element2);
   }
}
